package br.com.alura.alugames.modelo

data class Jogo(
    val titulo: String,
    val capa: String
) : Recomendavel {
    var preco: Double = 0.0
    var descricao: String? = null
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String?) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: R$$preco \n" +
                "Reputação: $media\n\n"
    }
}