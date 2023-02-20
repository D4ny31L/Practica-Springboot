package coppel.springdemo.demo.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.Date

@Entity(name = "Books90258332")
data class Libro (
    @Id
    val ISBN: Long,
    var bookname: String,
    var author: String,
    var year: Int,
    var price: Int,
    var quantity: Int,
    var avil: Boolean,
    var date: Date
)