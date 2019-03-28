package mate.academy.mailsender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {

    public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    public static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    public static final String MAIL_DEBUG = "mail.debug";
    public static final String email = "***@gmail.com";
    public static final String pass = "***";
    public static final String SMTP_GMAIL_COM = "smtp.gmail.com";

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
