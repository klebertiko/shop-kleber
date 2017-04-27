package br.com.kleber.shop.service;

import br.com.kleber.shop.exception.AccessDeniedShopKleberException;
import br.com.kleber.shop.model.Customer;
import br.com.kleber.shop.service.security.JWTService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kleber on 24/04/17.
 */
@Service
public class LoginService {

    private static final String LOGIN_ERROR = "Erro ao realizar o login, por favor tente novamente!";

    private final CustomerService customerService;

    private final JWTService jwtService;

    @Autowired
    public LoginService(CustomerService customerService, JWTService jwtService) {
        this.customerService = customerService;
        this.jwtService = jwtService;
    }

    public Map<String, Object> login(Customer customer) throws IOException {

        customer = auth(customer.getEmail(), customer.getPassword());
        Map<String, Object> map = new HashMap();
        map.put("token", this.jwtService.encode(customer));
        map.put("customer", this.customerService.findCustomer(customer.getPaymentIdentification()));
        return map;
    }

    public Customer auth(String email, String password) throws JsonProcessingException {
        Customer customer = this.customerService.findByEmail(email);

        if (customer == null || !password.equals(customer.getPassword())) {
            throw new AccessDeniedShopKleberException(LOGIN_ERROR);
        }

        return customer;
    }
}
