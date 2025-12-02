package br.com.alura.alugames.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: PeriodoAluguel
) {
    val valorDoAluguel = jogo.preco * periodo.emDias

    override fun toString(): String {
        return "Aluguel do Jogo ${jogo.titulo} para ${gamer.nome} pelo valor de R$$valorDoAluguel"
    }
}
