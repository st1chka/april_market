//package ru.geekbrains.april.market.repositories;
//
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.jaxb.SpringDataJaxb;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import ru.geekbrains.april.market.dtos.OrderItemDto;
//import ru.geekbrains.april.market.models.OrderItem;
//import ru.geekbrains.april.market.models.Product;
//
//@Repository
//public interface OrderRepository extends JpaRepository<OrderItemDto, Long> {
//    Page<OrderItemDto> findAllBy(OrderItemDto orderItemDto);
//}
