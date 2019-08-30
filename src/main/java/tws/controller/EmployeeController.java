package tws.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import tws.service.EmployeeService;


import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeService  employeeService;

    @GetMapping("/{employeeID}")
    public ResponseEntity<EmployeeDto> selectOneEmployeeByID(@PathVariable String employeeID) {

        return ResponseEntity.ok(employeeService.getEmployWithDesc(employeeID));

    }
    //获得列表
    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees =employeeMapper.selectAll();
        return ResponseEntity.ok(employees);
    }
    //通过id查询
    @GetMapping("/{employeeID}")
    public ResponseEntity<Employee> selectOne(@PathVariable String employeeID){
        Employee employee=employeeMapper.selectOne(employeeID);
        return ResponseEntity.ok(employee);
    }
    //插入
    @PostMapping("")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee){
        String id= UUID.randomUUID().toString();  //获得唯一id
        employee.setId(id);
        employeeMapper.insert(employee);
        return ResponseEntity.created(URI.create("/employees/"+id)).build();
    }
    //更新
    @PutMapping("/{employeeID}")
    public ResponseEntity<Employee> updateOne(@PathVariable String employeeID,
                                              @RequestBody Employee employee){

        employeeMapper.updateOne(employeeID,employee);
        return ResponseEntity.ok(employee);
    }
    //删除
    @DeleteMapping("/{employeeID}")
    public ResponseEntity<Employee> deleteOne(@PathVariable String employeeID){
        employeeMapper.deleteOne(employeeID);
        return ResponseEntity.ok().build();
    }

}
