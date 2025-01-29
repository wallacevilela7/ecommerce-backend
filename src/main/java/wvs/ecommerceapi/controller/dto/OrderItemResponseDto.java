package wvs.ecommerceapi.controller.dto;

import wvs.ecommerceapi.entity.OrderItemEntity;
import wvs.ecommerceapi.entity.OrderItemId;

import java.math.BigDecimal;

public record OrderItemResponseDto(
        BigDecimal salePrice,
        Integer quantity,
        ProductResponseDto product) {
    public static OrderItemResponseDto fromEntity(OrderItemEntity entity) {
        return new OrderItemResponseDto(
                entity.getSalePrice(),
                entity.getQuantity(),
                ProductResponseDto.fromEntity(entity.getOrderItemId().getProduct())
        );

    }
}
