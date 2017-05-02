package br.com.kleber.shop.service;

import br.com.kleber.shop.model.Cart;
import br.com.kleber.shop.model.ItemCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kleber on 4/24/17.
 */
@Service
public class CartService {

    @Autowired
    private Cart cart;

    private List<ItemCart> itemsCart  = new ArrayList<>();

    public Cart add(ItemCart itemCart) {
        this.itemsCart.add(itemCart);
        this.cart.setItemCart(itemsCart);
        return this.cart;
    }

    public Cart remove(ItemCart itemCart) {
        this.itemsCart.remove(itemCart);
        this.cart.setItemCart(itemsCart);
        return this.cart;
    }
}