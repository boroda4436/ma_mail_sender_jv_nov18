package mate.academy.mailsender.model;

import lombok.Data;

@Data
public class SendMailRequest {

    private String title;
    private String sendTo;
    private String message;
}
