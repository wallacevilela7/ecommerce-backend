package wvs.ecommerceapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wvs.ecommerceapi.controller.dto.ApiResponse;
import wvs.ecommerceapi.controller.dto.CreateOrderDto;
import wvs.ecommerceapi.controller.dto.OrderSummaryDto;
import wvs.ecommerceapi.controller.dto.PaginationResponse;
import wvs.ecommerceapi.service.OrderService;

import java.net.URI;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDto data) {
        var order = orderService.createOrder(data);
        return ResponseEntity.created(URI.create("/orders/" + order.getOrderId())).build();
    }

    @GetMapping
    public ResponseEntity<ApiResponse<OrderSummaryDto>> listOrders(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        var response = orderService.listOrders(page, pageSize);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        response.getContent(),
                        new PaginationResponse(
                                response.getNumber(),
                                response.getSize(),
                                response.getTotalPages(),
                                response.getTotalElements()
                        )
                )
        );

    }
}
