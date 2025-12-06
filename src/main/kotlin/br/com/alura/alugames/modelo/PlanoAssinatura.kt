package br.com.alura.alugames.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int
) : Plano(tipo) {

    override fun obterValorAluguel(aluguel: Aluguel): Double {
        return 0.0
    }
}
