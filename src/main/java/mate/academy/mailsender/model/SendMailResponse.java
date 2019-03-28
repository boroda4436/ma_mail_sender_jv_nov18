package mate.academy.mailsender.model;

import lombok.Data;

import java.util.List;

@Data
public class SendMailResponse {

    private Status status;
    private List<String> errors;

    public enum Status {

        OK(0),
        ERROR(400);

        int status;

        Status(int value) {
            this.status = value;
        }
    }
}
