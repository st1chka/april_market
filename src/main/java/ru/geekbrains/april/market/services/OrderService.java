package ru.geekbrains.april.market.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.geekbrains.april.market.dtos.OrderDto;
import ru.geekbrains.april.market.models.Order;
import ru.geekbrains.april.market.models.OrderItem;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.repositories.OrderRepository;
import ru.geekbrains.april.market.utils.Cart;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final Cart cart;


    public List<OrderDto> findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    public Order createOrderForCurrentUser(User user, String address, Long phone) {
        Order order = new Order();
        order.setUser(user);
        order.setPrice(cart.getSum());
        order.setItems(cart.getItems());
        for (OrderItem oi : cart.getItems()) {
            oi.setOrder(order);
        }
        order.setAddress(address);
        order.setPhone(phone);
        order = orderRepository.save(order);
        cart.clear();
        return order;
    }


}
