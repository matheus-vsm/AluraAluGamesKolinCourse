package br.com.alura.alugames.modelo

class PlanoAvulso(
    tipo: String
) : Plano(tipo){
    override fun obterValorAluguel(aluguel: Aluguel): Double {
        var valorOriginal = super.obterValorAluguel(aluguel)
        if (aluguel.gamer.media > 8.0) {
            valorOriginal -= valorOriginal * 0.1
        }
        return valorOriginal
    }
}
