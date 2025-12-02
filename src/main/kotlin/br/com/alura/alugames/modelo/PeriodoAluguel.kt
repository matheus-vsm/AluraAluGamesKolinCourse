package br.com.alura.alugames.modelo

import java.time.LocalDate
import java.time.Period

data class PeriodoAluguel(
    val dataInicial: LocalDate,
    val dataFinal: LocalDate,
    val emDias: Int = Period.between(dataInicial, dataFinal).days // cálculo simples do valor do aluguel com base na quantidade de dias
)