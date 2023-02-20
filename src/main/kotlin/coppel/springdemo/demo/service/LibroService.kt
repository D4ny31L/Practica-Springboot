package coppel.springdemo.demo.service

import coppel.springdemo.demo.dto.LibroDTO
import jakarta.transaction.Transactional
import org.springframework.data.repository.query.Param

interface LibroService {

    fun createlibro(libroDTO: LibroDTO): LibroDTO

    fun getLibro(): List<LibroDTO>

    fun getLibro(ISBN: Long): LibroDTO

    fun getLibrobyName(bookname: String): List<LibroDTO>

    fun updateLibro(libroDTO: LibroDTO): LibroDTO

    fun deleteLibro(ISBN: Long)

    fun getLibroSort(): List<LibroDTO>

    fun getLibroSortISBN(): List<LibroDTO>

    fun updateLibroAvil(libroDTO: LibroDTO): LibroDTO

}
