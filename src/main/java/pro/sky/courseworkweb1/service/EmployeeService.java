package pro.sky.courseworkweb1.service;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;
import pro.sky.courseworkweb1.Employee;
import pro.sky.courseworkweb1.exceptions.EmployeeAlreadyAddedException;
import pro.sky.courseworkweb1.exceptions.EmployeeNotFoundException;
import pro.sky.courseworkweb1.exceptions.EmployeeStorageIsFullException;
import pro.sky.courseworkweb1.exceptions.LowerCaseNameException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Архипов", "Гордий", 1, 64900),
            new Employee("Соловьёв", "Федор", 2, 80903),
            new Employee("Копылов", "Аполлон", 3, 81128),
            new Employee("Королёв", "Ефим", 4, 90535),
            new Employee("Авдеев","Руслан", 5, 90725),
            new Employee("Иванова", "Наталия", 1, 75586)));
    private static final int maxEmployeesInFirm = 6;

    public EmployeeService() {
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Employee employee) {
            this.employeeList.add(employee);
    }

    public boolean checkUpperCase(String firstName, String lastName) {
        return !(StringUtils.isAllLowerCase(firstName) || StringUtils.isAllLowerCase(lastName)
                || !(StringUtils.isAlpha(lastName)) || !(StringUtils.isAlpha(firstName)));

    }

public String addEmployee(String lastName, String firstName) {
        if (checkUpperCase(lastName, firstName)) {
            Employee employee = new Employee(lastName, firstName);
            for (Employee e : employeeList){
                if (e.getFirstName().equals(firstName) || e.getLastName().equals(lastName)){
                    throw new EmployeeAlreadyAddedException();
                }
            }
            if (employeeList.size() >= maxEmployeesInFirm) {
                throw new EmployeeStorageIsFullException();

//            if (employeeList.stream().anyMatch(Employee::getFirstName) == ) {
//                throw new EmployeeAlreadyAddedException();
            } else {
                setEmployeeList(employee);
                return employee.toString();
            }
        } else throw new LowerCaseNameException("404");
    }

    public String removeEmployee(String lastName, String firstName) {
        if (checkUpperCase(lastName, firstName)) {
            Employee employee = new Employee(lastName, firstName);
            if (employeeList.contains(employee)) {
                employeeList.remove(employee);
                return employee.toString();
            } else
                throw new EmployeeNotFoundException();
        }
        throw new LowerCaseNameException();
    }

    public String findEmployee(String lastName, String firstName) {
        if (checkUpperCase(lastName, firstName)) {
            Employee employee = new Employee(lastName, firstName);
            if (employeeList.contains(employee)) {
                return employee.toString();
            } else
                throw new EmployeeNotFoundException();
        }
        throw new LowerCaseNameException();
    }

    public List<Employee> all() {
        return employeeList.stream().toList();
    }

}
