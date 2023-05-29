package pro.sky.courseworkweb1.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkweb1.Employee;
import pro.sky.courseworkweb1.exceptions.EmployeeAlreadyAddedException;
import pro.sky.courseworkweb1.exceptions.EmployeeNotFoundException;
import pro.sky.courseworkweb1.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeList;
    private static final int maxEmployeesInFirm = 10;

    public EmployeeService() {
    }

    public EmployeeService(List<Employee> employeeList) {
        this.employeeList = new ArrayList<>(List.of(
                new Employee("Архипов", "Гордий", 1, 64900),
                new Employee("Соловьёв", "Федор", 2, 80903),
                new Employee("Копылов", "Аполлон", 3, 81128),
                new Employee("Королёв", "Ефим", 4, 90535),
                new Employee("Авдеев","Руслан", 5, 90725),
                new Employee("Иванова", "Наталия", 1, 75586),
                new Employee("Кондратьева", "Неонила", 2, 65770),
                new Employee("Доронина", "Ульяна", 3, 85385),
                new Employee("Горбунова","Женевьева", 4, 82519),
                new Employee("Казакова", "Грета", 5, 91960)));
    }

    public List<Employee> getEmployeeList() {
        List<Employee> employeeList1 = new ArrayList<>(List.of(
                new Employee("Архипов", "Гордий", 1, 64900),
                new Employee("Соловьёв", "Федор", 2, 80903),
                new Employee("Копылов", "Аполлон", 3, 81128),
                new Employee("Королёв", "Ефим", 4, 90535),
                new Employee("Авдеев","Руслан", 5, 90725),
                new Employee("Иванова", "Наталия", 1, 75586),
                new Employee("Кондратьева", "Неонила", 2, 65770),
                new Employee("Доронина", "Ульяна", 3, 85385),
                new Employee("Горбунова","Женевьева", 4, 82519),
                new Employee("Казакова", "Грета", 5, 91960)));
        return employeeList1.stream().toList();
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
