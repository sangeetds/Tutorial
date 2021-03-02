package com.isdb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IsdbBackendApplication

fun main(args: Array<String>) {
    runApplication<IsdbBackendApplication>(*args)
}
