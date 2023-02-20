package coppel.springdemo.demo.service

import coppel.springdemo.demo.dto.LibroDTO
import coppel.springdemo.demo.entity.StoreLogDTO
import coppel.springdemo.demo.repository.LibroRepository
import coppel.springdemo.demo.repository.StoreLogRepository
import coppel.springdemo.demo.utils.exceptions.LibroException
import coppel.springdemo.demo.utils.mapper.LibroMapper
import coppel.springdemo.demo.utils.mapper.LogMapper
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.*

@Service
class LibroServiceImpl(
    private val libroRepository: LibroRepository,
    private val libroMapper: LibroMapper,
    private val logMapper: LogMapper,
    private val storelogRepository: StoreLogRepository
) : LibroService {

    //funcion Post
    override fun createlibro(libroDTO: LibroDTO): LibroDTO {

        libroDTO.bookname = libroDTO.bookname.lowercase()
        val optionalLibro = libroRepository.findById(libroDTO.ISBN)
        if( optionalLibro.isPresent){
            throw IllegalArgumentException("Book ISBN already exists")
        }
        if(libroDTO.ISBN.toString().length != 13) {
            throw IllegalArgumentException("ISBN must have 13 numbers")
        }
        if(libroDTO.bookname.length < 3) {
            throw IllegalArgumentException("the Bookname must have at least 3 characters")
        }
        if(libroDTO.bookname == "Default" || libroDTO.author == "Default" || libroDTO.year <= 0 || libroDTO.date == null || libroDTO.price <= 0 || libroDTO.quantity == 0){
            throw IllegalArgumentException("the Book Info must be completed")
        }

        Almacenardatos (libroDTO.ISBN, "INSERT", "Se hizo un insert en la Tabla")

        val libro = libroMapper.toEntity(libroDTO)

        libroRepository.save(libro)
        return libroMapper.fromEntity(libro)
    }

    //funcion get lista libros
    override fun getLibro(): List<LibroDTO>{
        val libros = libroRepository.getAlllibros()

        if (libros.isEmpty())
            throw LibroException("List of books is empty.")


        return libros.map{
            libroMapper.fromEntity(it)
        }
    }

    //funcion get libro por ISBN
    override fun getLibro(ISBN: Long): LibroDTO{
        val optionalLibro = libroRepository.findById(ISBN)
        val libro = optionalLibro.orElseThrow{ LibroException("Book with ISBN $ISBN is not here :(")}
        return libroMapper.fromEntity(libro)
    }

    override fun getLibrobyName(bookname: String): List<LibroDTO>{
        val Libros = libroRepository.getLibrosbyName(bookname.lowercase())

        if (Libros.isEmpty())
            throw LibroException("List of books is empty.")

        return Libros.map{
            libroMapper.fromEntity(it)
        }
    }

    override  fun updateLibro(libroDTO: LibroDTO): LibroDTO {
        getLibro(libroDTO.ISBN)
        if(libroDTO.ISBN.toString().length != 13) {
            throw IllegalArgumentException("ISBN must have 13 numbers")
        }
        if(libroDTO.bookname.length < 3) {
            throw IllegalArgumentException("the Bookname must have at least 3 characters")
        }
        if(libroDTO.bookname == "Default" || libroDTO.author == "Default" || libroDTO.year <= 0 || libroDTO.price <= 0 || libroDTO.quantity <= -1){
            throw IllegalArgumentException("the Book Info must be completed")
        }

        Almacenardatos (libroDTO.ISBN, "UPDATE", "Se hizo un Update de la tabla")

        libroRepository.save(libroMapper.toEntity(libroDTO))

        return libroDTO
    }

    override fun deleteLibro(ISBN: Long) {
        val exists = libroRepository.existsById(ISBN)

        if (!exists)
            throw LibroException("Book with ISBN $ISBN is not here :(")

        Almacenardatos (ISBN, "DELETE", "Se hizo un delete en la tabla")

        libroRepository.deleteById(ISBN)

    }

    override fun getLibroSort(): List<LibroDTO>{
        val libros = libroRepository.getAlllibrosSorted()

        if (libros.isEmpty())
            throw LibroException("List of books is empty.")


        return libros.map{
            libroMapper.fromEntity(it)
        }
    }

    override fun getLibroSortISBN(): List<LibroDTO>{
        val libros = libroRepository.getAlllibrosSortedISBN()

        if (libros.isEmpty())
            throw LibroException("List of books is empty.")


        return libros.map{
            libroMapper.fromEntity(it)
        }
    }

    override fun updateLibroAvil(libroDTO: LibroDTO): LibroDTO {
        getLibro(libroDTO.ISBN)

        libroDTO.avil =  !libroDTO.avil

        if (libroDTO.avil){
            Almacenardatos (libroDTO.ISBN, "HABILITADO", "se hizo un habilitado del libro")
        }else{
            Almacenardatos (libroDTO.ISBN, "DESHABILITADO", "se hizo un dehabilitado del libro")
        }

        libroRepository.save(libroMapper.toEntity(libroDTO))

        return libroDTO
    }

    fun Almacenardatos (ISBN: Long, LogMov: String, LogDesc: String) {
        val logDTO = StoreLogDTO(UUID.randomUUID(),ISBN,90258332,LogMov,LogDesc,Date())
        val log = logMapper.toEntity(logDTO)
        storelogRepository.save(log)
        return
    }


}