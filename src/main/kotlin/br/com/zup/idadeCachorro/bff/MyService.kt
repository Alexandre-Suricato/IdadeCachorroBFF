package br.com.zup.idadeCachorro.bff

import br.com.zup.beagle.builder.core.style
import br.com.zup.beagle.builder.widget.size
import br.com.zup.beagle.context.contextData
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.ui.text
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.widget.action.RequestActionMethod
import br.com.zup.beagle.widget.action.SendRequest
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.context.valueOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.*
import org.springframework.stereotype.Service

@Service
class MyService {

    /**
     * Armazena o valor digitado na tela nessa variável
     */
    data class Variables(
            val dogAge: String
    )

    fun createScreen() =
            Screen(child = this.createWidget(), style = Style(backgroundColor = "#9af2ff"))

    fun createWidget(): Widget = Container(
            context = ContextData(id = "variables", value = Variables(dogAge = "")),
            children = listOf(
                Image(
                        path =
                        ImagePath.Local.justMobile(
                                mobileId = "cachorro"
                        )
                ).applyStyle(Style(
                            size = Size(
                            width = 160.unitReal(),
                            height = 160.unitReal()
                        ),
                        margin = EdgeValue(
                                vertical = 50.unitReal()
                        )
                )),

                Container(listOf(
                        Text(text = "Digite a idade do seu cachorro, para descobrir a idade em anos humanos.")
                ))
                .applyStyle(style = Style(backgroundColor = "#52c8e3", size = Size(80.unitPercent()),
                        cornerRadius = CornerRadius(20.0),
                        padding = EdgeValue(
                                all = 20.unitReal()
                        )
                )),

                TextInput(placeholder = "Digite a idade do cachorro", onChange = listOf(
                        //Armazenar o valor no contexto global do beagle
                        SetContext(contextId = "variables", path = "dogAge", value = "@{onChange.value}")
                ))
                        .applyStyle(style = Style(backgroundColor = "#FFFFFF",
                                size = Size(height = 60.unitReal(), width = 60.unitPercent()),
                                cornerRadius = CornerRadius(20.0),
                                margin = EdgeValue(
                                        vertical = 50.unitReal()
                                )
                )),
                Button(text = "Descobrir a idade" , onPress = listOf(
                        SendRequest(url = "/calculadora/@{variables.dogAge}", method = RequestActionMethod.GET,
                                onSuccess = listOf(
                                        Alert(title = "", message = "A idade do cachorro em anos humanos é: @{onSuccess.data} anos")),
                                onError = listOf(
                                        Alert(title = "ERRO", message = "Erro")))
                )))
    )
            .applyStyle(Style(flex = Flex(grow = 1.0)))
            .applyFlex(Flex(alignContent = AlignContent.CENTER, alignItems = AlignItems.CENTER))
}