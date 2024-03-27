package com.kalashnikov.testtask.domain.usecase

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class GetDateUseCase {

    fun execute(): String {
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
        val instant = Instant.ofEpochMilli(System.currentTimeMillis())
        val date = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"))
        return formatter.format(date)
    }
}