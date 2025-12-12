package br.com.alura.alugames.dados

import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Table

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Usa uma única tabela para toda a hierarquia de classes.
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING) // Coluna usada para identificar qual subclasse cada registro representa.
sealed class PlanoEntity(val tipo: String)

@Entity
@DiscriminatorValue("Avulso") // Valor salvo na coluna TipoPlano para indicar esta subclasse específica.
class PlanoAvulsoEntity(tipo: String) : PlanoEntity(tipo)

@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaEntity(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double
) : PlanoEntity(tipo)