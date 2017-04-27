package br.com.kleber.shop.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by renan on 05/04/2017.
 */
@Entity
public class Product implements Serializable {

    private final String name;
    private final String image;
    private final String detail;
    private final BigDecimal price;
    private final Integer quantity;
    @Id
    @GeneratedValue
    private Long id;

    @JsonCreator
    public Product(
            String name,
            String image,
            String detail,
            BigDecimal price,
            Integer quantity) {
        this.name = name;
        this.image = image;
        this.detail = detail;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDetail() {
        return detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @JsonGetter
    public String getProduct() {
        return this.name;
    }
}