package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {

    public Employees newEmployees (){
        return new Employees("James", "News Editor", "test@example12", 3);

    }

    @Test
    public void getName_returnNameCorrectly_String() {
        Employees employees = newEmployees();
        assertEquals("James", employees.getName());
    }

    @Test
    public void getPosition_returnPositionCorrectly_String() {
        Employees employees = newEmployees();
        assertEquals("News Editor", employees.getPosition());
    }

    @Test
    public void getEmail_returnEmailCorrectly_String() {
        Employees employees = newEmployees();
        assertEquals("test@example12", employees.getEmail());
    }

    @Test
    public void getDepartmentId_returnDepartmentIdCorrectly_int() {
        Employees employees = newEmployees();
        assertEquals(3, employees.getDepartmentId());
    }
}