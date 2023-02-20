package coppel.springdemo.demo.repository

import coppel.springdemo.demo.entity.Libro
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface LibroRepository: CrudRepository<Libro, Long> {

    @Query("SELECT m FROM Books90258332 as m")
    fun getAlllibros(): List<Libro>

    @Query("SELECT m FROM Books90258332 as m WHERE m.bookname LIKE %:bookname%")
    fun getLibrosbyName(@Param("bookname") bookname: String): List<Libro>

    @Query("SELECT m FROM Books90258332 as m GROUP BY m.ISBN ORDER BY m.bookname ASC")
    fun getAlllibrosSorted(): List<Libro>

    @Query("SELECT m FROM Books90258332 as m GROUP BY m.ISBN ORDER BY m.ISBN ASC")
    fun getAlllibrosSortedISBN(): List<Libro>

}