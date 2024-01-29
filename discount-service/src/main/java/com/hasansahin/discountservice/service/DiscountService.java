package com.hasansahin.discountservice.service;

import com.hasansahin.discount.DiscountRequest;
import com.hasansahin.discount.DiscountResponse;
import com.hasansahin.discountservice.exception.CategoryNotFoundException;
import com.hasansahin.discountservice.model.Category;
import com.hasansahin.discountservice.model.Discount;
import com.hasansahin.discountservice.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final CategoryService categoryService;
    private final DiscountRepository discountRepository;

    public DiscountResponse discount(DiscountRequest discountRequest){
        Category category = categoryService.getCategoryByUuid(discountRequest.getCategoryUuid());
        Discount discount = discountRepository.findByCodeAndCategoryExternalCategoryUuid(discountRequest.getCode(), category.getExternalCategoryUuid()).orElse(null);
        if(discount!=null){
            float newPrice = discountRequest.getPrice() - discount.getDiscountPrice();
            DiscountResponse discountResponse=new DiscountResponse();
            discountResponse.setCode(discountRequest.getCode());
            discountResponse.setNewPrice(newPrice);
            discountResponse.setOldPrice(discountRequest.getPrice());
            discountResponse.setAppliedDiscount(discount.getDiscountPrice());
            discountResponse.setResult(true);
            discountResponse.setMessage("Discount applied successfully.");
            return discountResponse;
        }else{
            DiscountResponse discountResponse=new DiscountResponse();
            discountResponse.setCode(discountRequest.getCode());
            discountResponse.setNewPrice(discountRequest.getPrice());
            discountResponse.setOldPrice(discountRequest.getPrice());
            discountResponse.setAppliedDiscount(0);
            discountResponse.setResult(false);
            discountResponse.setMessage("Discount failed.");
            return discountResponse;
        }
    }
}
