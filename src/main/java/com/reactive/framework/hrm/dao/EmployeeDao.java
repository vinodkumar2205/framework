package com.reactive.framework.hrm.dao;

import com.reactive.framework.hrm.module.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employees, Long > {
    
    
}
