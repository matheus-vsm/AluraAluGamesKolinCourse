package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.PeriodoAluguel
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
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
    val jogo4 = listaJogoJson[3]

    val periodo1 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo4 = PeriodoAluguel(
        LocalDate.of(2023, 8, 2),
        LocalDate.of(2023, 8, 15)
    )

    gamer1.alugaJogo(jogo1, periodo1)
    gamer1.alugaJogo(jogo2, periodo2)
    gamer1.alugaJogo(jogo3, periodo3)
    gamer1.alugaJogo(jogo4, periodo4)

    gamer1.jogosAlugados.forEach { println(it) }
    println()

    println(gamer1.jogosDoMes(12))
    println()

    val gamer2 = listaGamers[5]
    gamer2.plano = PlanoAssinatura("Prata", 9.90, 3, 0.15)
    gamer2.alugaJogo(jogo1, periodo1)
    gamer2.alugaJogo(jogo2, periodo2)
    gamer2.alugaJogo(jogo3, periodo3)
    gamer2.alugaJogo(jogo3, periodo3)

    gamer2.recomendar(7)
    gamer2.recomendar(10)
    gamer2.recomendar(8)
    println(gamer2)

    gamer2.alugaJogo(jogo1, periodo1)
    println(gamer2.jogosAlugados)

    println("\nRecomendações:")
    gamer1.recomendarJogo(jogo1, 7)
    gamer1.recomendarJogo(jogo2, 10)
    println(gamer1.jogosRecomendados)
    gamer2.recomendarJogo(jogo1, 7)
    gamer2.recomendarJogo(jogo2, 10)
    println(gamer2.jogosRecomendados)

    val gamerCaroline = listaGamers[3]
    val jogoResidentVillage = listaJogoJson[10]
    val jogoSpider = listaJogoJson[13]
    val jogoTheLastOfUs = listaJogoJson[2]
    val jogoDandara = listaJogoJson[5]
    val jogoAssassins = listaJogoJson[4]
    val jogoCyber = listaJogoJson[6]
    val jogoGod = listaJogoJson[7]
    val jogoSkyrim = listaJogoJson[18]

    gamer1.recomendarJogo(jogoResidentVillage, 7)
    gamer1.recomendarJogo(jogoTheLastOfUs, 10)
    gamer1.recomendarJogo(jogoAssassins, 8)
    gamer1.recomendarJogo(jogoCyber, 7)
    gamer1.recomendarJogo(jogoGod, 10)
    gamer1.recomendarJogo(jogoDandara, 8)
    gamer1.recomendarJogo(jogoSkyrim, 8)
    gamer1.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create() // Configuração para considerar apenas os campos anotados com @Expose
    val serialzacao = gson.toJson(gamerCaroline.jogosRecomendados)
    println("\nGamer Caroline em JSON:\n$serialzacao")

    val arquivo = File("jogos_recomendados_${gamer1.nome}.json")
    arquivo.writeText(serialzacao)
    println(arquivo.absolutePath)
}