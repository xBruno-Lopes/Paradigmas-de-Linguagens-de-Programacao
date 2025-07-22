
/***********************************************************************************************************************
 ** EXERCÍCIO **

Aqui estão seis palavras italianas:
    astante , astoria , baratto , cobalto , pistola , statale .

Elas devem ser organizadas como palavras cruzadas, na seguinte grade:

         V1      V2      V3
        +---+   +---+   +---+
        | X |   | X |   | X |
    +---+---+---+---+---+---+---+
H1  | X | X | X | X | X | X | X |
    +---+---+---+---+---+---+---+
        | X |   | X |   | X |  
    +---+---+---+---+---+---+---+
H2  | X | X | X | X | X | X | X |
    +---+---+---+---+---+---+---+
        | X |   | X |   | X |
    +---+---+---+---+---+---+---+
H3  | X | X | X | X | X | X | X |
    +---+---+---+---+---+---+---+
        | X |   | X |   | X |
        +---+   +---+   +---+

A base de conhecimento abaixo separa as letras de cada palavra.
Escreva o predicado 'palavras_cruzadas(H1,H2,H3,V1,V2,V3)' que nos diga como preencher a grade. 
Os três primeiros argumentos devem ser as palavras horizontais de cima para baixo, e os três últimos argumentos as 
palavras verticais da esquerda para a direita.

Cada palavra ocorre exatamente uma vez na grade.
Portanto, será necessário acrescentar uma restrição para cada um dos 15 pares de palavras, indicando que elas não podem 
ser iguais. Ex.: H1 \= H2.
**IMPORTANTE**: Estas condições devem ser adicionadas no final do predicado 'palavras_cruzadas': o operador '\=' retorna 
verdadeiro quando os operandos não são unificáveis, mas variáveis livres são sempre unificáveis, portanto o correto é 
gerar os valores das variáveis antes de testar que elas não unificam.
***********************************************************************************************************************/

palavra(astante,  a,s,t,a,n,t,e).  
palavra(astoria,  a,s,t,o,r,i,a).  
palavra(baratto,  b,a,r,a,t,t,o).  
palavra(cobalto,  c,o,b,a,l,t,o).  
palavra(pistola,  p,i,s,t,o,l,a).  
palavra(statale,  s,t,a,t,a,l,e).


% <FORNEÇA AQUI SUA SOLUÇÃO>
palavras_cruzadas(H1, H2, H3, V1, V2, V3) :-
    % 1. Atribui uma palavra da base de conhecimento a cada variável (H1, H2, H3, V1, V2, V3)
    %    e decompõe cada palavra em suas letras. Usamos '_' para as letras que não
    %    fazem parte de uma interseção.
    palavra(H1, _, H1L2, _, H1L4, _, H1L6, _),
    palavra(H2, _, H2L2, _, H2L4, _, H2L6, _),
    palavra(H3, _, H3L2, _, H3L4, _, H3L6, _),
    palavra(V1, V1L1, V1L2, V1L3, _, _, _, _),
    palavra(V2, V2L1, V2L2, V2L3, _, _, _, _),
    palavra(V3, V3L1, V3L2, V3L3, _, _, _, _),

    % 2. Define as restrições de interseção com base na grade.
    %    A letra na interseção deve ser a mesma para ambas as palavras.

    % Interseções com H1
    H1L2 = V1L1, % 2ª letra de H1 é a 1ª de V1
    H1L4 = V2L1, % 4ª letra de H1 é a 1ª de V2
    H1L6 = V3L1, % 6ª letra de H1 é a 1ª de V3

    % Interseções com H2
    H2L2 = V1L2, % 2ª letra de H2 é a 2ª de V1
    H2L4 = V2L2, % 4ª letra de H2 é a 2ª de V2
    H2L6 = V3L2, % 6ª letra de H2 é a 2ª de V3

    % Interseções com H3
    H3L2 = V1L3, % 2ª letra de H3 é a 3ª de V1
    H3L4 = V2L3, % 4ª letra de H3 é a 3ª de V2
    H3L6 = V3L3, % 6ª letra de H3 é a 3ª de V3

    % 3. Garante que todas as 6 palavras escolhidas sejam distintas.
    %    Esta verificação deve vir por último, após as variáveis terem sido instanciadas.
    H1 \= H2, H1 \= H3, H1 \= V1, H1 \= V2, H1 \= V3,
    H2 \= H3, H2 \= V1, H2 \= V2, H2 \= V3,
    H3 \= V1, H3 \= V2, H3 \= V3,
    V1 \= V2, V1 \= V3,
    V2 \= V3.


/***********************************************************************************************************************
 * CASOS DE TESTE (não modifique o restante do arquivo)
 * Para executar os testes, use o comando abaixo no terminal:
 *    $ swi-prolog.swipl -s <nome_do_arquivo.pl> -g "run_tests" -t halt
 **********************************************************************************************************************/

:- use_module(library(plunit)).
:- begin_tests(exercicio).

test('todas as solucoes possiveis', [
    set([H1,H2,H3,V1,V2,V3] == [[astante,cobalto,pistola,astoria,baratto,statale],
                                [astoria,baratto,statale,astante,cobalto,pistola]])
]) :- palavras_cruzadas(H1,H2,H3,V1,V2,V3).

:- end_tests(exercicio).
