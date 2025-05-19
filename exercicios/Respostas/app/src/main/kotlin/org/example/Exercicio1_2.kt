import kotlin.math.pow
import kotlin.math.sqrt

fun main() {

    // Função auxiliar para verificar os resultados dos testes (não modifique)
    fun assertEquals(funcao: String, esperado: Any, resultado: Any) {
        if (esperado != resultado) {
            throw AssertionError("Falha em $funcao: Esperado $esperado, Obtido $resultado")
        }
    }

    /**
     * Forneça a função `distancia`, que recebe dois pontos no plano `(x1,y1)` e `(x2,y2)` (ou seja, recebe dois Pairs com dois elementos cada), e retorna a distância entre estes pontos, dada pela fórmula sqrt((x1?x2)^2+(y1?y2)^2).
     * Obs.: `sqrt` é a função que fornece a raiz quadrada.
     * Ex: distancia((3,7), (1,4)) retorna 3.605551275463989.
     */
    fun distancia(ponto1: Pair<Double, Double>, ponto2: Pair<Double, Double>): Double {
        val p1 = (ponto1.first - ponto2.first).pow(2.0)
        val p2 = (ponto1.second - ponto2.second).pow(2.0)
        val res = sqrt(p1 + p2)
        return res
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

   assertEquals("distancia((3,7), (1,4))", 3.605551275463989, distancia(Pair(3.0, 7.0), Pair(1.0, 4.0)))
   assertEquals("distancia((7,3), (4,-1))", 5.0, distancia(Pair(7.0, 3.0), Pair(4.0, -1.0)))
   assertEquals("distancia((1,8), (-4,12))", 6.4031242374328485, distancia(Pair(1.0, 8.0), Pair(-4.0, 12.0)))
   assertEquals("distancia((0,0), (0,0))", 0.0, distancia(Pair(0.0, 0.0), Pair(0.0, 0.0)))
   assertEquals("distancia((47.88,43.91), (34.8,40.02))", 13.646189944449699, distancia(Pair(47.88, 43.91), Pair(34.8, 40.02)))
   println("Todos os testes passaram para a função distancia!")


    /**
     * Crie uma função que calcule a potencia de um numero (apenas chame uma função da biblioteca padrão).
     * Obs.: Use a função `pow` do Double para calcular a potência (ex.: 2.0.pow(3)), mas lembre-se que ela retorna um Double.
     *       Para converter para Int, use a função `toInt()`.
     * Ex.: calcularPotencia(2, 5) retorna 32.
     */
    fun calcularPotencia(base: Int, expoente: Int): Int {
        val res = (base * 1.0).pow(expoente)
        return res.toInt()
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("calcularPotencia(2, 5)", 32, calcularPotencia(2, 5))
    assertEquals("calcularPotencia(3, 4)", 81, calcularPotencia(3, 4))
    assertEquals("calcularPotencia(5, 3)", 125, calcularPotencia(5, 3))
    assertEquals("calcularPotencia(10, 2)", 100, calcularPotencia(10, 2))
    assertEquals("calcularPotencia(2, 0)", 1, calcularPotencia(2, 0))
    println("Todos os testes passaram para a função calcularPotencia!")


    /**
     * Inicialize duas variáveis inteiras com valores recebidos como parâmetro,
     * troque os valores destas duas variáveis, em seguida retorne um Pair com os valores delas
     * (na mesma ordem em que foram declaradas).
     */
    fun trocarValores(a: Int, b: Int): Pair<Int, Int> {
        var valor1 = a
        var valor2 = b
        var aux: Int

        aux = valor1
        valor1 = valor2
        valor2 = aux
        return Pair(valor1, valor2)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
    
    assertEquals("trocarValores(2, 3)", Pair(3, 2), trocarValores(2, 3))
    assertEquals("trocarValores(1, 2)", Pair(2, 1), trocarValores(1, 2))
    assertEquals("trocarValores(1, 1)", Pair(1, 1), trocarValores(1, 1))
    assertEquals("trocarValores(0, 0)", Pair(0, 0), trocarValores(0, 0))
    println("Todos os testes passaram para a função trocarValores!")
    

    /**
     * Dados dois inteiros 'a' e 'b' recebidos como entrada,
     * retorne um Triple contendo o resultado da divisão inteira, o resto da divisão
     * e o resultado da divisão fracionária de 'a' por 'b'.
     */
    fun calcularDivisao(a: Int, b: Int): Triple<Int, Int, Double> {
        val divisao = a / b
        val resto = a % b
        val frac: Double = (a * 1.0) / (b * 1.0)
        return Triple(divisao, resto, frac)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
    
    assertEquals("calcularDivisao(7, 3)", Triple(2, 1, 7.0 / 3.0), calcularDivisao(7, 3))
    assertEquals("calcularDivisao(10, 2)", Triple(5, 0, 5.0), calcularDivisao(10, 2))
    assertEquals("calcularDivisao(5, 3)", Triple(1, 2, 5.0 / 3.0), calcularDivisao(5, 3))
    println("Todos os testes passaram para a função calcularDivisao!")
    

    /**
     * Escreva uma função para auxiliar vendedores. A partir de um valor total recebido, retornar:
     * - o total a pagar com desconto de 10% (para o caso de venda à vista);
     * - o valor de cada parcela, no parcelamento em 3 x sem juros;
     * - a comissão do vendedor, no caso da venda ser à vista (5% sobre o valor com desconto )
     * - a comissão do vendedor, no caso da venda ser parcelada (5% sobre o valor total)
     */
    fun calcularValores(valorTotal: Double): Triple<Double, Double, Pair<Double, Double>> {
        val totoalPagar = valorTotal * 0.9
        val valorParcela = valorTotal / 3
        val comissaoVendedorAVista = totoalPagar * 0.05
        val comissaoVendedorAPrazo = valorTotal * 0.05
        return Triple(totoalPagar, valorParcela, Pair(comissaoVendedorAVista, comissaoVendedorAPrazo))
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
    
    assertEquals("calcularValores(100.0)", Triple(90.0, 100.0 / 3.0, Pair(4.5, 5.0)), calcularValores(100.0))
    assertEquals("calcularValores(200.0)", Triple(180.0, 200.0 / 3.0, Pair(9.0, 10.0)), calcularValores(200.0))
    assertEquals("calcularValores(300.0)", Triple(270.0, 100.0, Pair(13.5, 15.0)), calcularValores(300.0))
    println("Todos os testes passaram para a função calcularValores!")
    

}