package pro.sky.courseworkweb1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.courseworkweb1.exceptions.DepartmentNotFoundException;
import pro.sky.courseworkweb1.service.DepartmentService;
import pro.sky.courseworkweb1.service.EmployeeService;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static pro.sky.courseworkweb1.EmployeeConst.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    public EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;


    @Test
    void shouldReturnMinSalaryByDepartment() {
        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEES_LIST);

        int actual = departmentService.minSalary(1);

        Assertions.assertEquals(10000, actual);
    }

    @Test
    void shouldReturnMaxSalaryByDepartment() {
        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEES_LIST);

        int actual = departmentService.maxSalary(1);

        Assertions.assertEquals(10000, actual);
    }

    @Test
    void shouldReturnAllByDep() {
        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEES_LIST);
        List<Employee> actual = departmentService.allByDep(1);
        List<Employee> expected = List.of(new Employee("Архипов", "Гордий", 1, 10000));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnAll() {
        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEES_LIST);
        Map<Integer, List<Employee>> actual = departmentService.all();

        Assertions.assertEquals(EMPLOYEE_MAP, actual);
    }

    @Test
    void ShouldReturnExceptionWhenDepartmentNotFound() {
        when(employeeService.getEmployeeList()).thenThrow(DepartmentNotFoundException.class);

        DepartmentNotFoundException thrown = Assertions.assertThrows(DepartmentNotFoundException.class, () -> departmentService.allByDep(6));
    }
}