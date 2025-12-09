package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

// object faz com que a classe seja singleton, ou seja, só pode ter uma instância dela
object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "mysql123")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}