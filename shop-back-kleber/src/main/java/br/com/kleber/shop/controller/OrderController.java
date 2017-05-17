package br.com.kleber.shop.controller;

import br.com.kleber.shop.model.PreOrderRequest;
import br.com.kleber.shop.model.PreOrderResponse;
import br.com.kleber.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/secure/api/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public Map<String, Object> order(@Valid @RequestBody String body) throws IOException {
        return this.orderService.order(body);
    }

    @RequestMapping(value = "/{id}/payment", method = {RequestMethod.POST})
    public Map<String, Object> payment(@Valid @RequestBody String body, @PathVariable("id") String id) throws IOException {
        return this.orderService.payment(id, body);
    }

    @RequestMapping(value = "calculator", method = {RequestMethod.POST})
    public PreOrderResponse calculator(@Valid @RequestBody PreOrderRequest preOrderRequest) {
        return this.orderService.calculator(preOrderRequest);
    }
}