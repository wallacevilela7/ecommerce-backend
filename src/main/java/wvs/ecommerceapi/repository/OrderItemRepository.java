package wvs.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wvs.ecommerceapi.entity.OrderItemEntity;
import wvs.ecommerceapi.entity.OrderItemId;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemId> {
}
