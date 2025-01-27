package wvs.ecommerceapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wvs.ecommerceapi.entity.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
