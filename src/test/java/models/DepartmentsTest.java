package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentsTest {
    public  Departments newDepartments() {
        return new Departments("IT", "Everything Tech", 10);
    }

    @Test
    public void getDepartmentName_returnsNAmeCorrectly_String() {
        Departments departments = newDepartments();
        assertEquals("IT", departments.getDepartmentName());
    }

    @Test
    public void getDescription_returnsDescriptionCorrectly_String() {
        Departments departments = newDepartments();
        assertEquals("Everything Tech", departments.getDescription());
    }

    @Test
    public void getNumberOfEmployees_returnsCorrectCountOfEmployees_int() {
        Departments departments = newDepartments();
        assertEquals(10, departments.getNumberOfEmployees());
    }
}