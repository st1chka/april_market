package ru.geekbrains.april.market.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.april.market.dtos.OrderItemDto;
//import ru.geekbrains.april.market.services.OrderService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
//    private final OrderService orderService;

    @GetMapping
    public String getAllOrders(){
       return "Hello";
    }
}
