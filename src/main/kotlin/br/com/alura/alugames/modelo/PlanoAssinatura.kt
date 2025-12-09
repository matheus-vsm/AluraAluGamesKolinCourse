package br.com.alura.alugames.modelo

import java.math.BigDecimal

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double,
    id : Int = 0
) : Plano(tipo, id) {

    override fun obterValorAluguel(aluguel: Aluguel): Double {
        val totalJogosMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1 // +1 para incluir o jogo atual

        return if (totalJogosMes <= jogosIncluidos) {
            0.0
        } else {
            var valorOriginal = super.obterValorAluguel(aluguel)
            if (aluguel.gamer.media > 8) {
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            valorOriginal
        }
    }

    override fun toString(): String {
        return "Plano Assinatura\n" +
                "Tipo: $tipo\n" +
                "Id: $id\n" +
                "Mensalidade: $mensalidade\n" +
                "Jogos Incluidos: $jogosIncluidos\n" +
                "Percentual Desconto Reputacao: $percentualDescontoReputacao\n"
    }
}
