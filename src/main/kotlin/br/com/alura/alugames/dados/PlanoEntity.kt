package br.com.alura.alugames.dados

import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Table

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Usa uma única tabela para toda a hierarquia de classes.
@DiscriminatorColumn(
    name = "TipoPlano",
    discriminatorType = DiscriminatorType.STRING
) // Coluna usada para identificar qual subclasse cada registro representa.
sealed class PlanoEntity(
    val tipo: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int
)

@Entity
@DiscriminatorValue("Avulso") // Valor salvo na coluna TipoPlano para indicar esta subclasse específica.
class PlanoAvulsoEntity(tipo: String = "Plano Avulso", id: Int = 0) : PlanoEntity(tipo, id)

@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaEntity(
    tipo: String = "Plano Assinatura",
    val mensalidade: Double = 0.0,
    val jogosIncluidos: Int = 0,
    val percentualDescontoReputacao: Double = 0.0,
    id: Int = 0
) : PlanoEntity(tipo, id)