package mate.academy.mailsender.controller;

import mate.academy.mailsender.model.SendMailRequest;
import mate.academy.mailsender.model.SendMailResponse;
import mate.academy.mailsender.service.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MainController {

    private final MailService mailService;

    public MainController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public SendMailResponse sendMessage(@RequestBody SendMailRequest sendMailRequest) {
        return mailService.sendMessage(sendMailRequest);
    }
}
