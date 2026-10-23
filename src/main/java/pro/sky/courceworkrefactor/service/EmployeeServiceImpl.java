package pro.sky.courceworkrefactor.service;

import org.springframework.stereotype.Service;
import pro.sky.courceworkrefactor.exception.EmployeeAlreadyAddedException;
import pro.sky.courceworkrefactor.exception.EmployeeStorageIsFullException;
import pro.sky.courceworkrefactor.model.Employee;
import pro.sky.courceworkrefactor.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int maxListSize = 20;
    private final List<Employee> employeeList;
    public EmployeeServiceImpl () {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add (String firstName, String lastName) {
        if (!checkListSize()) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove (String firstName, String lastName) {
        Employee employee = new Employee (firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find (String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public boolean checkListSize () {
        return employeeList.size() <= maxListSize;
    }

    public Collection<Employee> getListEmployees () {
        return new ArrayList<>(employeeList);
    }
}