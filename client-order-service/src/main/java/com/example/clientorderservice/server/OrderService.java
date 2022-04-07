package com.example.clientorderservice.server;

import com.example.clientorderservice.model.Order;
import com.example.clientorderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.function.Function;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Function<Order, Mono<Order>> saveOrder() {
        return order -> orderRepository.save(order.toBuilder()
                .id(UUID.randomUUID().toString())
                .build());
    }
}
