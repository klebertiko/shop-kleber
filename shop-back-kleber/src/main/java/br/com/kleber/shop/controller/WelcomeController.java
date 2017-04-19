package br.com.kleber.shop.controller;

import br.com.kleber.shop.model.Welcome;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by kleber on 3/27/17.
 */
@RestController
public class WelcomeController {

    @GetMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Welcome> welcome() {
        Welcome welcome = new Welcome();
        welcome.setPhrase("Bem vindo!");
        return Mono.just(welcome);
    }

}
