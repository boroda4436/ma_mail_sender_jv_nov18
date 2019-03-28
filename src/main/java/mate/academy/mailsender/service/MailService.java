package mate.academy.mailsender.service;

import mate.academy.mailsender.model.SendMailRequest;
import mate.academy.mailsender.model.SendMailResponse;

public interface MailService {

    SendMailResponse sendMessage(SendMailRequest sendMailRequest);
}
