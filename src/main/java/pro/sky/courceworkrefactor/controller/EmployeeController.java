package pro.sky.courceworkrefactor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courceworkrefactor.exception.EmployeeAlreadyAddedException;
import pro.sky.courceworkrefactor.exception.EmployeeNotFoundException;
import pro.sky.courceworkrefactor.exception.EmployeeStorageIsFullException;
import pro.sky.courceworkrefactor.service.EmployeeService;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee (@RequestParam (name = "firstName", required = false) String firstName,
                               @RequestParam (name = "lastName", required = false) String lastName) {
        try {
            employeeService.addEmployee(firstName, lastName);
            return "Cотрудник " + firstName + " " + lastName + " успешно добавлен!";
        } catch (EmployeeStorageIsFullException e) {
            return "Достигнут лимит сотрудников!";
        } catch (EmployeeAlreadyAddedException e) {
            return "Сотрудник уже добавлен ранее.";
        } catch (NullPointerException e) {
            return "Допущена ошибка при вводе полей.";
        } catch (Exception e) {
            return "Попробуйте позже.";
        }
    }

    @GetMapping(path = "/remove")
    public String removeEmployee (@RequestParam (name = "firstName", required = false) String firstName,
                                  @RequestParam (name = "lastName", required = false) String lastName) {
        try {
            employeeService.removeEmployee(firstName, lastName);
            return "Cотрудник " + firstName + " " + lastName + " успешно удален!";
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден.";
        } catch (NullPointerException e) {
            return "Допущена ошибка при вводе полей.";
        } catch (Exception e) {
            return "Попробуйте позже.";
        }
    }

    @GetMapping(path = "/search")
    public String searchView (@RequestParam (name = "firstName", required = false) String firstName,
                              @RequestParam (name = "lastName", required = false) String lastName) {
        try {
            System.out.println(employeeService.searchIndexEmployee(firstName, lastName));
            return "Cотрудник " + firstName + " " + lastName + " найден!";
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден.";
        } catch (NullPointerException e) {
            return "Допущена ошибка при вводе полей.";
        } catch (Exception e) {
            return "Попробуйте позже.";
        }
    }

    @GetMapping(path = "/printList")
    public String printListEmployees () {
        try {
            return "Список всех учтенных сотрудников:<br>" + employeeService.getListEmployees();
        } catch (EmployeeNotFoundException e) {
            return "Не найдено учтенных сотрудников в списке.";
        } catch (Exception e) {
            return "Попробуйте позже.";
        }
    }
}