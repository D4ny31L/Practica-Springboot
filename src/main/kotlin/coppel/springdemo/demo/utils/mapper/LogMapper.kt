package coppel.springdemo.demo.utils.mapper

import coppel.springdemo.demo.entity.StoreLog
import coppel.springdemo.demo.entity.StoreLogDTO
import org.springframework.stereotype.Service


@Service
class LogMapper: Mapper<StoreLogDTO, StoreLog> {

    override fun fromEntity(entity: StoreLog): StoreLogDTO = StoreLogDTO(
        entity.uniqueid,
        entity.ISBN,
        entity.employeenumber,
        entity.movementtype,
        entity.movementdescription,
        entity.movementdate
    )


    override fun toEntity(domain: StoreLogDTO): StoreLog = StoreLog(
        domain.uniqueid,
        domain.ISBN,
        domain.employeenumber,
        domain.movementtype,
        domain.movementdescription,
        domain.movementdate
    )
}