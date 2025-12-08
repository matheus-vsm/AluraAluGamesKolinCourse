package br.com.alura.alugames.modelo

import java.math.BigDecimal

class PlanoAssinatura(
    tipo: String,
    val mensalidade: BigDecimal,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: BigDecimal
) : Plano(tipo) {

    override fun obterValorAluguel(aluguel: Aluguel): BigDecimal {
        val totalJogosMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1 // +1 para incluir o jogo atual

        return if (totalJogosMes <= jogosIncluidos) {
            BigDecimal("0.0")
        } else {
            var valorOriginal = super.obterValorAluguel(aluguel)
            if (aluguel.gamer.media > 8) {
                valorOriginal -= valorOriginal.multiply(percentualDescontoReputacao)
            }
            valorOriginal
        }
    }
}
