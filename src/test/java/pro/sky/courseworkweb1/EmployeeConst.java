package pro.sky.courseworkweb1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeConst {

    public static final List<Employee> EMPLOYEES_LIST = new ArrayList<>(List.of(
            new Employee("Архипов", "Гордий", 1, 10000),
            new Employee("Соловьёв", "Федор", 2, 20000),
            new Employee("Копылов", "Аполлон", 3, 30000),
            new Employee("Королёв", "Ефим", 4, 40000),
            new Employee("Авдеев", "Руслан", 5, 50000)));
    public static final List<Employee> EMPLOYEES_LIST_DEP1 = new ArrayList<>(List.of(
            new Employee("Архипов", "Гордий", 1, 10000)));
    public static final List<Employee> EMPLOYEES_LIST_DEP2 = new ArrayList<>(List.of(
            new Employee("Соловьёв", "Федор", 2, 20000)));

    public static final List<Employee> EMPLOYEES_LIST_DEP3 = new ArrayList<>(List.of(
            new Employee("Копылов", "Аполлон", 3, 30000)));

    public static final List<Employee> EMPLOYEES_LIST_DEP4 = new ArrayList<>(List.of(
            new Employee("Королёв", "Ефим", 4, 40000)));
    public static final List<Employee> EMPLOYEES_LIST_DEP5 = new ArrayList<>(List.of(
            new Employee("Авдеев", "Руслан", 5, 50000)));

    public static final Map<Integer, List<Employee>> EMPLOYEE_MAP = Map.of(
            1, EMPLOYEES_LIST_DEP1,
            2, EMPLOYEES_LIST_DEP2,
            3, EMPLOYEES_LIST_DEP3,
            4, EMPLOYEES_LIST_DEP4,
            5, EMPLOYEES_LIST_DEP5);


    public static final String ALREADY_ADDED_LASTNAME = "Архипов";
    public static final String ALREADY_ADDED_FIRSTNAME = "Гордий";
    public static final String NO_EXISTING_LASTNAME = "Иванов";
    public static final String NO_EXISTING_FIRSTNAME = "Иван";
    public static final String LOWERCASE_LASTNAME = "lastname";
    public static final String LOWERCASE_FIRSTNAME = "firstname";

}

