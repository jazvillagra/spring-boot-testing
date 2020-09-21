package testing.services;

import testing.entities.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import testing.repositories.EmployeeRepository;
import testing.services.impl.EmployeeServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {
    @TestConfiguration
    static class EmployeeServiceImplTestConfiguration {
        @Bean
        public EmployeeService employeeService(){
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        Employee carl = new Employee("Carl");

        Mockito.when(employeeRepository.findByName(carl.getName())).thenReturn(carl);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "Carl";
        Employee found = employeeService.getEmployeeByName(name);

        assertThat(found.getName())
                .isEqualTo(name);
    }
}
