fun main() {

    // Função auxiliar para verificar os resultados dos testes (não modifique)
    fun assertEquals(funcao: String, esperado: Any, resultado: Any) {
        if (esperado != resultado) {
            throw AssertionError("Falha em $funcao: Esperado $esperado, Obtido $resultado")
        }
    }
    /**
     * Forneça a função `celsiusToFahrenheit` que recebe uma temperatura em graus Celsius e retorna esta temperatura convertida em graus Fahrenheit.
     * Fórmula de conversão: F = (9/5)?C+32, onde C é a temperatura em Celsius, e F é a temperatura em Fahrenheit.
     * Ex.: celsiusToFahrenheit(10.0) retorna 50.0.
     */
    fun celsiusToFahrenheit(celsius: Double): Double {
        val fah = (9.0 / 5.0) * celsius + 32
        return fah
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

   assertEquals("celsiusToFahrenheit(10.0)", 50.0, celsiusToFahrenheit(10.0))
   assertEquals("celsiusToFahrenheit(0.0)", 32.0, celsiusToFahrenheit(0.0))
   assertEquals("celsiusToFahrenheit(5.5)", 41.9, celsiusToFahrenheit(5.5))
   println("Todos os testes passaram para a função celsiusToFahrenheit!")


    /**
     * Forneça a função `mediaPonderada` que recebe 3 notas (1a prova, 2a prova e trabalho, nesta ordem) e retorna a média ponderada desta notas.
     * A 1a prova tem peso 5, a 2a prova tem peso 3, e o trabalho tem peso 2.
     * Ex: mediaPonderada(8.5, 6, 7) retorna 7.45, pois, (5*8.5 + 3*6 + 2*7) / 10 = 7.45.
     */
    fun mediaPonderada(prova1: Double, prova2: Double, trabalho: Double): Double {
        return (prova1 * 5 + prova2 * 3 + trabalho * 2) / 10
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

   assertEquals("mediaPonderada(8.5, 6, 7)", 7.45, mediaPonderada(8.5, 6.0, 7.0))
   assertEquals("mediaPonderada(5.0, 5.0, 5.0)", 5.0, mediaPonderada(5.0, 5.0, 5.0))
   assertEquals("mediaPonderada(1.0, 2.0, 3.0)", 1.7, mediaPonderada(1.0, 2.0, 3.0))
   println("Todos os testes passaram para a função mediaPonderada!")


    /**
     * Forneça a função `conversaoTempo` que recebe um tempo total em segundos e retorna um Pair contendo este tempo em horas e minutos, e o restante em segundos.
     * Ex.: conversaoTempo(7384) retorna Triple(2, 3, 4), pois 7384 segundos = 2 horas, 3 minutos e 4 segundos.
     */
    fun conversaoTempo(segundosTotais: Int): Triple<Int, Int, Int> {
        val segundos = 1
        val minutos = 60 * segundos
        val horas = 60 * minutos

        val r1 = segundosTotais / horas
        val r2 = (segundosTotais % horas) / minutos
        val r3 = segundosTotais % minutos


        return Triple(r1, r2, r3)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

   assertEquals("conversaoTempo(7384)", Triple(2, 3, 4), conversaoTempo(7384))
   assertEquals("conversaoTempo(60)", Triple(0, 1, 0), conversaoTempo(60))
   assertEquals("conversaoTempo(3601)", Triple(1, 0, 1), conversaoTempo(3601))
   println("Todos os testes passaram para a função conversaoTempo!")


    /**
     * Forneça a função `premioLoteria` que recebe o valor apostado por cada um dos 3 apostadores, e o prêmio total a ser repartido. Cada apostador ganha uma fração do prêmio proporcional ao valor apostado.
     * Ex: premioLoteria(10, 20, 30, 1200) retorna Triple(200.0, 400.0, 600.0).
     * -- Ganho do 1o: 200.0, pois 1200 * (10 / (10+20+30)) = 200
     * -- Ganho do 2o: 400.0, pois 1200 * (20 / (10+20+30)) = 400
     * -- Ganho do 3o: 600.0, pois 1200 * (30 / (10+20+30)) = 600
     */
    fun premioLoteria(aposta1: Double, aposta2: Double, aposta3: Double, premioTotal: Double): Triple<Double, Double, Double> {
        val r1 = premioTotal * (aposta1 / (aposta1 + aposta2 + aposta3))
        val r2 = premioTotal * (aposta2 / (aposta1 + aposta2 + aposta3))
        val r3 = premioTotal * (aposta3 / (aposta1 + aposta2 + aposta3))
        return Triple(r1, r2, r3)
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

   assertEquals("premioLoteria(10.0, 20.0, 30.0, 1200.0)", Triple(200.0, 400.0, 600.0), premioLoteria(10.0, 20.0, 30.0, 1200.0))
   assertEquals("premioLoteria(1.5, 1.5, 1.5, 31.5)", Triple(10.5, 10.5, 10.5), premioLoteria(1.5, 1.5, 1.5, 31.5))
   assertEquals("premioLoteria(1.0, 2.0, 3.0, 120.0)", Triple(20.0, 40.0, 60.0), premioLoteria(1.0, 2.0, 3.0, 120.0))
   println("Todos os testes passaram para a função premioLoteria!")


    /**
     * Forneça a função 'calcularIMC' que recebe o peso e a altura de uma pessoa, e retorna o IMC (Índice de Massa Corporal) dela.
     * O IMC é calculado pela fórmula: IMC = peso / (altura * altura).
     * Ex.: calcularIMC(70.0, 1.75) retorna 22.86.
     */
    fun calcularIMC(peso: Double, altura: Double): Double {
        val IMC = peso / (altura * altura)
        return IMC
    }

    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>

   assertEquals("calcularIMC(70.0, 1.75)", 22.857142857142858, calcularIMC(70.0, 1.75))
   assertEquals("calcularIMC(60.0, 1.60)", 23.437499999999996, calcularIMC(60.0, 1.60))
   assertEquals("calcularIMC(80.0, 1.80)", 24.691358024691358, calcularIMC(80.0, 1.80))
   println("Todos os testes passaram para a função calcularIMC!")

}