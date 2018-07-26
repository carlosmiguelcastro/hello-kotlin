package com.carloscastro.hellokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HellokotlinApplication

fun main(args: Array<String>) {
    runApplication<HellokotlinApplication>(*args)
}

@RestController
class HelloController(private val helloService: HelloService) {

    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String) =
            helloService.getHelloMessage(name)
}

@Service
class HelloService {

    fun getHelloMessage(name: String) = "Hello $name"
}