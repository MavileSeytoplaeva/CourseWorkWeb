package pro.sky.courseworkweb1.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkweb1.Employee;
import pro.sky.courseworkweb1.impls.DepartmentServiceImpl;

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
    public int maxSalary(int departmentId) {
        List<Employee> employees = employeeService.getEmployeeList()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .toList();
        Employee emplMaxSal = employees.get(0);
        for (Employee employee : employees) {
            if (emplMaxSal.getSalary() < employee.getSalary()) {
                emplMaxSal = employee;
            }
        }
        return emplMaxSal.getSalary();
    }

    @Override
    public int minSalary(int departmentId) {
        List<Employee> employees = employeeService.getEmployeeList()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .toList();
        Employee emplMinSal = employees.get(0);
        for (Employee employee : employees) {
            if (emplMinSal.getSalary() > employee.getSalary()) {
                emplMinSal = employee;
            }
        }
        return emplMinSal.getSalary();
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
        List<Employee> employeesByDepartment = employeeService.getEmployeeList()
                .stream()
                .filter(e ->e.getDepartmentId() == departmentId)
                .toList();
        return employeesByDepartment;
    }
}
