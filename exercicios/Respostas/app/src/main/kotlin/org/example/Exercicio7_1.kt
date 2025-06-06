

import kotlin.collections.listOf
fun main() {

    // Função auxiliar para verificar os resultados dos testes (não modifique)
    fun assertEquals(funcao: String, esperado: Any, resultado: Any) {
        if (esperado != resultado) {
            throw AssertionError("Falha em $funcao: Esperado $esperado, Obtido $resultado")
        }
    }

    /**
     * Função que recebe uma lista L e retorna uma nova lista com os elementos de L invertidos.
     * Versão usando recursão de cauda.
     * Dica: Uma opção é passar para a função auxiliar recursiva uma lista com os elementos ainda
     *       não acessados de L e uma nova lista com os elementos invertidos até então.
     *       Na auxiliar recursiva, extraia a cabeça e a cauda da lista usando first() e drop(1).
     */
    fun inverterLista(lista: List<Int>): List<Int> {
        tailrec fun invert(actualList: List<Int>, invertedList: List<Int>): List<Int> {
            if (actualList.isEmpty()) {
                return invertedList
            }
            val cabeca = actualList.first()
            val cauda = actualList.drop(1)
            return invert(cauda, listOf(cabeca) + invertedList)
        }
        return invert(lista, emptyList())
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
    
    assertEquals("inverterLista(listOf(1, 2, 3, 4, 5))", listOf(5, 4, 3, 2, 1), inverterLista(listOf(1, 2, 3, 4, 5)))
    assertEquals("inverterLista(listOf(1, 4, 2, 5, 3, 4, 5))", listOf(5, 4, 3, 5, 2, 4, 1), inverterLista(listOf(1, 4, 2, 5, 3, 4, 5)))
    println("Todos os testes passaram para a função inverterLista!")
    

    /**
     * Função que recebe uma lista L de inteiros e retorna uma nova lista sem os elementos repetidos
     * de L, mantendo a ordem de ocorrência dos elementos.
     * Versão usando recursão de cauda.
     * Dica: Uma opção é passar para a função auxiliar recursiva uma lista com os elementos ainda
     *       não acessados de L e uma nova lista com os elementos únicos encontrados até então.
     */
    fun removerRepetidos(lista: List<Int>): List<Int> {
        tailrec fun removeElem(actualList: List<Int>, newList: List<Int>): List<Int> {
            if (actualList.isEmpty()) {
                return newList
            }
            val cabeca = actualList.first()
            val cauda = actualList.drop(1)
            if(cabeca in newList){
                return removeElem(cauda, newList)
            }else{
                return removeElem(cauda, newList + listOf(cabeca))
            }
        }
        return removeElem(lista, emptyList())
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
    
    assertEquals("removerRepetidos(listOf(1, 2, 1, 3, 2, 4, 5, 4, 6, 7, 8, 7, 9, 10, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))",
                 listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
                 removerRepetidos(listOf(1, 2, 1, 3, 2, 4, 5, 4, 6, 7, 8, 7, 9, 10, 9, 11,
                                         12, 13, 14, 15, 16, 17, 18, 19, 20)))
    assertEquals("removerRepetidos(listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1))", listOf(1), removerRepetidos(listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
    assertEquals("removerRepetidos(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))", listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), removerRepetidos(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    assertEquals("removerRepetidos(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10))",
                 listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                 removerRepetidos(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                         1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println("Todos os testes passaram para a função removerRepetidos!")
    

    /**
     * Função que recebe duas listas de inteiros e retorna uma nova lista contendo os elementos que
     * estão em ambas as listas, em ordem crescente e sem repetir elementos.
     * Versão usando recursão de cauda.
     * Dica: Uma opção é passar para a função auxiliar recursiva os elementos que ainda precisam ser
     *       acessados da primeira lista, a segunda lista, e uma nova lista com os elementos em comum
     *       encontrados até então.
     */
    fun interseccaoListas(lista1: List<Int>, lista2: List<Int>): List<Int> {
        tailrec fun intersecLists(actualList1: List<Int>, actualList2: List<Int>, newList: List<Int>): List<Int> {
            if (actualList1.isEmpty()) {
                return newList
            }
            val cabeca = actualList1.first()
            val cauda = actualList1.drop(1)
            if(cabeca in actualList2){
                return intersecLists(cauda, actualList2, newList + listOf(cabeca))
            }else{
                return intersecLists(cauda, actualList2, newList)
            }
        }
        return intersecLists(lista1, lista2, emptyList())
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
    
    assertEquals("interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(1, 2, 3, 4, 5))",
                 listOf(1, 2, 3, 4, 5).sorted(),
                 interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(1, 2, 3, 4, 5)))
    assertEquals("interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10))",
                 listOf<Int>().sorted(),
                 interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10)))
    assertEquals("interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(5, 4, 3, 2, 1))",
                 listOf(1, 2, 3, 4, 5).sorted(),
                 interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(5, 4, 3, 2, 1)))
    assertEquals("interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))",
                 listOf(1, 2, 3, 4, 5).sorted(),
                 interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    assertEquals("interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10, 1, 2, 3, 4, 5))",
                 listOf(1, 2, 3, 4, 5).sorted(),
                 interseccaoListas(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10, 1, 2, 3, 4, 5)))
    println("Todos os testes passaram para a função interseccaoListas!")
    

    /**
     * Função que recebe uma lista L de inteiros e retornar um Pair com o maior e o menor valor da lista.
     * Versão usando recursão de cauda.
     * Dica: Uma opção é passar para a função auxiliar recursiva uma lista com os elementos ainda
     *       não acessados de L e o maior e menor elementos encontrados até então.
     */
    fun maiorMenorLista(lista: List<Int>): Pair<Int, Int> {
        //Versão considerando apenas inteiros positivos
        tailrec fun maiorMenor(actualList: List<Int>, maior: Int, menor: Int): Pair<Int, Int> {
            if(actualList.isEmpty()){
                return Pair(maior, menor)
            }

            val cabeca = actualList.first()
            val cauda = actualList.drop(1)
            
            if(cabeca > maior){
                return maiorMenor(cauda, cabeca, menor)
            }else if (cabeca < menor){
                return maiorMenor(cauda, maior, cabeca)
            } else {
                return maiorMenor(cauda, maior, menor)
            }

        }
        return maiorMenor(lista, lista.first(), lista.first())
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
    
    assertEquals("maiorMenorLista(listOf(1, 2))", Pair(2, 1), maiorMenorLista(listOf(1, 2)))
    assertEquals("maiorMenorLista(listOf(1, 5, 4, 3))", Pair(5, 1), maiorMenorLista(listOf(1, 5, 4, 3)))
    assertEquals("maiorMenorLista(listOf(9, 6, 4, 8, 1, 2))", Pair(9, 1), maiorMenorLista(listOf(9, 6, 4, 8, 1, 2)))
    assertEquals("maiorMenorLista(listOf(9, 6, 4, 8, 1, 2, 1))", Pair(9, 1), maiorMenorLista(listOf(9, 6, 4, 8, 1, 2, 1)))
    println("Todos os testes passaram para a função maiorMenorLista!")
    
}