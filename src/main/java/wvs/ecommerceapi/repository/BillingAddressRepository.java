package wvs.ecommerceapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wvs.ecommerceapi.entity.BillingAddressEntity;

public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity, Long> {
}
