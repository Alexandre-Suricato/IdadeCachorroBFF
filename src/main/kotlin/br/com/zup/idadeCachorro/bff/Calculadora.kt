package br.com.zup.idadeCachorro.bff

import org.springframework.stereotype.Service

@Service
class Calculadora {

    fun calculadora(dogAge: String): String{

        val dogAgeInt = dogAge.toInt()
        val result = dogAgeInt * 7

        return result.toString()
    }
}