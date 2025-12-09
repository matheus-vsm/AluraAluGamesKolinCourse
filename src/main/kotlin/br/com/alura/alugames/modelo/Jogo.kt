package br.com.alura.alugames.modelo

import br.com.alura.alugames.utilitario.formatoComDuasCasasDecimais
import com.google.gson.annotations.Expose
import java.math.BigDecimal

data class Jogo(
    @Expose val titulo: String,
    @Expose val capa: String
) : Recomendavel {
    var id = 0
    var preco = BigDecimal("0.0")
    var descricao: String? = null
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String, id: Int = 0) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override fun toString(): String {
        return "Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: R$$preco \n" +
                "Reputação: $media\n " +
                "Id: $id\n\n"
    }
}