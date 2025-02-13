package com.codingshuttle.ecommerce.api_gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalFilters implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //pre-filter
        log.info("logging from:Global pre,{}",exchange.getRequest().getURI());
       return chain.filter(exchange).then(Mono.fromRunnable(()->{  // post filter
           log.info("logging from Global post:{}",exchange.getResponse().getStatusCode());
       }));
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
