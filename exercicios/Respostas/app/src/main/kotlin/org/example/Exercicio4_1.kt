fun main() {

    // Função auxiliar para verificar os resultados dos testes (não modifique)
    fun assertEquals(funcao: String, esperado: Any, resultado: Any) {
        if (esperado != resultado) {
            throw AssertionError("Falha em $funcao: Esperado $esperado, Obtido $resultado")
        }
    }

    /**
     * Função que recebe uma lista L e retorna uma nova lista com os elementos de L invertidos.
     * Versão usando comandos de repetição.
     */
    fun inverterLista(lista: List<Int>): List<Int> {
//        val newList = lista.asReversed()
        val newList: MutableList<Int> = mutableListOf()
        for (index in lista.size - 1 downTo 0) {
            newList.add(lista[index])
        }
        return newList
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("inverterLista([1, 2, 3, 4, 5])", listOf(5, 4, 3, 2, 1), inverterLista(listOf(1, 2, 3, 4, 5)))
    assertEquals("inverterLista([1, 4, 2, 5, 3, 4, 5])", listOf(5, 4, 3, 5, 2, 4, 1), inverterLista(listOf(1, 4, 2, 5, 3, 4, 5)))
    println("Todos os testes passaram para a função inverterLista!")


    /**
     * Função que recebe uma lista L de inteiros e retorna uma nova lista sem os elementos repetidos
     * de L, mantendo a ordem de ocorrência dos elementos.
     * Versão usando comandos de repetição.
     */
    fun removerRepetidos(lista: List<Int>): List<Int> {
//        val newList = lista.toSet().toList()
        val newList: MutableList<Int> = mutableListOf()
        for(item in lista) {
            if (item !in newList) newList.add(item)
        }
        return newList
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("removerRepetidos([1, 2, 1, 3, 2, 4, 5])", listOf(1, 2, 3, 4, 5), removerRepetidos(listOf(1, 2, 1, 3, 2, 4, 5)))
    assertEquals("removerRepetidos([5, 4, 3, 2, 1])", listOf(5, 4, 3, 2, 1), removerRepetidos(listOf(5, 4, 3, 2, 1)))
    assertEquals("removerRepetidos([1, 1, 1, 1, 1])", listOf(1), removerRepetidos(listOf(1, 1, 1, 1, 1)))
    assertEquals("removerRepetidos([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10])", listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), removerRepetidos(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println("Todos os testes passaram para a função removerRepetidos!")


    /**
     * Função que recebe duas listas de inteiros e retorna uma nova lista contendo os elementos que
     * estão em ambas as listas, em ordem crescente e sem repetir elementos.
     * Versão usando comandos de repetição.
     */
    fun interseccaoListas(lista1: List<Int>, lista2: List<Int>): List<Int> {
        val newList: MutableList<Int> = mutableListOf()
        for (item in lista1) {
            if (item in lista2 && item !in newList) {
                newList.add(item)
            }
        }
//        return newList.toList().sorted()

        for (i in newList.indices) {
            val atual = newList[i]
            var j = i - 1
            while (j >= 0 && newList[j] > atual) {
                newList[j + 1] = newList[j]
                j--
            }
            newList[j + 1] = atual
        }

        return newList
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("interseccaoListas([1, 2, 3, 4, 5], [1, 2, 3, 4, 5])", listOf(1, 2, 3, 4, 5), interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(1, 2, 3, 4, 5)))
    assertEquals("interseccaoListas([1, 2, 3, 4, 5], [6, 7, 8, 9, 10])", listOf<Int>(), interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10)))
    assertEquals("interseccaoListas([1, 2, 3, 4, 5], [5, 4, 3, 2, 1])", listOf(1, 2, 3, 4, 5), interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(5, 4, 3, 2, 1)))
    assertEquals("interseccaoListas([1, 2, 3, 4, 5], [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])", listOf(1, 2, 3, 4, 5), interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    assertEquals("interseccaoListas([1, 2, 3, 4, 5], [6, 7, 8, 9, 10, 1, 2, 3, 4, 5])", listOf(1, 2, 3, 4, 5), interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10, 1, 2, 3, 4, 5)))
    println("Todos os testes passaram para a função interseccaoListas!")


    /**
     * Função que recebe uma lista L de inteiros e retornar um Pair com o maior e o menor valor da lista.
     * Versão usando comandos de repetição.
     */
    fun maiorMenorLista(lista: List<Int>): Pair<Int, Int> {
//        val max = lista.max()
//        val min = lista.min()
//        return Pair(max, min)
        var max = lista[0]
        var min = lista[0]
        for (item in lista) {
            if(item > max) {
                max = item
            }
            if (item < min) {
                min = item
            }
        }
        return  Pair(max, min)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("maiorMenorLista([1, 2])", Pair(2, 1), maiorMenorLista(listOf(1, 2)))
    assertEquals("maiorMenorLista([1, 5, 4, 3])", Pair(5, 1), maiorMenorLista(listOf(1, 5, 4, 3)))
    assertEquals("maiorMenorLista([9, 6, 4, 8, 1, 2])", Pair(9, 1), maiorMenorLista(listOf(9, 6, 4, 8, 1, 2)))
    assertEquals("maiorMenorLista([9, 6, 4, 8, 1, 2, 1])", Pair(9, 1), maiorMenorLista(listOf(9, 6, 4, 8, 1, 2, 1)))
    println("Todos os testes passaram para a função maiorMenorLista!")

}