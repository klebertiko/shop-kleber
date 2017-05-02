package br.com.kleber.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Component
public class Cart implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Collection<ItemCart> itemCart;

    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<ItemCart> getItemCart() {
        return itemCart;
    }

    public void setItemCart(Collection<ItemCart> itemCart) {
        this.itemCart = itemCart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
