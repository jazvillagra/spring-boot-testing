package testing.services;

import testing.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();
}
