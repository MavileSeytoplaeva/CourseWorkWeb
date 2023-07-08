package pro.sky.courseworkweb1.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkweb1.Employee;
import pro.sky.courseworkweb1.exceptions.DepartmentNotFoundException;
import pro.sky.courseworkweb1.impls.DepartmentServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceImpl {
    private EmployeeService employeeService;


    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public int sumByDep(int departmentId) {
        int sum = 0;
        for (Employee e : employeeService.getEmployeeList()) {
            if (e.getDepartmentId() == departmentId) {
                sum += e.getSalary();
            }
        }
        return sum;
    }



    public int maxSalary(int departmentId) {
        Employee maxSalaryEmployee = employeeService.getEmployeeList()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("No employee"));
        return maxSalaryEmployee.getSalary();
    }

    @Override
    public int minSalary(int departmentId) {
        Employee minSalaryEmployee = employeeService.getEmployeeList()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("No employee"));
        return minSalaryEmployee.getSalary();
    }

    @Override
    public Map<Integer, List<Employee>> all() {
        Map<Integer, List<Employee>> collectedEmployees = employeeService.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
        return collectedEmployees;
    }

    @Override
    public List<Employee> allByDep(int departmentId) {
        for (Employee employee : employeeService.getEmployeeList()) {
            if (employee.getDepartmentId() == departmentId) {
                List<Employee> employeesByDepartment = employeeService.getEmployeeList()
                        .stream()
                        .filter(e ->e.getDepartmentId() == departmentId)
                        .toList();
                return employeesByDepartment;
            }
        }
        throw new DepartmentNotFoundException();
    }
}
