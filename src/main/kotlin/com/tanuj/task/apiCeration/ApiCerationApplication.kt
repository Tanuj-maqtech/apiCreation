package com.tanuj.task.apiCeration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["com.tanuj.task.apiCeration"])
class ApiCerationApplication

fun main(args: Array<String>) {

	runApplication<ApiCerationApplication>(*args)
}
