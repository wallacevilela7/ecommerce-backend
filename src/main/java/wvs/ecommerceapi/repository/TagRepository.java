package wvs.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wvs.ecommerceapi.entity.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
