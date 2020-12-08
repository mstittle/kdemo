package org.stittlem.kdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class KdemoApplication
fun main(args: Array<String>) {
	runApplication<KdemoApplication>(*args)
}
