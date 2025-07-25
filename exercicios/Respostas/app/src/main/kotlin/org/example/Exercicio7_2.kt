

import kotlin.collections.listOf
fun main() {

  // Função auxiliar para verificar os resultados dos testes (não modifique)
  fun assertEquals(funcao: String, esperado: Any, resultado: Any) {
      if (esperado != resultado) {
          throw AssertionError("Falha em $funcao: Esperado $esperado, Obtido $resultado")
      }
  }

  /**
   * Função que recebe uma lista L de inteiros e retorna um booleano indicando se a lista está 
   * ordenada de forma crescente.
   * Versão usando recursão de cauda.
   * Dica: Uma opção é passar para a função auxiliar recursiva uma lista com os elementos ainda
   *       não acessados de L e o elemento anterior.
   */
  fun estaOrdenadaCrescente(lista: List<Int>): Boolean {
    tailrec fun ordenaLista(naoAcessados: List<Int>, elementoAnterior: Int): Boolean {
        if (naoAcessados.isEmpty()) {
            return true
        }
        val cabeca = naoAcessados.first()
        val cauda = naoAcessados.drop(1)

        if (elementoAnterior > cabeca) {
            return false
        } else{
            return ordenaLista(cauda, cabeca)
        }
    }
    return ordenaLista(lista, 0)
  }

  // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
  
  assertEquals("estaOrdenadaCrescente(listOf(1, 1, 2, 3))", true, estaOrdenadaCrescente(listOf(1, 1, 2, 3)))
  assertEquals("estaOrdenadaCrescente(listOf(1, 2, 6, 8, 3))", false, estaOrdenadaCrescente(listOf(1, 2, 6, 8, 3)))
  assertEquals("estaOrdenadaCrescente(listOf(500))", true, estaOrdenadaCrescente(listOf(500)))
  assertEquals("estaOrdenadaCrescente(listOf(1, 2, 6, 12, 45, 54, 99, 100))", true, estaOrdenadaCrescente(listOf(1, 2, 6, 12, 45, 54, 99, 100)))
  assertEquals("estaOrdenadaCrescente(listOf(2, 3, 4, 1))", false, estaOrdenadaCrescente(listOf(2, 3, 4, 1)))
  assertEquals("estaOrdenadaCrescente(listOf(1, 6, 2, 8, 3))", false, estaOrdenadaCrescente(listOf(1, 6, 2, 8, 3)))
  assertEquals("estaOrdenadaCrescente(listOf(1, 3, 2, 4, 5))", false, estaOrdenadaCrescente(listOf(1, 3, 2, 4, 5)))
  println("Todos os testes passaram para a função estaOrdenadaCrescente!")
  

  /**
   * Função que recebe uma lista L de inteiros e um inteiro K, e retorna um Pair contendo
   * uma lista com os elementos de L que são menores ou iguais a K, e outra com os elementos
   * de L que são maiores que K, na mesma ordem que ocorrem em L.
   * Versão usando recursão de cauda.
   * Dica: Uma opção é passar para a função auxiliar recursiva uma lista com os elementos ainda
   *       não acessados de L e duas novas listas com os elementos menores ou iguais a K e maiores 
   *       que K encontrados até então.
   */
  fun particao(lista: List<Int>, K: Int): Pair<List<Int>, List<Int>> {
    tailrec fun particaoLista(naoAcessados: List<Int>, menoresK: List<Int>, maioresK: List<Int>, aux: Int): Pair<List<Int>, List<Int>>  {
        if (naoAcessados.isEmpty()) {
            return Pair(maioresK, menoresK)
        }
        val cabeca = naoAcessados.first()
        val cauda = naoAcessados.drop(1)

        if (aux < cabeca) {
            return particaoLista(cauda, menoresK + listOf(cabeca), maioresK, aux)
        } 
        if (aux > cabeca){
            return particaoLista(cauda, menoresK, maioresK + listOf(cabeca), aux)
        }

        return particaoLista(cauda, menoresK, maioresK + listOf(cabeca), aux)
    }
    return particaoLista(lista, emptyList(), emptyList(), K)
  }

  // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
  
  assertEquals("particao(listOf(1, 2, 3, 4, 5), 3)", Pair(listOf(1, 2, 3), listOf(4, 5)), particao(listOf(1, 2, 3, 4, 5), 3))
  assertEquals("particao(listOf(1, 2, 3, 4, 5), 1)", Pair(listOf(1), listOf(2, 3, 4, 5)), particao(listOf(1, 2, 3, 4, 5), 1))
  println("Todos os testes passaram para a função particao!")
  

  /**
   * Função que recebe uma lista L de inteiros e retorna um Pair contendo uma lista com os valores
   * ímpares de L e outra com os valores pares de L, na mesma ordem que ocorrem em L.
   * Versão usando recursão de cauda.
   * Dica: Uma opção é passar para a função auxiliar recursiva uma lista com os elementos ainda
   *       não acessados de L e duas novas listas com os elementos pares e ímpares encontrados até então.
   */
  fun separarParesImpares(lista: List<Int>): Pair<List<Int>, List<Int>> {
    tailrec fun parImpar(naoAcessados: List<Int>, pares: List<Int>, impares: List<Int>): Pair<List<Int>, List<Int>>  {
        if (naoAcessados.isEmpty()) {
            return Pair(impares, pares)
        }
        val cabeca = naoAcessados.first()
        val cauda = naoAcessados.drop(1)

        if (cabeca % 2 == 0) {
            return parImpar(cauda, pares + listOf(cabeca), impares)
        } else {
            return parImpar(cauda, pares, impares + listOf(cabeca))
        }
    }
    return parImpar(lista, emptyList(), emptyList())
  }

  // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
  
  assertEquals("separarParesImpares(listOf(1, 2))", Pair(listOf(1), listOf(2)), separarParesImpares(listOf(1, 2)))
  assertEquals("separarParesImpares(listOf(1, 5, 4, 3))", Pair(listOf(1, 5, 3), listOf(4)), separarParesImpares(listOf(1, 5, 4, 3)))
  assertEquals("separarParesImpares(listOf(9, 6, 4, 8, 1, 2))", Pair(listOf(9, 1), listOf(6, 4, 8, 2)), separarParesImpares(listOf(9, 6, 4, 8, 1, 2)))
  assertEquals("separarParesImpares(listOf(9, 6, 4, 8, 1, 2, 1))", Pair(listOf(9, 1, 1), listOf(6, 4, 8, 2)), separarParesImpares(listOf(9, 6, 4, 8, 1, 2, 1)))
  println("Todos os testes passaram para a função separarParesImpares!")
  

  /**
   * Em uma rua as casas são numeradas de 0 até N-1.
   * Cada caminhão abastece com L litros de água da casa A até B (inclusive).
   * Assumindo que cada casa começa com 0 litros de água, escreva uma função que recebe
   * o número de casas N, e uma lista de Triple com os valores de A, B e L de cada caminhão,
   * e retorna uma lista com a quantidade de água em cada casa após todos os caminhões passarem.
   *
   * Versão usando recursão de cauda.
   * Crie duas funções recursivas auxiliares: uma para fazer todas as entregas de um único caminhão
   * e outra para entregar a água de todos os caminhões (chamando a função anterior).
   *
   * Dica: Para criar uma lista contendo N zeros, você pode usar `List(N) { 0 }`.
   */
  fun abastecimentoCasas(N: Int, caminhoes: List<Triple<Int, Int, Int>>): List<Int> {
    tailrec fun entregaUnica(numCasa: Int, caminhao: Triple<Int, Int, Int>, acumulador: List<Int>): List<Int>  {
        val (casaA, casaB, litros) = caminhao

        // Caso base: Se a casa atual já passou do final do intervalo (B),
        // a entrega deste caminhão terminou. Retorna o estado final.
        if (numCasa > casaB) {
            return acumulador
        }

        // Cria uma lista mutável para poder alterar o valor em um índice específico.
        val casasAtualizadas = acumulador.toMutableList()
        
        // Adiciona os litros na casa atual.
        casasAtualizadas[numCasa] = acumulador[numCasa] + litros

        // Chamada recursiva para a próxima casa do intervalo (casaAtual + 1).
        return entregaUnica(numCasa + 1, caminhao, casasAtualizadas.toList())
    }

    tailrec fun entregaTotal(caminhoes: List<Triple<Int, Int, Int>>, acumulador: List<Int>): List<Int> {
        // Caso base: Se não há mais caminhões na lista, o processo terminou.
        if (caminhoes.isEmpty()) {
            return acumulador
        }
        val cabeca = caminhoes.first()
        val cauda = caminhoes.drop(1)
        val (casaA, _, _) = cabeca

        // Chama a função interna para aplicar a entrega do caminhão atual.
        // A entrega começa na casa inicial 'casaA' do caminhão.
        val casasDepoisDaEntrega = entregaUnica(casaA, cabeca, acumulador)

        // Chamada recursiva para processar o resto dos caminhões,
        // passando o estado atualizado das casas.
        return entregaTotal(cauda, casasDepoisDaEntrega)
    }
    // Ponto de partida:
    // 1. Cria a lista inicial com N casas, todas com 0 litros.
    // 2. Inicia o processo chamando a função que itera sobre os caminhões.
    val casasIniciais = List(N) { 0 }
    return entregaTotal(caminhoes, casasIniciais)
  }

  // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
  
  assertEquals("abastecimentoCasas(7, listOf(Triple(0, 2, 4), Triple(5, 6, 5)))", listOf(4, 4, 4, 0, 0, 5, 5), abastecimentoCasas(7, listOf(Triple(0, 2, 4), Triple(5, 6, 5))))
  assertEquals("abastecimentoCasas(5, listOf(Triple(0, 4, 50)))", listOf(50, 50, 50, 50, 50), abastecimentoCasas(5, listOf(Triple(0, 4, 50))))
  assertEquals("abastecimentoCasas(6, listOf(Triple(0, 5, 1), Triple(1, 5, 1), Triple(2, 5, 1), Triple(3, 5, 1), Triple(4, 5, 1), Triple(5, 5, 1)))", listOf(1, 2, 3, 4, 5, 6), abastecimentoCasas(6, listOf(Triple(0, 5, 1), Triple(1, 5, 1), Triple(2, 5, 1), Triple(3, 5, 1), Triple(4, 5, 1), Triple(5, 5, 1))))
  assertEquals("abastecimentoCasas(10, listOf(Triple(1, 4, 5), Triple(5, 8, 2), Triple(0, 9, 1), Triple(8, 9, 3), Triple(4, 8, 2)))", listOf(1, 6, 6, 6, 8, 5, 5, 5, 8, 4), abastecimentoCasas(10, listOf(Triple(1, 4, 5), Triple(5, 8, 2), Triple(0, 9, 1), Triple(8, 9, 3), Triple(4, 8, 2))))
  assertEquals("abastecimentoCasas(20, listOf(Triple(1, 19, 5), Triple(7, 12, 10), Triple(0, 3, 30), Triple(8, 19, 3), Triple(0, 2, 8), Triple(6, 9, 4)))", listOf(38, 43, 43, 35, 5, 5, 9, 19, 22, 22, 18, 18, 18, 8, 8, 8, 8, 8, 8, 8), abastecimentoCasas(20, listOf(Triple(1, 19, 5), Triple(7, 12, 10), Triple(0, 3, 30), Triple(8, 19, 3), Triple(0, 2, 8), Triple(6, 9, 4))))
  assertEquals("abastecimentoCasas(10, listOf(Triple(1, 3, 13), Triple(4, 5, 30), Triple(0, 3, 20), Triple(0, 0, 5), Triple(8, 9, 27), Triple(3, 8, 12), Triple(3, 9, 25), Triple(6, 7, 2), Triple(2, 3, 13), Triple(4, 7, 8), Triple(6, 6, 7), Triple(1, 5, 4), Triple(4, 8, 2), Triple(5, 9, 17), Triple(0, 3, 8)))", listOf(33, 45, 58, 95, 81, 98, 73, 66, 83, 69), abastecimentoCasas(10, listOf(Triple(1, 3, 13), Triple(4, 5, 30), Triple(0, 3, 20), Triple(0, 0, 5), Triple(8, 9, 27), Triple(3, 8, 12), Triple(3, 9, 25), Triple(6, 7, 2), Triple(2, 3, 13), Triple(4, 7, 8), Triple(6, 6, 7), Triple(1, 5, 4), Triple(4, 8, 2), Triple(5, 9, 17), Triple(0, 3, 8))))
  println("Todos os testes passaram para a função abastecimentoCasas!")
  
}