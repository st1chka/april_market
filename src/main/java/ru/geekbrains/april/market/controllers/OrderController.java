package ru.geekbrains.april.market.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.april.market.dtos.OrderDto;
import ru.geekbrains.april.market.dtos.OrderItemDto;
import ru.geekbrains.april.market.models.Order;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.services.OrderService;
import ru.geekbrains.april.market.services.UserService;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;





@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;


    @GetMapping()
    @Transactional
    public List<OrderDto> getAllOrdersForCurrentUser(Principal principal) {
        User user = userService.findByUsername(principal.getName()).get();
        return orderService.findAllByUser(user).stream().map(OrderDto::new).collect(Collectors.toList());
    }

//    @GetMapping
//    public void createOrder (Principal principal, @RequestParam(name = "address") String address, @RequestParam(name = "phone") Long phone ){
//        User user = userService.findByUsername(principal.getName()).get();
//        orderService.createOrderForCurrentUser(user, address, phone);
//    }


}
