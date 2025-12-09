package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco

fun main() {
    val conexo = Banco.obterConexao()
    println("Conexão obtida: $conexo")
}