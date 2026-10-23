package pro.sky.courceworkrefactor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Этот сотрудник был добавлен ранее")
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }

    public EmployeeAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyAddedException(Throwable cause) {
        super(cause);
    }
}
