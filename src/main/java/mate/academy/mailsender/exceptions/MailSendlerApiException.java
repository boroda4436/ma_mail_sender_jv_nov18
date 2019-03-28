package mate.academy.mailsender.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public class MailSendlerApiException extends Exception {

    private HttpStatus status;
    private String message;
    private List<String> validationErrors;
    private String debugMsg;

    public MailSendlerApiException(HttpStatus status) {
        this.status = status;
    }
}
