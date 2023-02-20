package coppel.springdemo.demo.dto

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class  LibroDTO(
    var ISBN: Long = -1,
    var bookname: String = "Default",
    var author: String ="Default",
    var year: Int,
    var price: Int,
    var quantity: Int,
    var avil: Boolean = false,
    var date: Date
)