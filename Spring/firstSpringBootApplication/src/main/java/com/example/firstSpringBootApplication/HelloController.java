package com.example.firstSpringBootApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    //VALUE: injeta valores de configuração (.properties, .yml...) em variaveis, mets, construtores em runtime
    // @Value("${<chave de uma propriedade da aplicação>}")  | ex:@Value("${property.name}") lê valores definidos em application.properties.
    @Value("${spring.application.name}")
    private String nomeDaAplicacao;

    //!! quando tem @RequestMapping("/"), o spring verifica primeiro se ha um arquivo estatico pra essa rota e, se tiver, o spring entrega
    //o arquivo direto pro navegador, entao NEM CHAMA O CONTROLLER
    //ORDEM DE RESOLUÇAO DE ROTA NO SPRING BOOT: arquivos estaticos(/static, /resources...) -> controllers(@Controller, @RestController) -> templates
    // ANTES CON "/": Browser → Spring → static/index.html → resposta
    // DEPOIS COM "/test": Browser → Controller → return "index.html"

    @RequestMapping("/test")
    public String index() {
        System.out.println("app name: " + nomeDaAplicacao);
        return "index";
        //retornou o NOME do VIEW que deve ser RETORNADO AO BROWSER
    }
}
