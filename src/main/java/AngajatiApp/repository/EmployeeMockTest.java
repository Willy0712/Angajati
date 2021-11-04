package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.controller.EmployeeController;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {

    private Employee emp;
    EmployeeController employeeController;
    DidacticFunction didacticFunction;
    int nrEmployee;

    @BeforeEach
    void setUp() {

            emp = new Employee();
            emp.setFirstName("Petru");
            emp.setLastName("Mihai");
            emp.setFunction(didacticFunction.LECTURER);
            emp.setCnp("1234567891234");
            emp.setSalary(1200.0);
            System.out.println("SetUp");
        EmployeeImpl employeeImpl = new EmployeeImpl();
        employeeController = new EmployeeController(employeeImpl);
        nrEmployee = employeeController.getEmployeesList().size();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addEmployeeTC1() throws IOException {
        try{
            employeeController.addEmployee(emp);
            assert(true);
            assertEquals(nrEmployee + 1, employeeController.getEmployeesList().size());
        } catch (Exception e ) {
            assert(false);
        }


    }

    @Test
    void addEmployeeTC2() throws IOException {
        try{
            emp.setCnp("123456");
            employeeController.addEmployee(emp);
            assert(true);
            assertEquals(nrEmployee, employeeController.getEmployeesList().size());
        } catch (Exception e ) {
            assert(false);
        }


    }
}