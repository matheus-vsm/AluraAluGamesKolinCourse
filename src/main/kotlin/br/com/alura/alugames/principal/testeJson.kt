package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamer()
    val listaJogoJson = consumo.buscaJogosJson()
//    val jogoApi = consumo.buscaJogo("151")
//    println(listaGamers)
//    println(jogoApi)

    val gamer1 = listaGamers[3]
    val jogo1 = listaJogoJson[10]

    println("O gamer ${gamer1.nome} está jogando ${jogo1.titulo}")

    val aluguel = gamer1.alugaJogo(jogo1)
    println(aluguel)
}