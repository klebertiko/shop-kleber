package br.com.kleber.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by kleber on 3/27/17.
 */
@RestController
public class ShopController {

    @GetMapping("/shop")
    public Mono<String> welcome() {
        return Mono.just("Start shopping");
    }

}
