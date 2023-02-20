package coppel.springdemo.demo.web.rest

import coppel.springdemo.demo.dto.LibroDTO
import coppel.springdemo.demo.service.LibroService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class LibroResource (
    private val libroService: LibroService
)   {

    @PostMapping("/post")
    fun createlibro (@RequestBody libroDTO: LibroDTO): ResponseEntity<LibroDTO>{
            return ResponseEntity(libroService.createlibro(libroDTO), HttpStatus.CREATED)
    }

    @GetMapping("/")
    fun getLibro(): ResponseEntity<List<LibroDTO>> =
        ResponseEntity.ok(libroService.getLibro())

    @GetMapping("/{ISBN}")
    fun getLibro(@PathVariable ISBN: Long) =
        libroService.getLibro(ISBN)

    @PutMapping("/update")
    fun updateLibro(@RequestBody libroDTO: LibroDTO): ResponseEntity<LibroDTO> =
        ResponseEntity.ok(libroService.updateLibro(libroDTO))

    @DeleteMapping("/delete/{ISBN}")
    fun deleteLibro(@PathVariable ISBN: Long): ResponseEntity<Unit> =
        ResponseEntity(libroService.deleteLibro(ISBN),HttpStatus.NO_CONTENT)

    @GetMapping("/nombre/{bookName}")
    fun getLibro(@PathVariable bookName: String): ResponseEntity<List<LibroDTO>> =
        ResponseEntity.ok(libroService.getLibrobyName(bookName))

    @GetMapping("/sortedname")
    fun getLibroSort(): ResponseEntity<List<LibroDTO>> =
        ResponseEntity.ok(libroService.getLibroSort())

    @GetMapping("/sortedisbn")
    fun getLibroSortISBN(): ResponseEntity<List<LibroDTO>> =
        ResponseEntity.ok(libroService.getLibroSortISBN())

    @PutMapping("/Avilupdate")
    fun updateLibroAvil(@RequestBody libroDTO: LibroDTO): ResponseEntity<LibroDTO> =
        ResponseEntity.ok(libroService.updateLibroAvil(libroDTO))

}