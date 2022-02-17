package com.reactive.framework.hrm.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reactive.framework.hrm.dao.EmployeeDao;
import com.reactive.framework.hrm.module.Employees;
import com.reactive.framework.hrm.module.EmployeesRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class EmployeeServices implements EmployeeServiceImpl {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    RestTemplate restTemplate;

    /*public CompletableFuture<List<Employees>> getRestCallEmployees() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = null;
        List<Employees> employeesList =null;
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/employee/list", HttpMethod.GET, entity, String.class);
        if(response!=null && response.getBody()!=null){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            EmployeesRes employeesRes = objectMapper.readValue(response.getBody(),EmployeesRes.class);
            String sjonSteing = objectMapper.writeValueAsString(employeesRes);
            employeesList = (List<Employees>) employeesRes;
        }
       return CompletableFuture.completedFuture(employeesList);

    }

    public List<Employees> getAsyncEmployees() throws ExecutionException, InterruptedException, JsonProcessingException {
        CompletableFuture<List<Employees>> cf = getRestCallEmployees();
        List<Employees> employeesList = new ArrayList<>();
        employeesList = cf.get();
        return employeesList;
    }*/

    @Override
    public Flux<Employees> findAllEmployees() {
        return employeeDao.findAll().switchIfEmpty(Flux.empty());
    }
}
