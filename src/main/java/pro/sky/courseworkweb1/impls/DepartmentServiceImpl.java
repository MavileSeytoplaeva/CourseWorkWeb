package pro.sky.courseworkweb1.impls;

import pro.sky.courseworkweb1.Employee;

import java.util.Optional;

public interface DepartmentServiceImpl {

    Optional<String> maxSalary(int departmentId);

    Optional<String> minSalary(int departmentId);

    String all();


    String allByDep(int departmentId);
}
