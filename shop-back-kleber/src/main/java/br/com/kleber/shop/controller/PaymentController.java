package br.com.kleber.shop.controller;

import br.com.kleber.shop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/secure/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Map<String, Object> find(@PathVariable String id) throws IOException {
        return this.paymentService.findStatus(id);
    }
}
