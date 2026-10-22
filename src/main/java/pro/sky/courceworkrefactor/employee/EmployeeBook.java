package pro.sky.courceworkrefactor.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeBook {
    private final List<Employee> employees = new ArrayList<>();
    private final int maxQuantityEmployees = 20;

    public List<Employee> getEmployees () {
        return this.employees;
    }

    public int getMaxQuantityEmployees () {
        return this.maxQuantityEmployees;
    }
}
