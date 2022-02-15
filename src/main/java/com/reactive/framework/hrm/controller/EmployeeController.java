package com.reactive.framework.hrm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reactive.framework.hrm.dao.EmployeeDao;
import com.reactive.framework.hrm.module.Employees;
import com.reactive.framework.hrm.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeServices employeeServices;

    @PostMapping(path="/add")
    public @ResponseBody String createUser(){
        return "";
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody List<Employees> getEmployees(){
        return employeeDao.findAll();
    }

    @RequestMapping(value="/asyncEmployees", method = RequestMethod.GET)
    public @ResponseBody List<Employees> getAsyncEmployeeDetails() throws ExecutionException, InterruptedException, JsonProcessingException {
        return employeeServices.getAsyncEmployees();
    }

}
