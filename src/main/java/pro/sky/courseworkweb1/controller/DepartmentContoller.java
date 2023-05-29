package pro.sky.courseworkweb1.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.courseworkweb1.Employee;
import pro.sky.courseworkweb1.service.DepartmentService;

import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentContoller {
    private DepartmentService departmentService;

    public DepartmentContoller(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("max-salary")
    public Optional<String> maxSalary(@RequestParam ("departmentId") int departmentId){
        return departmentService.maxSalary(departmentId);
    }
    @GetMapping("min-salary")
    public Optional<String> minSalary(@RequestParam ("departmentId") int departmentId){
        return departmentService.minSalary(departmentId);
    }

    @GetMapping( value = "all", params = "departmentId")
    public String allByDep(int departmentId) {
        return departmentService.allByDep(departmentId);
    }
    @GetMapping( "all")
    public String all(){
        return departmentService.all();
    }
}
