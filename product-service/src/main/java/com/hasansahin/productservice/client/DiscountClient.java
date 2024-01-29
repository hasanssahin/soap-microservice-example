package com.hasansahin.productservice.client;

import com.hasansahin.discount.DiscountRequest;
import com.hasansahin.discount.DiscountResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class DiscountClient extends WebServiceGatewaySupport {

    public DiscountResponse discount(DiscountRequest discountRequest){
        return (DiscountResponse) getWebServiceTemplate().marshalSendAndReceive(discountRequest);
    }
}
