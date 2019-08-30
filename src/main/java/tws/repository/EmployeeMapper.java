package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
   // @Select("select id,name,age from employee")
    // 查询
    List<Employee> selectAllByPage(@Param("offset") Integer offset,
                             @Param("pageSize") Integer pageSize);
    //通过id查询
    Employee selectOne(@Param("employeeID") String employeeID);
    //插入
    void insert(@Param("employee") Employee employee);
    //更新
    void updateOne(@Param("employeeID") String employeeID,
                   @Param("employee") Employee employee);
 //删除
    void deleteOne(@Param("employeeID") String employeeID);
  //查询所有
     List<Employee> selectAllByKeyWord(@Param("keyWord") String keyWord);
    //查询所有
    List<Employee> selectAll();
}
