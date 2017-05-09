package br.com.kleber.shop.service;

import br.com.kleber.shop.model.Cart;
import br.com.kleber.shop.model.CartItem;
import br.com.kleber.shop.model.Customer;
import br.com.kleber.shop.repository.CartRepository;
import br.com.kleber.shop.repository.CustomerRepository;
import br.com.kleber.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by kleber on 4/24/17.
 */
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    public Cart getOrCreateCurrent() {
        Optional<Cart> currentFromEmail = this.cartRepository.getCurrentFromEmail("");
        if (currentFromEmail.isPresent()) {
            return currentFromEmail.get();
        } else {
            Cart cart = new Cart();
            cart.setCartItems(new ArrayList<>());
            cart.setCustomer(new Customer());
            return cartRepository.save(cart);
        }
    }

}