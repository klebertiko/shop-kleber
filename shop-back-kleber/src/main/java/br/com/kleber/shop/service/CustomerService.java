package br.com.kleber.shop.service;

import br.com.kleber.shop.model.Customer;
import br.com.kleber.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by kleber on 24/04/17.
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final MoipService moipService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, MoipService moipService) {
        this.customerRepository = customerRepository;
        this.moipService = moipService;
    }

    public Customer findByEmail(final String email) {
        return this.customerRepository.findByEmail(email);
    }

    public Map<String, Object> findCustomer(String moipId) throws IOException {
        return this.moipService.findCustomer(moipId);
    }
}