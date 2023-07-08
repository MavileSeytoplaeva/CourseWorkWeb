package pro.sky.courseworkweb1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.courseworkweb1.service.DepartmentService;
import pro.sky.courseworkweb1.service.EmployeeService;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    public DepartmentService departmentService;

    @InjectMocks
    private EmployeeService out;


    @Test
    void shouldReturnMinSalaryByDepartment() {
        when(departmentService.minSalary(2)).thenReturn(89000);
        int actual = departmentService.minSalary(2);
        Assertions.assertEquals(89000,actual);
    }

    @Test
    void shouldReturnSalarySumByDepartment() {
        when(departmentService.sumByDep(1)).thenReturn(57999);
        int actual = departmentService.sumByDep(1);

        Assertions.assertEquals( 57999, actual);
    }

    @Test
    void ShouldReturnExceptionWhenDepartmentNotFound() {
        when(departmentService.allByDep(anyInt())).thenReturn(anyList());
    }
//    Ошибка
//    org.mockito.exceptions.misusing.UnnecessaryStubbingException:
//    Unnecessary stubbings detected.
//            Clean & maintainable test code requires zero unnecessary code.
//    Following stubbings are unnecessary (click to navigate to relevant line of code):
//            1. -> at pro.sky.courseworkweb1.DepartmentServiceTest.ShouldReturnExceptionWhenDepartmentNotFound(DepartmentServiceTest.java:59)
//    Please remove unnecessary stubbings or use 'lenient' strictness. More info: javadoc for UnnecessaryStubbingException class.

}
