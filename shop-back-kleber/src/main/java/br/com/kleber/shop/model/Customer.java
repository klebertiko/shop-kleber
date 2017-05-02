package br.com.kleber.shop.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

/**
 * Created by kleber on 24/04/17.
 */
@Entity
public class Customer implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String password;

    private String paymentIdentification;


    public Customer() {

    }

    @JsonCreator
    public Customer(
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("paymentId") String paymentIdentification) {

        this.id = 1L;
        this.email = email;
        this.password = password;
        this.paymentIdentification = paymentIdentification;
    }

    public String getEmail() {
        return email;
    }

    public String getPaymentIdentification() {
        return paymentIdentification;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonGetter
    public String getOwnId() {
        return this.id.toString();
    }
}
