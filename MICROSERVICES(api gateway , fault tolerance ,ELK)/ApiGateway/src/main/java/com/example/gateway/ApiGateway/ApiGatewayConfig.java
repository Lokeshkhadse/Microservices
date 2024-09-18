package com.example.gateway.ApiGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder
                    .routes()
                .route(predicateSpec -> predicateSpec.path("/users/**") //or ("/**")
                        .uri("lb://USERSERVICE"))
                .route(predicateSpec -> predicateSpec.path("/ratings/**")
                        .uri("lb://RATINGSERVICE"))
                .route(predicateSpec -> predicateSpec.path("/hotels/**","/staffs/**")
                        .uri("lb://HOTELSERVICE"))
                .build();
    }

}
