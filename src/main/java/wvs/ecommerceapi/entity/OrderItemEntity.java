package wvs.ecommerceapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity {

    @EmbeddedId
    private OrderItemId id;

    @Column(name = "sales_price")
    private BigDecimal salePrice;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderItemId getOrderItemId() {
        return id;
    }

    public void setOrderItemId(OrderItemId orderItemId) {
        this.id = orderItemId;
    }

    public OrderItemEntity() {
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
