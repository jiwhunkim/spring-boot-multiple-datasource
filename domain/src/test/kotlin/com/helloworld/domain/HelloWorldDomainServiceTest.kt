package com.helloworld.domain

import com.helloworld.DomainApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DomainApplication::class])
class HelloWorldDomainServiceTest {

    @Autowired
    lateinit var helloWorldDomainService: HelloWorldDomainService

    @Test
    fun helloWord() {
        println(helloWorldDomainService.hello())
    }
}
