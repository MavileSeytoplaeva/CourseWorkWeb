package pro.sky.courseworkweb1.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkweb1.Employee;
import pro.sky.courseworkweb1.impls.DepartmentServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements DepartmentServiceImpl {
    EmployeeService employeeService = new EmployeeService();


    @Override
    public Optional<String> maxSalary(int departmentId) {
        return employeeService.getEmployeeList()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .map(Employee::toString)
                .max(Comparator.naturalOrder());
    }

    @Override
    public Optional<String> minSalary(int departmentId) {
        return employeeService.getEmployeeList()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .map(Employee::toString)
                .max(Comparator.naturalOrder());
    }

    @Override
    public String all() {
        List<String> emplDep1 = employeeService.getEmployeeList().stream().filter(e -> e.getDepartmentId() == 1).map(Employee::toString).toList();
        List<String> emplDep2 = employeeService.getEmployeeList().stream().filter(e -> e.getDepartmentId() == 2).map(Employee::toString).toList();
        List<String> emplDep3 = employeeService.getEmployeeList().stream().filter(e -> e.getDepartmentId() == 3).map(Employee::toString).toList();
        List<String> emplDep4 = employeeService.getEmployeeList().stream().filter(e -> e.getDepartmentId() == 4).map(Employee::toString).toList();
        List<String> emplDep5 = employeeService.getEmployeeList().stream().filter(e -> e.getDepartmentId() == 5).map(Employee::toString).toList();
        return emplDep1.toString() + emplDep2.toString() + emplDep3.toString() + emplDep4.toString() + emplDep5.toString();
    }

    @Override
    public String allByDep(int departmentId) {
        List<String> employeesByDepartment = employeeService.getEmployeeList()
                .stream()
                .filter(e ->e.getDepartmentId() == departmentId)
                .map(Employee::toString)
                .toList();
        return employeesByDepartment.toString();
    }
}
