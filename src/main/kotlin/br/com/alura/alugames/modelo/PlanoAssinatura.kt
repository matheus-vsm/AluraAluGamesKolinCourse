package br.com.alura.alugames.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int
) : Plano(tipo) {

    override fun obterValorAluguel(aluguel: Aluguel): Double {
        val totalJogosMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1 // +1 para incluir o jogo atual

        return if (totalJogosMes <= jogosIncluidos) {
            0.0
        } else {
            val valorOriginal = super.obterValorAluguel(aluguel)
            valorOriginal
        }
    }
}
