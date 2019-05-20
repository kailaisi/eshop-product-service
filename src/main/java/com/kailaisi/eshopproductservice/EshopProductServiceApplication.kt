package com.kailaisi.eshopproductservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
open class EshopProductServiceApplication
fun main(args: Array<String>) {
    runApplication<EshopProductServiceApplication>(*args)
}
