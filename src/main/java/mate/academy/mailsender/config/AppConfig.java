package mate.academy.mailsender.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {

    @Value("${mail.transport.protocol}")
    private String MAIL_TRANSPORT_PROTOCOL;
    @Value("${mail.smtp.auth}")
    private String MAIL_SMTP_AUTH;
    @Value("${mail.smtp.starttls.enable}")
    private String MAIL_SMTP_STARTTLS_ENABLE;
    @Value("${mail.debug}")
    private String MAIL_DEBUG;
    @Value("${email}")
    private String email;
    @Value("${password}")
    private String pass;
    @Value("${host}")
    private String HOST;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl ms = new JavaMailSenderImpl();
        ms.setHost(HOST);
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
