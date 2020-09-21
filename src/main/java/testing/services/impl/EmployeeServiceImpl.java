package testing.services.impl;

import testing.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testing.repositories.EmployeeRepository;
import testing.services.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee getEmployeeByName(String name) {
        return repository.findByName(name);
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }
}
