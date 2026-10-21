package pro.sky.courceworkrefactor.exception;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException () {
        super();
    }
    public EmployeeStorageIsFullException (String explanation) {
        super(explanation);
    }
}
