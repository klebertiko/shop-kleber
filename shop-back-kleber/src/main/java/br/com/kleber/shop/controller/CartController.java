package br.com.kleber.shop.controller;

import br.com.kleber.shop.model.Cart;
import br.com.kleber.shop.model.CartItem;
import br.com.kleber.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * Created by kleber on 4/24/17.
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> add(@RequestBody CartItem cartItem) {
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> remove(@RequestBody CartItem cartItem) {
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/current", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getOrCreateCurrent() {
        return new ResponseEntity<>(this.cartService.getOrCreateCurrent(), HttpStatus.OK) ;
    }
}