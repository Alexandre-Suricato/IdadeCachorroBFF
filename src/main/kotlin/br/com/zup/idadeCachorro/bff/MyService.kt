package br.com.zup.idadeCachorro.bff

import br.com.zup.beagle.builder.core.style
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.Widget
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

    fun createWidget(): Widget = Container(listOf(
            /*Image(
                    path =
                    ImagePath.Local.justWeb(
                        webUrl = "/localhost:8080/cachorro.png"
                    ),
                    mode = ImageContentMode.CENTER
            ),*/
            Text(text = "Digite a idade do seu cachorro, para descobrir a idade em anos humanos.")
                    .applyStyle(style = Style(backgroundColor = "#52c8e3", size = Size(80.unitPercent()),
                            cornerRadius = CornerRadius(20.0),
                            padding = EdgeValue(
                                    all = 20.unitReal()
                            )
                    ))
                    .applyFlex(Flex(alignContent = AlignContent.CENTER)),
            TextInput(placeholder = "Digite a idade do cachorro")
                    .applyStyle(style = Style(backgroundColor = "#FFFFFF", size = Size(80.unitReal()),
                            cornerRadius = CornerRadius(20.0),
                            margin = EdgeValue(
                                    horizontal = 20.unitReal(),
                                    vertical = 50.unitReal()
                            )
                    )),
            Text(text = " -------- "),
            Button(text = "Descobrir a idade")
    ))
            .applyStyle(Style(flex = Flex(grow = 1.0)))
            .applyFlex(Flex(alignContent = AlignContent.CENTER, alignItems = AlignItems.CENTER))
}