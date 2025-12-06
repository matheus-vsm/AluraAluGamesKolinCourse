package br.com.alura.alugames.modelo

// Plano base para os tipos de planos de aluguel
open class Plano(val tipo: String) {
    // open permite sobrescrita do método em subclasses
    open fun obterValorAluguel(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}