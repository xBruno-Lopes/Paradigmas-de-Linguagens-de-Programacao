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
     * Versão usando comandos de repetição.
     */
    fun estaOrdenadaCrescente(lista: List<Int>): Boolean {
        var index = 0
        while (index < lista.size - 1){
            if (lista[index] > lista[index + 1]) return false
            index++
        }
        return true
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("estaOrdenadaCrescente([1, 1, 2, 3])", true, estaOrdenadaCrescente(listOf(1, 1, 2, 3)))
    assertEquals("estaOrdenadaCrescente([1, 2, 6, 8, 3])", false, estaOrdenadaCrescente(listOf(1, 2, 6, 8, 3)))
    assertEquals("estaOrdenadaCrescente([500])", true, estaOrdenadaCrescente(listOf(500)))
    assertEquals("estaOrdenadaCrescente([1, 2, 6, 12, 45, 54, 99, 100])", true, estaOrdenadaCrescente(listOf(1, 2, 6, 12, 45, 54, 99, 100)))
    assertEquals("estaOrdenadaCrescente([2, 3, 4, 1])", false, estaOrdenadaCrescente(listOf(2, 3, 4, 1)))
    assertEquals("estaOrdenadaCrescente([1, 6, 2, 8, 3])", false, estaOrdenadaCrescente(listOf(1, 6, 2, 8, 3)))
    assertEquals("estaOrdenadaCrescente([1, 3, 2, 4, 5])", false, estaOrdenadaCrescente(listOf(1, 3, 2, 4, 5)))
    println("Todos os testes passaram para a função estaOrdenadaCrescente!")


    /**
     * Função que recebe uma lista L de inteiros e um inteiro K, e retorna um Pair contendo
     * uma lista com os elementos de L que são menores ou iguais a K, e outra com os elementos
     * de L que são maiores que K, na mesma ordem que ocorrem em L.
     * Versão usando comandos de repetição.
     */
    fun particao(lista: List<Int>, K: Int): Pair<List<Int>, List<Int>> {
        val newList: MutableList<Int> = mutableListOf()
        val newList2: MutableList<Int> = mutableListOf()
        for (item in lista){
            if(item <= K) {
                newList.add(item)
            } else {
                newList2.add(item)
            }
        }
        return Pair(newList, newList2)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("particao([1, 2, 3, 4, 5], 3)", Pair(listOf(1, 2, 3), listOf(4, 5)), particao(listOf(1, 2, 3, 4, 5), 3))
    assertEquals("particao([1, 2, 3, 4, 5], 1)", Pair(listOf(1), listOf(2, 3, 4, 5)), particao(listOf(1, 2, 3, 4, 5), 1))
    assertEquals("particao([1, 2, 3, 4, 5], 5)", Pair(listOf(1, 2, 3, 4, 5), listOf<Int>()), particao(listOf(1, 2, 3, 4, 5), 5))
    assertEquals("particao([1, 2, 3, 4, 5], 0)", Pair(listOf<Int>(), listOf(1, 2, 3, 4, 5)), particao(listOf(1, 2, 3, 4, 5), 0))
    assertEquals("particao([1, 2, 3, 4, 5], 10)", Pair(listOf(1, 2, 3, 4, 5), listOf<Int>()), particao(listOf(1, 2, 3, 4, 5), 10))
    println("Todos os testes passaram para a função particao!")


    /**
     * Função que recebe uma lista L de inteiros e retorna um Pair contendo uma lista com os valores
     * ímpares de L e outra com os valores pares de L, na mesma ordem que ocorrem em L.
     * Versão usando comandos de repetição.
     */
    fun separarParesImpares(lista: List<Int>): Pair<List<Int>, List<Int>> {
        val newList: MutableList<Int> = mutableListOf()
        val newList2: MutableList<Int> = mutableListOf()
        for (item in lista){
            if(item % 2 == 0) {
                newList.add(item)
            } else {
                newList2.add(item)
            }
        }
        return Pair(newList2, newList)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("separarParesImpares([1, 2])", Pair(listOf(1), listOf(2)), separarParesImpares(listOf(1, 2)))
    assertEquals("separarParesImpares([1, 5, 4, 3])", Pair(listOf(1, 5, 3), listOf(4)), separarParesImpares(listOf(1, 5, 4, 3)))
    assertEquals("separarParesImpares([9, 6, 4, 8, 1, 2])", Pair(listOf(9, 1), listOf(6, 4, 8, 2)), separarParesImpares(listOf(9, 6, 4, 8, 1, 2)))
    assertEquals("separarParesImpares([9, 6, 4, 8, 1, 2, 1])", Pair(listOf(9, 1, 1), listOf(6, 4, 8, 2)), separarParesImpares(listOf(9, 6, 4, 8, 1, 2, 1)))
    assertEquals("separarParesImpares([1, 1])", Pair(listOf(1, 1), listOf<Int>()), separarParesImpares(listOf(1, 1)))
    assertEquals("separarParesImpares([2, 2])", Pair(listOf<Int>(), listOf(2, 2)), separarParesImpares(listOf(2, 2)))
    println("Todos os testes passaram para a função separarParesImpares!")


    /**
     * Em uma rua as casas são numeradas de 0 até N-1.
     * Cada caminhão abastece com L litros de água da casa A até B (inclusive).
     * Assumindo que cada casa começa com 0 litros de água, escreva uma função que recebe
     * o número de casas N, e uma lista de Triple com os valores de A, B e L de cada caminhão,
     * e retorna uma lista com a quantidade de água em cada casa após todos os caminhões passarem.
     * Versão usando comandos de repetição.
     */
    fun abastecimentoCasas(N: Int, caminhoes: List<Triple<Int, Int, Int>>): List<Int> {
        val newList: MutableList<Int> = mutableListOf()

        for (casa in 0..<N){
            var totalAguaDaCasa = 0
            for (truck in caminhoes){
                if (casa in truck.first..truck.second) {
                    totalAguaDaCasa += truck.third
                }
            }
            newList.add(totalAguaDaCasa)
        }
        return newList
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("abastecimentoCasas(7, listOf(Triple(0, 2, 4), Triple(5, 6, 5)))", listOf(4, 4, 4, 0, 0, 5, 5), abastecimentoCasas(7, listOf(Triple(0, 2, 4), Triple(5, 6, 5))))
    assertEquals("abastecimentoCasas(5, listOf(Triple(0, 4, 50)))", listOf(50, 50, 50, 50, 50), abastecimentoCasas(5, listOf(Triple(0, 4, 50))))
    assertEquals("abastecimentoCasas(6, listOf(Triple(0, 5, 1), Triple(1, 5, 1), Triple(2, 5, 1), Triple(3, 5, 1), Triple(4, 5, 1), Triple(5, 5, 1)))", listOf(1, 2, 3, 4, 5, 6), abastecimentoCasas(6, listOf(Triple(0, 5, 1), Triple(1, 5, 1), Triple(2, 5, 1), Triple(3, 5, 1), Triple(4, 5, 1), Triple(5, 5, 1))))
    assertEquals("abastecimentoCasas(10, listOf(Triple(1, 4, 5), Triple(5, 8, 2), Triple(0, 9, 1), Triple(8, 9, 3), Triple(4, 8, 2)))", listOf(1, 6, 6, 6, 8, 5, 5, 5, 8, 4), abastecimentoCasas(10, listOf(Triple(1, 4, 5), Triple(5, 8, 2), Triple(0, 9, 1), Triple(8, 9, 3), Triple(4, 8, 2))))
    assertEquals("abastecimentoCasas(20, listOf(Triple(1, 19, 5), Triple(7, 12, 10), Triple(0, 3, 30), Triple(8, 19, 3), Triple(0, 2, 8), Triple(6, 9, 4)))", listOf(38, 43, 43, 35, 5, 5, 9, 19, 22, 22, 18, 18, 18, 8, 8, 8, 8, 8, 8, 8), abastecimentoCasas(20, listOf(Triple(1, 19, 5), Triple(7, 12, 10), Triple(0, 3, 30), Triple(8, 19, 3), Triple(0, 2, 8), Triple(6, 9, 4))))
    assertEquals("abastecimentoCasas(10, listOf(Triple(1, 3, 13), Triple(4, 5, 30), Triple(0, 3, 20), Triple(0, 0, 5), Triple(8, 9, 27), Triple(3, 8, 12), Triple(3, 9, 25), Triple(6, 7, 2), Triple(2, 3, 13), Triple(4, 7, 8), Triple(6, 6, 7), Triple(1, 5, 4), Triple(4, 8, 2), Triple(5, 9, 17), Triple(0, 3, 8)))", listOf(33, 45, 58, 95, 81, 98, 73, 66, 83, 69), abastecimentoCasas(10, listOf(Triple(1, 3, 13), Triple(4, 5, 30), Triple(0, 3, 20), Triple(0, 0, 5), Triple(8, 9, 27), Triple(3, 8, 12), Triple(3, 9, 25), Triple(6, 7, 2), Triple(2, 3, 13), Triple(4, 7, 8), Triple(6, 6, 7), Triple(1,5 ,4), Triple(4 ,8 ,2) ,Triple (5 ,9 ,17) ,Triple (0 ,3 ,8))))
    println("Todos os testes passaram para a função abastecimentoCasas!")

}