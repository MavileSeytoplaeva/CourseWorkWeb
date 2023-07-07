package pro.sky.courseworkweb1.impls;

import pro.sky.courseworkweb1.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceImpl {

    int sumByDep(int departmentId);

    int maxSalary(int departmentId);

    Employee minSalary(int departmentId);

    Map<Integer, List<Employee>> all();


    List<Employee> allByDep(int departmentId);
}
