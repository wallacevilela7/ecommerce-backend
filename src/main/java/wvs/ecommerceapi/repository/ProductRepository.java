package wvs.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wvs.ecommerceapi.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
