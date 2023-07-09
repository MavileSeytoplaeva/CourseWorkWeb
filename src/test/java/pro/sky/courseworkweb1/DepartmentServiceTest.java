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
import static pro.sky.courseworkweb1.EmployeeConstants.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    public EmployeeService employeeService;

    @InjectMocks
    private DepartmentService out;


//    @Test
//    void shouldReturnMinSalaryByDepartment() {
//        when(employeeService.getEmployeeList()).thenReturn();
//
//        int actual = out.minSalary(1);
//
//        Assertions.assertEquals(new Object(), actual);
//    }

//    @Test
//    void shouldReturnSalarySumByDepartment() {
//        when(departmentService.sumByDep(1)).thenReturn(57999);
//        int actual = departmentService.sumByDep(1);
//
//        Assertions.assertEquals( 57999, actual);
//    }

    @Test
    void ShouldReturnExceptionWhenDepartmentNotFound() {
        when(employeeService.getEmployeeList()).thenThrow(DepartmentNotFoundException.class);

        DepartmentNotFoundException thrown = Assertions.assertThrows(DepartmentNotFoundException.class, () -> out.allByDep(6));
    }
}
//    @Test
//    void ShouldReturnExceptionWhenDepartmentNotFound() {
//        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEE_LIST);
//        Map<Integer, List<Employee>> actual = out.all();
//
//        Assertions.assertEquals(EMPLOYEE_LIST, actual);
//
//    }
//    Ошибка
//    org.mockito.exceptions.misusing.UnnecessaryStubbingException:
//    Unnecessary stubbings detected.
//            Clean & maintainable test code requires zero unnecessary code.
//    Following stubbings are unnecessary (click to navigate to relevant line of code):
//            1. -> at pro.sky.courseworkweb1.DepartmentServiceTest.ShouldReturnExceptionWhenDepartmentNotFound(DepartmentServiceTest.java:59)
//    Please remove unnecessary stubbings or use 'lenient' strictness. More info: javadoc for UnnecessaryStubbingException class.

