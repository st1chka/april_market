package ru.geekbrains.april.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import ru.geekbrains.april.market.services.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class  AprilMarketApplication {

    // Домашнее задание:
    // 1. Сделайте кнопку оформить заказ, по нажатию на которую в базу должен быть сохранени заказ
    // ( без подвязки к пользователю, ** с подвязкой к пользователю)
    // 2. * Фронт: если пользователь вошел в систему, то в верхней панели отпечатать его имя

    public static void main(String[] args) {
        SpringApplication.run(AprilMarketApplication.class, args);
    }



}
