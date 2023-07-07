package pro.sky.courseworkweb1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.courseworkweb1.exceptions.EmployeeAlreadyAddedException;
import pro.sky.courseworkweb1.exceptions.EmployeeNotFoundException;
import pro.sky.courseworkweb1.exceptions.EmployeeStorageIsFullException;
import pro.sky.courseworkweb1.exceptions.LowerCaseNameException;
import pro.sky.courseworkweb1.service.EmployeeService;

import static pro.sky.courseworkweb1.EmployeeConstants.*;


public class EmployeeServiceTest {

    public EmployeeService employeeService = new EmployeeService();

    @Test
    void ShouldThrowExceptionWhenAddingAlreadyExistingEmployee() {
        EmployeeAlreadyAddedException thrown = Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee(ALREADY_ADDED_LASTNAME, ALREADY_ADDED_FIRSTNAME));
    }

    @Test
    void ShouldReturnExceptionWhenLowerCase() {
        LowerCaseNameException thrown = Assertions.assertThrows(LowerCaseNameException.class,
                () -> employeeService.addEmployee(LOWERCASE_LASTNAME, LOWERCASE_FIRSTNAME));
    }

    @Test
    void ShouldReturnWhenStorageIsFull() {
        EmployeeStorageIsFullException thrown = Assertions.assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.addEmployee(NO_EXISTING_LASTNAME, NO_EXISTING_FIRSTNAME));
    }

    @Test
    void ShouldReturnExceptionWhenRemovingNotExistingEmployeeMethodRemove() {
        EmployeeNotFoundException thrown = Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee(NO_EXISTING_LASTNAME, NO_EXISTING_FIRSTNAME));
    }

    @Test
    void ShouldReturnExceptionWhenRemovingNotExistingEmployeeMethodFind() {
        EmployeeNotFoundException thrown = Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee(NO_EXISTING_LASTNAME, NO_EXISTING_FIRSTNAME));
    }

    @Test
    void ShouldReturnList() {
        boolean isNull = employeeService.all().isEmpty();
        Assertions.assertFalse(isNull);
    }
}
