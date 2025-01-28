package wvs.ecommerceapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wvs.ecommerceapi.controller.dto.CreateOrderDto;
import wvs.ecommerceapi.service.OrderService;

import java.net.URI;

@RestController
@RequestMapping(path ="/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDto data){
        var order = orderService.createOrder(data);
        return ResponseEntity.created(URI.create("/orders/" + order.getOrderId())).build();
    }
}
