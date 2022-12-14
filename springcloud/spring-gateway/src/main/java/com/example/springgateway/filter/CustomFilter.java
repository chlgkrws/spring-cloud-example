package com.example.springgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // Custom Pre Filter
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Custom Pre filter ::  request id -> {}" , request.getId());

            // Custom Post filter
            // Mono는 스프링 5에 추가된 webflux 기능으로, 단일값을 전달할 때 사용함
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Custom Post filter :: response code -> {}", response.getStatusCode());
            }));
        });
    }

    // Configuration properties
    public static class Config{
    }

}
