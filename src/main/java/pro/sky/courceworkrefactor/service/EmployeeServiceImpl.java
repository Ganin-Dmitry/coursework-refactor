package pro.sky.courceworkrefactor.service;

import org.springframework.stereotype.Service;
import pro.sky.courceworkrefactor.employee.Employee;
import pro.sky.courceworkrefactor.employee.EmployeeBook;
import pro.sky.courceworkrefactor.exception.EmployeeAlreadyAddedException;
import pro.sky.courceworkrefactor.exception.EmployeeNotFoundException;
import pro.sky.courceworkrefactor.exception.EmployeeStorageIsFullException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeBook employeesBook;
    public EmployeeServiceImpl (EmployeeBook employeesBook) {
        this.employeesBook = employeesBook;
    }

    public void addEmployee (String firstName, String lastName) {
        if (firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("Допущена ошибка при вводе полей.");
        }
        if (!checkSize()) {
            throw new EmployeeStorageIsFullException("Достигнут лимит в списке");
        }
        if (checkEmployee(firstName, lastName)) {
            throw new EmployeeAlreadyAddedException("Объект уже добавлен в список");
        }
        employeesBook.getEmployees().add(new Employee(firstName, lastName));
    }

    public void removeEmployee(String firstName, String lastName) {
        if (firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("Допущена ошибка при вводе полей.");
        }
        try {
            int index = searchIndexEmployee(firstName, lastName);
            employeesBook.getEmployees().remove(index);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException("Объект в списке не найден");
        }
    }

    public int searchIndexEmployee (String firstName, String lastName) {
        if (firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("Допущена ошибка при вводе полей.");
        }
        int index = -1;
        for (int employee = 0; employee < employeesBook.getEmployees().size(); employee++) {
            if (employeesBook.getEmployees().get(employee).getFirstName().equals(firstName) && employeesBook.getEmployees().get(employee).getLastName().equals(lastName)) {
                index = employee;
                break;
            }
        }
        if (index == -1) {
            throw new EmployeeNotFoundException("Объект в списке не найден");
        }
        return index;
    }

    public boolean checkEmployee (String firstName, String lastName) {
        try {
            return searchIndexEmployee(firstName, lastName) != -1;
        } catch (EmployeeNotFoundException e) {
            return false;
        }
    }

    public boolean checkSize () {
        return employeesBook.getEmployees().size() < employeesBook.getMaxQuantityEmployees();
    }

    public String getListEmployees () {
        if (employeesBook.getEmployees().size() == 0) {
            throw new EmployeeNotFoundException("В списке не найдено учтенных сотрудников.");
        }
        String listEmployees = "";
        for (int indexEmployee = 0; indexEmployee < employeesBook.getEmployees().size(); indexEmployee++) {
            listEmployees = listEmployees + employeesBook.getEmployees().get(indexEmployee).toString() + "<br>";
        }
        return listEmployees;
    }
}
