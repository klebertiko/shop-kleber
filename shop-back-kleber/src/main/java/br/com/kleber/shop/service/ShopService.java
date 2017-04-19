package br.com.kleber.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by kleber on 3/27/17.
 */
@Service
public class ShopService {

    @GetMapping("/shop")
    public Mono<String> welcome() {
        return Mono.just("Start shopping");
    }

}
