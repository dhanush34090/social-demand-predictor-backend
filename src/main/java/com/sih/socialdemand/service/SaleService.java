package com.sih.socialdemand.service;

import com.sih.socialdemand.dto.SaleRequest;
import com.sih.socialdemand.entity.Sale;
import java.util.List;

public interface SaleService {
    Sale create(SaleRequest request);
    List<Sale> getAll();
    List<Sale> getByProduct(Long productId);
}
