package com.crudoperation.jw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


import com.stripe.Stripe;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {
    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    @Bean
    public void initStripe() {
        Stripe.apiKey = stripeSecretKey;
    }
}
