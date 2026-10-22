package pro.sky.courceworkrefactor.service;

public interface EmployeeService {
    public void addEmployee (String firstName, String lastName);
    public void removeEmployee(String firstName, String lastName);
    public int searchIndexEmployee (String firstName, String lastName);
    public boolean checkEmployee (String firstName, String lastName);
    public boolean checkSize ();
    public String getListEmployees ();
}
