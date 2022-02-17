package com.reactive.framework.hrm.services;

import com.reactive.framework.hrm.module.Employees;
import reactor.core.publisher.Flux;

public interface EmployeeServiceImpl {
    
    public Flux<Employees> findAllEmployees();

}
