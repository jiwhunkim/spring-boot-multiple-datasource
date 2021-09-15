package com.helloworld.domain

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class HelloWorldDomainService {
    @Value("\${hello.world}")
    lateinit var helloWorld: String

    fun hello(): String {
        return helloWorld
    }
}
