package br.com.kleber.shop.service;

import br.com.kleber.shop.model.Cart;
import br.com.kleber.shop.model.CartItem;
import br.com.kleber.shop.model.Customer;
import br.com.kleber.shop.model.Product;
import br.com.kleber.shop.repository.CartRepository;
import br.com.kleber.shop.repository.CustomerRepository;
import br.com.kleber.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
        Optional<Cart> current = this.cartRepository.getCurrent();
        if (current.isPresent()) {
            return current.get();
        } else {
            Cart cart = new Cart();
            cart.setCartItems(new ArrayList<>());
            return this.cartRepository.save(cart);
        }
    }

    public Cart save(Cart cart) {
        return this.cartRepository.save(cart);
    }

    public Cart remove(CartItem cartItem) {
        Optional<Cart> current = this.cartRepository.getCurrent();
        if (current.isPresent()) {
            current.get().getCartItems().remove(cartItem);
            return this.cartRepository.save(current.get());
        }
        return current.get();
    }
}