package ru.geekbrains.april.market.utils;

//import io.jsonwebtoken.lang.Assert;
//import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;
import ru.geekbrains.april.market.models.OrderItem;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.repositories.UserRepository;
import ru.geekbrains.april.market.services.UserService;

import java.util.Optional;


@SpringBootTest
public class TestCart {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void findOneUserTest(){
        User userFromBD = new User();
        userFromBD.setUsername("Nick");
        userFromBD.setEmail("nick@mail.ru");

        Mockito.doReturn(Optional.of(userFromBD))
                .when(userRepository)
                .findByUsername("Nick");

        User userNick = userService.findByUsername("Nick").get();
        Assertions.assertNotNull(userNick);
        Assertions.assertEquals("nick@mail.ru", userNick.getEmail());
        Mockito.verify(userRepository,Mockito.times(1)).findByUsername("Nick");
    }
}
