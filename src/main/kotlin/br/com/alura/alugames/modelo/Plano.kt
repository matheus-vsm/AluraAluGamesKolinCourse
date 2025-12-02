package br.com.alura.alugames.modelo

// Plano base para os tipos de planos de aluguel
open class Plano(val tipo: String) {
    fun obterValorAluguel(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}