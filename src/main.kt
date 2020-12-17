/*
*   Código desenvolvido para fins educativos.
*
*   Curso: Kotlin - primeiros passos e Orientação a Objetos
*   Link:  https://cursos.alura.com.br/course/kotlin-orientacao-objetos
*   Descrição: Objetivo do curso criar um bytebank para primeiros passos com a linguagem de programação.
*
*   Autor:    Rui Barbosa
*   LinkedIn: https://www.linkedin.com/in/brui/
*   GitHub:   https://github.com/barbosahub
*/
fun main() {
    println("\n** Bem vindo ao ByteBank **")
    println("--------------------------------------------------------")

    /*  Criando as contas */
    val contaRui = Conta("Rui", 1556)
    contaRui.deposito(1250.0)

    val contaJulia = Conta("Julia", 6598)
    contaJulia.deposito(2700.0)

    /* ------------------------------   Realizando Deposito */
        println("Saldo atualizado: ${contaRui.saldo}")

        println("Realizando deposito...")
        contaRui.deposito(750.00)
        println("Saldo atualizado: ${contaRui.saldo}")

    /* ------------------------------   Realizando Saque */
        println("------------------------------------------")
        contaJulia.saque(2800.0)

    /* ------------------------------   Realizando Transferencia */
    println("------------------------------------------")
    contaRui.transferencia(1500.0, contaJulia)
}

class Conta(var titular: String,
            val numero: Int) {
    var saldo = 0.0
        private set

    fun deposito(valor: Double) {
        if (valor > 0) saldo += valor
    }

    fun saque(valor: Double) {
        println("\nTitular: $titular" +
                "\nConta: $numero")
        if (saldo >= valor) {
            saldo -= valor
            println("Saque no valor de: R$$valor, saldo em conta: R$$saldo")
        } else println("Não é possível realizar o saque no valor de: R$$valor, saldo em conta: R$$saldo")
    }

    fun transferencia(valor: Double, destino: Conta): Boolean {
        println("\nTitular: $titular" +
                "\nConta: $numero")
        if (saldo >= valor) {
            saldo -= valor
            println("Depósito de R$$valor realizado para ${destino.titular}")
            destino.deposito(valor)
            return true
        }   else println("Não é possível realizar o depisito no valor de: R$$valor, saldo em conta: R$$saldo")
        return false
    }
}


////////////////////////////////////////////////////////////////////
fun condicoesSaque(valor: Double, saldo: Double) {
    when {
        saldo > 0 -> println("Saldo em conta R$ $saldo")
        else -> println("Não é possível realizar o saque no valor de: R$$valor, saldo em conta: R$$saldo")
    }
}

fun condicoesFor(de: Int, ate: Int) {
    for (i in de..ate) {
        println(i)
    }
}

fun condicoesWhile() {
    var i = 0
    while (i < 5) {
        println(i++)
    }
}