package wvs.ecommerceapi.controller.dto;

import wvs.ecommerceapi.entity.OrderEntity;
import wvs.ecommerceapi.entity.OrderItemEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponseDto(Long orderId,
                               BigDecimal total,
                               LocalDateTime orderDate,
                               UUID userId,
                               List<OrderItemResponseDto> items) {

    public static OrderResponseDto fromEntity(OrderEntity orderEntity) {
        return new OrderResponseDto(
                orderEntity.getOrderId(),
                orderEntity.getTotal(),
                orderEntity.getOrderDate(),
                orderEntity.getUser().getUserId(),
                getItems(orderEntity.getItems())
        );
    }

    private static List<OrderItemResponseDto> getItems(List<OrderItemEntity> items) {
        return items.stream()
                .map(OrderItemResponseDto::fromEntity)
                .toList();
    }
}
