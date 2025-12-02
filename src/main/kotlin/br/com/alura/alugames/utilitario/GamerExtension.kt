package br.com.alura.alugames.utilitario

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer { // função de extensão para converter InfoGamerJson em Gamer
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}