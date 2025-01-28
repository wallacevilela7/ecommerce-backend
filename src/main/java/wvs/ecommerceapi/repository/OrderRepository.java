package wvs.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wvs.ecommerceapi.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
