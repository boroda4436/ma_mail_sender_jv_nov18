package mate.academy.mailsender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {

    private static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    private static final String MAIL_DEBUG = "mail.debug";
    private static final String email = "bchupikatestmail@gmail.com";
    private static final String pass = "***";
    private static final String SMTP_GMAIL_COM = "smtp.gmail.com";

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl ms = new JavaMailSenderImpl();
        ms.setHost(SMTP_GMAIL_COM);
        ms.setPort(587);

        ms.setUsername(email);
        ms.setPassword(pass);
        Properties props = ms.getJavaMailProperties();
        props.put(MAIL_TRANSPORT_PROTOCOL, "smtp");
        props.put(MAIL_SMTP_AUTH, "true");
        props.put(MAIL_SMTP_STARTTLS_ENABLE, "true");
        props.put(MAIL_DEBUG, "true");
        return ms;
    }
}
