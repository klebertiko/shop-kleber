package br.com.kleber.shop.repository;

import br.com.kleber.shop.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by renan on 05/04/2017.
 */

@Component
public class CustomerRepository {

    private final Map<String, Customer> customers = Collections.synchronizedMap(new HashMap<>());

    public CustomerRepository() {
        this.customers.put("moip@email.com", new Customer("moip@email.com", "moip", ""));
    }

    public Customer findByEmail(String email) {
        return this.customers.get(email);
    }
}