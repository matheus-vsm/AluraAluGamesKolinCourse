package br.com.alura.alugames.modelo

// sealed permite que apenas classes no mesmo pacote ou modulo possam herdar desta classe
sealed class Plano(val tipo: String) {
    // open permite sobrescrita do método em subclasses
    open fun obterValorAluguel(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}