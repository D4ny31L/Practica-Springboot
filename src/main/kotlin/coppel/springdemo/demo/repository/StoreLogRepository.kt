package coppel.springdemo.demo.repository

import coppel.springdemo.demo.entity.StoreLog
import org.springframework.data.repository.CrudRepository

interface StoreLogRepository: CrudRepository<StoreLog, Long> {
}