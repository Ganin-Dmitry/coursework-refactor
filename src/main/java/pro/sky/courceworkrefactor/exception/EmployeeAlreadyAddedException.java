package pro.sky.courceworkrefactor.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException () {
        super();
    }
    public EmployeeAlreadyAddedException (String explanation) {
        super(explanation);
    }
}
