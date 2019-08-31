package tws.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tws.entity.Employee;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    JdbcTemplate  jdbcTemplate;

    @Test
    public void insertTest() {
        //given
        jdbcTemplate.execute("insert into employee values('1','鲁',12)");
        //when
        List<Employee> employees = employeeMapper.selectAll();
        //then
        assertEquals(1,employees.size());
    }

}