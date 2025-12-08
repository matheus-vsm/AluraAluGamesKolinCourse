package br.com.alura.alugames.modelo

import java.math.BigDecimal

class PlanoAvulso(
    tipo: String
) : Plano(tipo){
    override fun obterValorAluguel(aluguel: Aluguel): BigDecimal {
        var valorOriginal = super.obterValorAluguel(aluguel)
        if (aluguel.gamer.media > 8.0) {
            valorOriginal -= valorOriginal.multiply(BigDecimal("0.1"))
        }
        return valorOriginal
    }
}
