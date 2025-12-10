package br.com.alura.alugames.dados

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

// object faz com que a classe seja singleton, ou seja, só pode ter uma instância dela
object Banco {
//    fun obterConexao(): Connection? {
//        return try {
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "mysql123")
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }

    // Configuração do JPA com base no arquivo persistence.xml
    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }

}