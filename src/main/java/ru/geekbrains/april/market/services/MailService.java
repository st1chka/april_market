package ru.geekbrains.april.market.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.geekbrains.april.market.dtos.CartDto;
import ru.geekbrains.april.market.dtos.OrderDto;
import ru.geekbrains.april.market.dtos.OrderItemDto;
import ru.geekbrains.april.market.models.Order;
import ru.geekbrains.april.market.models.OrderItem;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.utils.Cart;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@Data
@Service
public class MailService {
//    private final OrderDto orderDto;
//    private final OrderItem orderItem;


    public void sendMail() throws IOException, MessagingException {
//        String text = order.toString();
        final Properties properties = new Properties();
        properties.load(MailService.class.getClassLoader().getResourceAsStream("app.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("kalinine03@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("pechenka99@mail.ru")); // почта получателя
        message.setSubject("Order");
        message.setText("заказ оформлен");


        Transport transport = mailSession.getTransport();
        transport.connect("kalinine03@gmail.com","Pikyli228!");                                         // почту и пароль отправителя
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
    }

}
