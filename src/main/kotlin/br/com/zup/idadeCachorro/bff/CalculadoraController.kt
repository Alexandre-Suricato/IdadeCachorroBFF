package br.com.zup.idadeCachorro.bff

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculadoraController() {

    @GetMapping("/calculadora/{dogAge}")
    fun calculadora(@PathVariable("dogAge") dogAge: String) = Calculadora().calculadora(dogAge)

}