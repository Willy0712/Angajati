package AngajatiApp.model;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class EmployeeTest {


    private Employee emp;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        emp = new Employee();
        emp.setFirstName("Alex");
        emp.setLastName("Macavei");
        emp.setCnp("123456789");
        emp.setSalary(2.4);
        System.out.println("SetUp");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("TearDown");
    }


    @org.junit.jupiter.api.Test
    @Order(3)
    void testGetFirstName() {
        assertEquals("Alex", emp.getFirstName(), "Wrong First Name");
        System.out.println("Get First Name oki");
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void testSetFirstName() {
        emp.setFirstName("Mihaela");
        assertEquals("Mihaela", emp.getFirstName(), "The First Name isn't Mihaela");
        System.out.println("Set first name oki");
    }

    @Test
    @Order(4)
    void testGetCnp() {
        assertEquals("123456789", emp.getCnp(), "Wrong CNP");
        System.out.println("Get CNP oki");
    }

    @Test
    @Order(1)
    void testSetCNP() {
        emp.setCnp("56789");
        assertEquals("56789", emp.getCnp(), "Wrong CNP");
        System.out.println("Set CNP oki");
    }

    @Test
    @Order(7)
    void testGetSalary() {
        assertEquals(2.4, emp.getSalary(), "Salary doesn't match");
        System.out.println("Get salary oki");
    }

    @Test
    @Order(6)
    void testConstructor() {
        Employee employee = new Employee();
        assertEquals("", employee.getCnp(), "CNP should be empty");
        System.out.println("Constructor OK");
    }

    @Test
    @Order(5)
    void timeoutNotExceeded()
    {
        assertTimeout(ofMinutes(2), () -> {

        });
        System.out.println("Time out oki");
    }

//    @ParameterizedTest
//    @ValueSource(strings={"Alex", "Mihai", "Petru"})
//    @Disabled
//    void testParametrizatSetTFirstName(String firstName) {
//        emp.setFirstName(firstName);
//        assertEquals(firstName,emp.getFirstName(),"First name  "+firstName + "is not correct");
//        System.out.println("set firstname "+firstName+" is oki");
//    }

    @Test
    void test_setSalary_inValid()
    {
        try{emp.setSalary(-2.4);
            assert(false);
        }
        catch(Exception e)
        {
            assert(true);
            assertEquals("Salariul nu poate fi minus", e.getMessage().toString());
            //System.out.println(e.getMessage().toString());
        }
        System.out.println("set salariu ok");
    }
}