package pro.sky.courseworkweb1.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkweb1.Employee;
import pro.sky.courseworkweb1.exceptions.EmployeeAlreadyAddedException;
import pro.sky.courseworkweb1.exceptions.EmployeeNotFoundException;
import pro.sky.courseworkweb1.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class EmployeeService {
    private List<Employee> employeeList;
    private static final int maxEmployeesInFirm = 10;

    public EmployeeService(List<Employee> employeeList) {
        this.employeeList = new ArrayList<>(List.of(
                new Employee("Архипов", "Гордий"),
                new Employee("Соловьёв", "Федор"),
                new Employee("Соловьёв", "Георгий"),
                new Employee("Копылов", "Аполлон"),
                new Employee("Королёв", "Ефим"),
                new Employee("Авдеев", "Руслан")));
    }

    public String addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeeList.size() > maxEmployeesInFirm) {
            throw new EmployeeStorageIsFullException();
        }
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employeeList.add(employee);
            return employee.toString();
        }
    }

    public String removeEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee.toString();
        } else
            throw new EmployeeNotFoundException();
    }

    public String findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeeList.contains(employee)) {
            return employee.toString();
        } else
            throw new EmployeeNotFoundException();
    }

    public String printAll() {
        return String.valueOf(new ArrayList<>(employeeList));
    }

}
