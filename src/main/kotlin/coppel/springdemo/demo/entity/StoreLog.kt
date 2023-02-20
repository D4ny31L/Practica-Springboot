package coppel.springdemo.demo.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.*
import org.hibernate.annotations.CurrentTimestamp

import org.hibernate.annotations.Type
import java.util.Date
import java.util.UUID

@Entity(name = "Bookstorelog90258332")
data class StoreLog (
    @Id
    var uniqueid: UUID?,
    var ISBN: Long,
    var employeenumber: Int,
    var movementtype: String,
    var movementdescription: String,
    var movementdate: Date
)

