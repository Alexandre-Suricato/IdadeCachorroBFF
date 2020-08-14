package br.com.zup.idadeCachorro.bff

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.context.Bind

@RegisterWidget
data class AgeComponent (
    val dogAge : Bind<Int>,
    val shouldPresentAge : Bind<Boolean>
) : Widget()

data class DogInfo (
        val dogAge : Int,
        val shouldPresentAge : Boolean
)