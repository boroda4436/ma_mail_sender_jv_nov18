package mate.academy.mailsender.service;

import mate.academy.mailsender.model.SendMailRequest;
import mate.academy.mailsender.model.SendMailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public SendMailResponse sendMessage(SendMailRequest sendMailRequest) {
        SendMailResponse response = new SendMailResponse();

        try {
            javaMailSender.send(getMailMessage(sendMailRequest));
            response.setStatus(SendMailResponse.Status.OK);
        } catch (Exception e) {
            response.setStatus(SendMailResponse.Status.ERROR);
            response.setErrors(Collections.singletonList(e.getMessage()));
        }

        return response;
    }

    private SimpleMailMessage getMailMessage(SendMailRequest request) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(request.getSendTo());
        msg.setSubject(request.getTitle());
        msg.setText(request.getMessage());

        return msg;
    }
}
