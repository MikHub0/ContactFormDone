package pl.coderslab.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(
            String from, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("anastazjachteinman@gmail.com"); // adres e-mail osoby wysyłającej
        message.setTo("testowankomjupku@gmail.com"); // Twój adres e-mail, na który mają być wysyłane wiadomości
        message.setText(text); // Treść wiadomości
        emailSender.send(message);

    }
}
