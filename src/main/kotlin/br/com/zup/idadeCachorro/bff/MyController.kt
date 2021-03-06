package br.com.zup.idadeCachorro.bff

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController(private val myService: MyService) {

    @GetMapping("/screen")
    fun getScreen() = myService.createScreen()

}