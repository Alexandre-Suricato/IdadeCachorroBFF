package br.com.zup.idadeCachorro.bff

import org.springframework.stereotype.Service

@Service
class Calculadora {

    fun calculadora(dogAge: String): Result {

        val dogAgeInt = dogAge.toInt()
        val result = dogAgeInt * 7

        return Result(value = result.toString())
    }
}

data class Result (val value: String)