package br.com.kleber.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<CartItem> cartItems;

    public Cart() {

    }

    public Cart(Customer customer, Collection<CartItem> cartItems) {
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

}
