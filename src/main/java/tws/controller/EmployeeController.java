package tws.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;


import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees =employeeMapper.selectAll();
        return ResponseEntity.ok(employees);
    }
}
