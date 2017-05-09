package br.com.kleber.shop.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Collection<CartItem> cartItems;

    private Customer customer;

    public Cart() {

    }

    public Cart(Customer customer, Collection<CartItem> cartItems) {
        this.customer = customer;
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public Collection<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Collection<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
