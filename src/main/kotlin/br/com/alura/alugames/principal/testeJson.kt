package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.PeriodoAluguel
import br.com.alura.alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamer()
    val listaJogoJson = consumo.buscaJogosJson()
//    val jogoApi = consumo.buscaJogo("151")
//    println(listaGamers)
//    println(jogoApi)

    val gamer1 = listaGamers[3]
    val jogo1 = listaJogoJson[10]
    val jogo2 = listaJogoJson[13]
    val jogo3 = listaJogoJson[2]
    val periodo1 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(10))

    gamer1.alugaJogo(jogo1, periodo1)
    gamer1.alugaJogo(jogo2, periodo2)
    gamer1.alugaJogo(jogo3, periodo3)

    gamer1.jogosAlugados.forEach { println(it) }
}