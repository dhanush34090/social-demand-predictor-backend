package com.sih.socialdemand.repository;

import com.sih.socialdemand.entity.SocialData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialDataRepository extends JpaRepository<SocialData, Long> {
    List<SocialData> findByProductIdOrderByDataDateDesc(Long productId);
}
