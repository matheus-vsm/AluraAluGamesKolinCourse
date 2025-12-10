package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager) : DAO<Jogo>(manager) {

    override fun toEntity(objeto: Jogo) {
        return JogoEntity(
            titulo = objeto.titulo,
            capa = objeto.capa,
            preco = objeto.preco,
            descricao = objeto.descricao,
            id = objeto.id
        )
    }

    override fun getLista(): List<Jogo> {
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { entity ->
            Jogo(
                entity.titulo,
                entity.capa,
                entity.preco,
                entity.descricao,
                entity.id
            )
        }
    }

}