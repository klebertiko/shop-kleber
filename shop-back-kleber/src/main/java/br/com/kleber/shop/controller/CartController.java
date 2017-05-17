package br.com.kleber.shop.controller;

import br.com.kleber.shop.model.Cart;
import br.com.kleber.shop.model.CartItem;
import br.com.kleber.shop.model.Product;
import br.com.kleber.shop.service.CartService;
import br.com.kleber.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@RestController
@RequestMapping("/api/cart")
public class CartController {

    private CartService cartService;

    private ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart add(@RequestBody Product product) {

        product.setQuantity(product.getQuantity() - 1);
        productService.save(product);

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);


        Cart cart = this.cartService.getOrCreateCurrent();
        cart.getCartItems().add(cartItem);

        return this.cartService.save(cart);
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart remove(@RequestBody Product product) {

        product.setQuantity(product.getQuantity() + 1);
        this.productService.save(product);

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);

        return this.cartService.remove(cartItem);
    }

    @ResponseBody
    @RequestMapping(value = "/current", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart getOrCreateCurrent() {
        return this.cartService.getOrCreateCurrent();
    }
}