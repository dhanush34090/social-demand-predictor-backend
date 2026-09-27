package com.sih.socialdemand.service.impl;

import com.sih.socialdemand.dto.SocialDataRequest;
import com.sih.socialdemand.entity.Product;
import com.sih.socialdemand.entity.SocialData;
import com.sih.socialdemand.repository.ProductRepository;
import com.sih.socialdemand.repository.SocialDataRepository;
import com.sih.socialdemand.service.SocialDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialDataServiceImpl implements SocialDataService {

    private final SocialDataRepository socialRepository;
    private final ProductRepository productRepository;

    public SocialDataServiceImpl(SocialDataRepository socialRepository, ProductRepository productRepository) {
        this.socialRepository = socialRepository;
        this.productRepository = productRepository;
    }

    @Override
    public SocialData create(SocialDataRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));

        SocialData data = new SocialData();
        data.setProduct(product);
        data.setPlatform(request.getPlatform());
        data.setContent(request.getContent());
        data.setLikes(request.getLikes());
        data.setComments(request.getComments());
        data.setShares(request.getShares());
        data.setMentions(request.getMentions());
        data.setSentimentScore(request.getSentimentScore());
        data.setTrendScore(request.getTrendScore());
        data.setDataDate(request.getDataDate());

        return socialRepository.save(data);
    }

    @Override
    public List<SocialData> getAll() {
        return socialRepository.findAll();
    }

    @Override
    public List<SocialData> getByProduct(Long productId) {
        return socialRepository.findByProductIdOrderByDataDateDesc(productId);
    }
}
