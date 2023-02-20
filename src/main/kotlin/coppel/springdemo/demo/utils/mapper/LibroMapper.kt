package coppel.springdemo.demo.utils.mapper

import coppel.springdemo.demo.dto.LibroDTO
import coppel.springdemo.demo.entity.Libro
import org.springframework.stereotype.Service

@Service
class LibroMapper: Mapper<LibroDTO, Libro> {

    override fun fromEntity(entity: Libro): LibroDTO = LibroDTO(
        entity.ISBN,
        entity.bookname,
        entity.author,
        entity.year,
        entity.price,
        entity.quantity,
        entity.avil,
        entity.date
    )


    override fun toEntity(domain: LibroDTO): Libro = Libro(
        domain.ISBN,
        domain.bookname,
        domain.author,
        domain.year,
        domain.price,
        domain.quantity,
        domain.avil,
        domain.date
    )
}