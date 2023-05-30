package pro.sky.courseworkweb1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseworkweb1.service.EmployeeService;

    @RestController
    @RequestMapping("/employee")
    public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String employeeHello() {
        return "Вы на первой странице";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("lastName") String lastName,
                              @RequestParam("firstName") String firstName) {
        return employeeService.addEmployee(lastName, firstName);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName) {
        return employeeService.removeEmployee(lastName, firstName);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("lastName") String lastName,
                               @RequestParam("firstName") String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping("/printAll")
    public String printAll() {
        return employeeService.printAll();
    }

}
