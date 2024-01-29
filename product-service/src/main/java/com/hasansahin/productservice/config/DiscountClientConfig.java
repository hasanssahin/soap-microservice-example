package com.hasansahin.productservice.config;

import com.hasansahin.productservice.client.DiscountClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class DiscountClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.hasansahin.discount");
        return marshaller;
    }
    @Bean
    public DiscountClient discountClient(Jaxb2Marshaller marshaller) {
        DiscountClient client = new DiscountClient();
        client.setDefaultUri("http://localhost:8085/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
