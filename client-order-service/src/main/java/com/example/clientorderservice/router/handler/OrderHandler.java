package com.example.clientorderservice.router.handler;

import com.example.clientorderservice.model.Order;
import com.example.clientorderservice.server.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderHandler {

    private final OrderService orderService;

    public OrderHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    public Mono<ServerResponse> getOrders(ServerRequest serverRequest) {
        return ServerResponse.ok().body(orderService.getOrders(), Order.class);
    }

    public Mono<ServerResponse> saveOrder(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Order.class)
                .flatMap(orderService.saveOrder())
                .flatMap(body -> ServerResponse.ok().bodyValue(body));
    }
}
