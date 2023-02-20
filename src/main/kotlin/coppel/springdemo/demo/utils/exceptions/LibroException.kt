package coppel.springdemo.demo.utils.exceptions

import org.apache.logging.log4j.message.Message

class LibroException(override val message: String?): Exception(message)
