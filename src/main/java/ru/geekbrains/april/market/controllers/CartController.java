package ru.geekbrains.april.market.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.april.market.dtos.CartDto;
import ru.geekbrains.april.market.utils.Cart;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final Cart cart;

    @GetMapping("/add/{productId}")
    public void addToCart(@PathVariable(name = "productId") Long id) {
        cart.addToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clear();
    }

    @GetMapping
    public CartDto getCart() {
        return new CartDto(cart);
    }
}
