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
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.*
import org.springframework.stereotype.Service

@Service
class MyService {

    fun createScreen() =
            Screen(child = this.createWidget(), style = Style(backgroundColor = "#00b9d6"))

    fun createWidget(): Widget = Container(
            context = ContextData(id = "context", value = DogInfo(0, false)),
            children = listOf(
            Image(
                    path =
                    ImagePath.Local.justMobile(
                            mobileId = "cachorro"
                    )
            ).applyStyle(Style(size = Size(
                    width = 160.unitReal(),
                    height = 160.unitReal()
            ))).applyFlex(Flex(alignSelf = AlignSelf.CENTER)),
            Container(listOf(
                    Text(text = "Digite a idade do seu cachorro, para descobrir a idade em anos humanos.")
            ))
                    .applyStyle(style = Style(backgroundColor = "#52c8e3", size = Size(80.unitPercent()),
                            cornerRadius = CornerRadius(20.0),
                            padding = EdgeValue(
                                    all = 20.unitReal()
                            )
                    ))
                    .applyFlex(Flex(alignContent = AlignContent.CENTER)),
            TextInput(placeholder = "Digite a idade do cachorro" , type = TextInputType.NUMBER, onChange = listOf(
                    //Armazenar o valor no contexto global do beagle
                    SetContext(contextId = "context", path = "age", value = "@{onChange}")
            ))
                    .applyStyle(style = Style(backgroundColor = "#FFFFFF", size = Size(height = 120.unitReal(), width = 50.unitPercent()),
                            cornerRadius = CornerRadius(20.0),
                            margin = EdgeValue(
                                    horizontal = 20.unitReal(),
                                    vertical = 50.unitReal()
                            )
                    )),
            Button(text = "Descobrir a idade", onPress = listOf(
                SetContext(contextId = "context", path = "shouldPresentAge", value = true)
            )),
            AgeComponent(dogAge = expressionOf("@{context.age}"),
                    shouldPresentAge = expressionOf("@{context.shouldPresentAge}"))
    ))
            .applyStyle(Style(flex = Flex(grow = 1.0)))
            .applyFlex(Flex(alignContent = AlignContent.CENTER, alignItems = AlignItems.CENTER))
}