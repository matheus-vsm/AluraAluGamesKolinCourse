package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(
    manager: EntityManager
) : DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return JogoEntity(
            titulo = objeto.titulo,
            capa = objeto.capa,
            preco = objeto.preco,
            descricao = objeto.descricao,
            id = objeto.id
        )
    }

    override fun toModel(objeto: JogoEntity): Jogo {
        return Jogo(
            titulo = objeto.titulo,
            capa = objeto.capa,
            preco = objeto.preco,
            descricao = objeto.descricao,
            id = objeto.id
        )
    }

}