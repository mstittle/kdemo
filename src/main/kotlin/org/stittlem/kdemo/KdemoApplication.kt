package org.stittlem.kdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KdemoApplication

fun main(args: Array<String>) {
	runApplication<KdemoApplication>(*args)
}
