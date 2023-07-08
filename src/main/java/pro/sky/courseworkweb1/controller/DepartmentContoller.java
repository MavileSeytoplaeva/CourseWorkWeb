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

    @GetMapping("{departmentId}/salary/sum")
    public int sumByDep(@PathVariable int departmentId) {
        return departmentService.sumByDep(departmentId);
    }
    @GetMapping("{departmentId}/salary/max")
    public int maxSalary(@PathVariable int departmentId) {
        return departmentService.maxSalary(departmentId);
    }
    @GetMapping("{departmentId}/salary/min")
    public int minSalary(@PathVariable int departmentId){
        return departmentService.minSalary(departmentId);
    }

    @GetMapping( value = "all", params = "{departmentId}/employees")
    public List<Employee> allByDep(@PathVariable int departmentId) {
        return departmentService.allByDep(departmentId);
    }
    @GetMapping( "employees")
    public Map<Integer, List<Employee>> all(){
        return departmentService.all();
    }
}
