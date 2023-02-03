package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.jpa.OrderEntity;
import com.example.orderservice.jpa.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderDto createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getQty() * orderDto.getUnitPrice());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderEntity entity = modelMapper.map(orderDto, OrderEntity.class);

        this.orderRepository.save(entity);

        OrderDto value = modelMapper.map(entity, OrderDto.class);

        return value;
    }

    public OrderDto getOrderByOrderId(String orderId) {
        OrderEntity orderEntity = this.orderRepository.findByOrderId(orderId);
        OrderDto value = new ModelMapper().map(orderEntity, OrderDto.class);

        return value;
    }

    public List<OrderEntity> getOrdersByUserId(String userId) {
        return this.orderRepository.findByUserId(userId);
    }

}
