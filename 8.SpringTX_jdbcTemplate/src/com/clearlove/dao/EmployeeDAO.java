package com.clearlove.dao;

import com.clearlove.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author promise
 * @date 2021/3/23 - 23:22
 */
@Repository
public class EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO employee(emp_name,salary) VALUES(?,?)";
        jdbcTemplate.update(sql, employee.getEmpName(), employee.getSalary());
    }
}
