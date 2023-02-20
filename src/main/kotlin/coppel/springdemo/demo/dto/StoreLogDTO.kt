package coppel.springdemo.demo.entity

import jakarta.persistence.Id
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import org.hibernate.annotations.CurrentTimestamp
import java.util.*

data class StoreLogDTO (
    val uniqueid: UUID?,
    var ISBN: Long,
    var employeenumber: Int,
    var movementtype: String,
    var movementdescription: String,
    var movementdate: Date
)