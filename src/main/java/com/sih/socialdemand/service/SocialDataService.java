package com.sih.socialdemand.service;

import com.sih.socialdemand.dto.SocialDataRequest;
import com.sih.socialdemand.entity.SocialData;
import java.util.List;

public interface SocialDataService {
    SocialData create(SocialDataRequest request);
    List<SocialData> getAll();
    List<SocialData> getByProduct(Long productId);
}
