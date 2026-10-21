package pro.sky.courceworkrefactor.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException () {
        super();
    }
    public EmployeeNotFoundException (String explanation) {
        super(explanation);
    }
}
