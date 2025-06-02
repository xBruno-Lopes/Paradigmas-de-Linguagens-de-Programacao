//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // Função auxiliar para verificar os resultados dos testes (não modifique)
    fun assertEquals(funcao: String, esperado: Any, resultado: Any) {
        if (esperado != resultado) {
            throw AssertionError("Falha em $funcao: Esperado $esperado, Obtido $resultado")
        }
    }

    /**
     * Dados dois valores inteiros A e B recebidos como parâmetro, retorne a soma de todos os valores de A até B (incluindo A e B).
     * Se A for maior que B, retorne 0.
     * Versão usando recursão de cauda.
     */
    fun somaIntervaloRecursivo(a: Int, b: Int): Int {
        if (a > b){
            return 0
        }
        tailrec fun somaInter(n: Int, acumulador: Int = 0): Int {
            if (n == a) {
                return acumulador + n
            }
            return somaInter(n - 1, acumulador + n)
        }
        return somaInter(b)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("somaIntervaloRecursivo(1, 10)", 55, somaIntervaloRecursivo(1, 10))
    assertEquals("somaIntervaloRecursivo(10, 20)", 165, somaIntervaloRecursivo(10, 20))
    assertEquals("somaIntervaloRecursivo(1, 100)", 5050, somaIntervaloRecursivo(1, 100))
    assertEquals("somaIntervaloRecursivo(10, 5)", 0, somaIntervaloRecursivo(10, 5))
    assertEquals("somaIntervaloRecursivo(10, 10)", 10, somaIntervaloRecursivo(10, 10))
    println("Todos os testes passaram para a função somaIntervaloRecursivo!")


    /**
     * Dados dois valores inteiros A e B recebidos como parâmetro, retorne a soma de todos os valores pares de A até B (possivelmente incluindo A e B).
     * Se A for maior que B, retorne 0.
     * Versão usando recursão de cauda.
     */
    fun somaParesIntervaloRecursivo(a: Int, b: Int): Int {
        if (a > b){
            return 0
        }
        tailrec fun somaPares(n: Int, acumulador: Int = 0): Int {
            if (n == a) {
                if(n % 2 == 0){
                    return acumulador + n
                }else{
                    return acumulador
                }
            }
            if(n % 2 == 0){
                return somaPares(n - 1, acumulador + n)
            } else {
                return somaPares(n - 1, acumulador)
            }
        }
        return somaPares(b)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

    assertEquals("somaParesIntervaloRecursivo(1, 10)", 30, somaParesIntervaloRecursivo(1, 10))
    assertEquals("somaParesIntervaloRecursivo(10, 20)", 90, somaParesIntervaloRecursivo(10, 20))
    assertEquals("somaParesIntervaloRecursivo(1, 100)", 2550, somaParesIntervaloRecursivo(1, 100))
    assertEquals("somaParesIntervaloRecursivo(10, 5)", 0, somaParesIntervaloRecursivo(10, 5))
    assertEquals("somaParesIntervaloRecursivo(10, 10)", 10, somaParesIntervaloRecursivo(10, 10))
    println("Todos os testes passaram para a função somaParesIntervaloRecursivo!")


    /*
     * O jogo Blackjack permite descartar cartas Ás, reduzindo em 10 o total de pontos para cada
     * carta Ás descartada. Dado o total de pontos das cartas de um jogador e a quantidade de cartas
     * Ás que ele dispõe, retorne o total de pontos mais próximo possível de 21 pontos que pode ser
     * obtido, sem ultrapassar 21 pontos (se possível).
     * Versão usando recursão de cauda.
     */
    fun blackjack(pontos: Int, ases: Int): Int {
        tailrec fun blackJackRec(n: Int = ases, acumulador: Int = pontos): Int {
            if (n == 0) {
                return acumulador
            }
            if(acumulador > 21 && n > 0){
                return blackJackRec(n - 1, acumulador - 10)
            }else{
                return acumulador
            } 
        }
        return blackJackRec(ases)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
    
    assertEquals("blackjack(21, 3)", 21, blackjack(21, 3))
    assertEquals("blackjack(22, 0)", 22, blackjack(22, 0))
    assertEquals("blackjack(22, 1)", 12, blackjack(22, 1))
    assertEquals("blackjack(22, 2)", 12, blackjack(22, 2))
    assertEquals("blackjack(32, 2)", 12, blackjack(32, 2))
    assertEquals("blackjack(43, 1)", 33, blackjack(43, 1))
    assertEquals("blackjack(43, 4)", 13, blackjack(43, 4))
    assertEquals("blackjack(41, 4)", 21, blackjack(41, 4))
    println("Todos os testes passaram para a função blackjack!")
    

    /*
     * Dado um inteiro n, retona o n-ésimo termo da sequência de Fibonacci.
     * Sequência de Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
     * O termo 0 é o primeiro termo da sequência.
     * O n-ésimo termo é a soma dos dois termos anteriores.
     * Versão usando recursão de cauda.
     */
    fun fibonacci(n: Int): Int {
        tailrec fun fibonacciTailRec(fib1: Int, fib2: Int = 0, fib3: Int = 1): Int {
            return if (fib1 == 0) {
                fib2
            } else {
                fibonacciTailRec(fib1 - 1, fib3, fib2 + fib3)
            }
        }
        return fibonacciTailRec(n)
        
        // fibonacciTailRec é a função recursiva de cauda, com três parâmetros:

        // fib1: o número de chamadas restantes.

        // fib2: o valor atual (resultado até o momento).

        // fib3: o próximo valor da sequência.

        // Quando n == 0, retornamos a, que é o n-ésimo termo.

        // Senão, continuamos a recursão diminuindo n e atualizando a e b.
        
        // if(n == 0){
        //     return 0
        // }
        // if(n == 1){
        //     return 1
        // }  

        // return fibonacci(n - 1) + fibonacci(n - 2)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
    
    assertEquals("fibonacci(0)", 0, fibonacci(0))
    assertEquals("fibonacci(1)", 1, fibonacci(1))
    assertEquals("fibonacci(2)", 1, fibonacci(2))
    assertEquals("fibonacci(3)", 2, fibonacci(3))
    assertEquals("fibonacci(4)", 3, fibonacci(4))
    assertEquals("fibonacci(5)", 5, fibonacci(5))
    assertEquals("fibonacci(6)", 8, fibonacci(6))
    assertEquals("fibonacci(7)", 13, fibonacci(7))
    assertEquals("fibonacci(8)", 21, fibonacci(8))
    println("Todos os testes passaram para a função fibonacci!")
    

}