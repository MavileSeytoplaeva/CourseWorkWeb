package pro.sky.courseworkweb1.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.courseworkweb1.Employee;
import pro.sky.courseworkweb1.service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentContoller {
    private DepartmentService departmentService;

    public DepartmentContoller(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("max-salary")
    public int maxSalary(@RequestParam ("departmentId") int departmentId){
        return departmentService.maxSalary(departmentId);
    }
    @GetMapping("min-salary")
    public int minSalary(@RequestParam ("departmentId") int departmentId){
        return departmentService.minSalary(departmentId);
    }

    @GetMapping( value = "all", params = "departmentId")
    public List<Employee> allByDep(int departmentId) {
        return departmentService.allByDep(departmentId);
    }
    @GetMapping( "all")
    public Map<Integer, List<Employee>> all(){
        return departmentService.all();
    }
}
