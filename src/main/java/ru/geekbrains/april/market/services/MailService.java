package ru.geekbrains.april.market.services;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailService {



    public void sendMail() throws IOException, MessagingException {
        final Properties properties = new Properties();
        properties.load(MailService.class.getClassLoader().getResourceAsStream("app.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("kalinine03@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("pechenka99@mail.ru")); // почта получателя
        message.setSubject("Order");
        message.setText("мать на аве, аниме в канаве");


        Transport transport = mailSession.getTransport();
        transport.connect();                                         // почту и пароль отправителя
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
    }

}
