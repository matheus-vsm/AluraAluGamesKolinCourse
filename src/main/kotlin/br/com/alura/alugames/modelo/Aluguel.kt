package br.com.alura.alugames.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val dataInicial: LocalDate,
    val dataFinal: LocalDate
) {
    val valorDoAluguel = jogo.preco * Period.between(dataInicial, dataFinal).days // cálculo simples do valor do aluguel com base na quantidade de dias

    override fun toString(): String {
        return "Aluguel do Jogo ${jogo.titulo} para ${gamer.nome} pelo valor de $valorDoAluguel"
    }
}
