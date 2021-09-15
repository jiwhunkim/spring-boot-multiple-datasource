package com.helloworld.domain

import com.helloworld.DomainApplication
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DomainApplication::class])
class HelloWorldDomainServiceTest(private val helloWorldDomainService: HelloWorldDomainService) {

    @Test
    fun helloWord() {
        Assertions.assertEquals("HelloWorld", helloWorldDomainService.hello())
    }
}
