package ru.geekbrains.april.market.controllers;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.april.market.dtos.OrderDto;
import ru.geekbrains.april.market.models.Order;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.services.MailService;
import ru.geekbrains.april.market.services.OrderService;
import ru.geekbrains.april.market.services.UserService;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Data@RequestMapping("/api/v1/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final MailService mailService;



    @PostMapping
    public void createNewOrder(Principal principal) throws MessagingException, IOException {
        User user = userService.findByUsername(principal.getName()).get();
        orderService.createOrderForCurrentUser(user);
        mailService.sendMail();
    }

    @GetMapping
    @Transactional
    public List<OrderDto> getAllOrdersForCurrentUser(Principal principal){
        User user = userService.findByUsername(principal.getName()).get();
        return orderService.findAllByUser(user).stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
