package com.hasansahin.productservice.service;

import com.hasansahin.discount.DiscountRequest;
import com.hasansahin.discount.DiscountResponse;
import com.hasansahin.productservice.client.DiscountClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountClient client;

    public DiscountResponse discount(DiscountRequest discountRequest){
        return client.discount(discountRequest);
    }
}
