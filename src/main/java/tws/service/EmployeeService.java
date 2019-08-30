package tws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto getEmployWithDesc(String id){

        Employee employee =employeeMapper.selectOne(id);
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setAge(employee.getAge());

        String desc=String.format("name:%s,age:%s",
                employee.getName(),employee.getAge()
                );

        employeeDto.setDescription(desc);
        return employeeDto;
    }
    public List<Employee> getEmployeesByPage(Integer page,Integer pageSize){
         if(page==null && pageSize==null){
             return employeeMapper.selectAll();
         }
         else{
             int offset=(page-1)*pageSize;
             return employeeMapper.selectAllByPage(offset,pageSize);
         }
    }
    public List<Employee> getEmployeesByKeyWord(String keyWord){
        if(keyWord==null){
            return employeeMapper.selectAll();
        }else{
            return employeeMapper.selectAll(keyWord);
        }
    }
    public List<Employee> getEmployees(){
        return employeeMapper.selectAll();
     }

}
