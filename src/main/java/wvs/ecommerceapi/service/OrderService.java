package wvs.ecommerceapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import wvs.ecommerceapi.controller.dto.CreateOrderDto;
import wvs.ecommerceapi.controller.dto.OrderItemDto;
import wvs.ecommerceapi.controller.dto.OrderSummaryDto;
import wvs.ecommerceapi.entity.*;
import wvs.ecommerceapi.excepiton.CreateOrderException;
import wvs.ecommerceapi.repository.OrderItemRepository;
import wvs.ecommerceapi.repository.OrderRepository;
import wvs.ecommerceapi.repository.ProductRepository;
import wvs.ecommerceapi.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(UserRepository userRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(CreateOrderDto data) {

        var order = new OrderEntity();

        //1 validar se usuario existe
        var user = validateUser(data);

        //2 validar se produto existe na base de dados
        var orderItems = validateOrderItems(order, data);

        //3 calcular o valor total do pedido
        var total = calculateOrderTotal(orderItems);

        //4 mapear os dados do dto para a entidade
        order.setOrderDate(LocalDateTime.now());
        order.setUser(user);
        order.setTotal(total);
        order.setItems(orderItems);

        //5 salvar o pedido no banco de dados
        return orderRepository.save(order);
    }

    private BigDecimal calculateOrderTotal(List<OrderItemEntity> items) {
        return items.stream()
                .map((i -> i.getSalePrice().multiply(BigDecimal.valueOf(i.getQuantity()))))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private List<OrderItemEntity> validateOrderItems(OrderEntity order, CreateOrderDto data) {
        if (data.items().isEmpty()) {
            throw new CreateOrderException("Order items is empty");
        }

        return data.items()
                .stream()
                .map(orderItemDto -> getOrderItem(order, orderItemDto))
                .toList();
    }

    private OrderItemEntity getOrderItem(OrderEntity order, OrderItemDto orderItemDto) {
        var orderItemEntity = new OrderItemEntity();
        var id = new OrderItemId();
        var product = getProduct(orderItemDto.productId());

        id.setOrder(order);
        id.setProduct(product);

        orderItemEntity.setOrderItemId(id);
        orderItemEntity.setQuantity(orderItemDto.quantity());
        orderItemEntity.setSalePrice(product.getPrice());

        return orderItemEntity;
    }

    private ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new CreateOrderException("Product not found"));
    }


    private UserEntity validateUser(CreateOrderDto data) {
        return userRepository.findById(data.userId())
                .orElseThrow(() -> new CreateOrderException("User not found"));
    }

    public Page<OrderSummaryDto> listOrders(Integer page, Integer pageSize) {
        return orderRepository.findAll(PageRequest.of(page, pageSize))
                .map(entity -> {
                    return new OrderSummaryDto(
                            entity.getOrderId(),
                            entity.getOrderDate(),
                            entity.getUser().getUserId(),
                            entity.getTotal()
                    );
                });
    }
}
