package com.example.clientorderservice.router;

import com.example.clientorderservice.router.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class OrderRouter {

    @Bean
    public RouterFunction<ServerResponse> orders(OrderHandler orderHandler) {
        return route(GET("/orders"), orderHandler::getOrders)
                .andRoute(POST("/orders").and(accept(MediaType.APPLICATION_JSON)), orderHandler::saveOrder);
    }

}
