//package ru.geekbrains.april.market.utils;
////import org.aspectj.lang.annotation.Before;
//import org.junit.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.testng.annotations.BeforeSuite;
//import ru.geekbrains.april.market.error_handling.ResourceNotFoundException;
//import ru.geekbrains.april.market.models.OrderItem;
//import ru.geekbrains.april.market.models.Product;
//import ru.geekbrains.april.market.services.ProductService;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//
//@SpringBootTest(classes = Cart.class)
//public class TestCart {
//
//    @Autowired
//    Cart cart;
//
//    @MockBean
//    private  ProductService productService;
//
//    private List<OrderItem> items;
//    private BigDecimal sum;
//
//    @BeforeSuite
//    public void init(){
//        items = new ArrayList<>();
//    }
//
//    @Test
//    public void addToCart(Long id) {
//        for (OrderItem orderItem : items) {
//            if (orderItem.getProduct().getId().equals(id)) {
//                orderItem.incrementQuantity();
//                recalculate();
//                return;
//            }
//        }
//
//        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product doesn't exists id: " + id + " (add to cart)"));
//        items.add(new OrderItem(product));
//        recalculate();
//    }
//    @Test
//    public void deleteToCart(Long id) {
//        for (OrderItem orderItem : items) {
//            if (orderItem.getProduct().getId().equals(id)) {
//                orderItem.decrementQuantity();
//                recalculate();
//                return;
//            }
//        }
//    }
//    @Test
//    public void clear() {
//        items.clear();
//        recalculate();
//    }
//    @Test
//    private void recalculate() {
//        sum = BigDecimal.ZERO;
//        for (OrderItem oi : items) {
//            sum = sum.add(oi.getPrice());
//        }
//    }
//
//    @Test
//    public List<OrderItem> getItems() {
//        return Collections.unmodifiableList(items);
//    }
//}
