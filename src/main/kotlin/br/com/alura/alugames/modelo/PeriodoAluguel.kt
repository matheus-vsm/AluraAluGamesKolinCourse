package br.com.alura.alugames.modelo

import net.bytebuddy.asm.Advice
import java.time.LocalDate
import java.time.Period
import javax.persistence.Embeddable

@Embeddable
data class PeriodoAluguel(
    val dataInicial: LocalDate = LocalDate.now(),
    val dataFinal: LocalDate = LocalDate.now().plusDays(7),
    val emDias: Int = Period.between(dataInicial, dataFinal).days // cálculo simples do valor do aluguel com base na quantidade de dias
)