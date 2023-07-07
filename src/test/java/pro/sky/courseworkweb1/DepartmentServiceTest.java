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
    public EmployeeService employeeService;

    @InjectMocks
    private DepartmentService out;

//    ОШИБКА ДЛЯ ВСЕХ ТЕСТОВ
//    org.mockito.exceptions.misusing.InvalidUseOfMatchersException:
//    Invalid use of argument matchers!
//            0 matchers expected, 1 recorded:
//            -> at pro.sky.courseworkweb1.DepartmentServiceTest.shouldReturnMinSalaryByDepartment(DepartmentServiceTest.java:29)
//
//    This exception may occur if matchers are combined with raw values:
//    //incorrect:
//    someMethod(any(), "raw String");
//    When using matchers, all arguments have to be provided by matchers.
//    For example:
//    //correct:
//    someMethod(any(), eq("String by matcher"));
//
//    For more info see javadoc for Matchers class.
//

    @Test
    void shouldReturnMinSalaryByDepartment() {
        when(out.maxSalary(anyInt())).thenReturn(64000);
        int actual = out.maxSalary(anyInt());
        Assertions.assertEquals(64000,actual);
    }

    @Test
    void shouldReturnSalarySumByDepartment() {
        when(out.sumByDep(4)).thenReturn(57999);
        int actual = out.sumByDep(anyInt());

        Assertions.assertEquals( 57999, actual);
    }

    @Test
    void ShouldReturnExceptionWhenDepartmentNotFound() {
        when(out.allByDep(anyInt())).thenReturn(anyList());
    }

}
