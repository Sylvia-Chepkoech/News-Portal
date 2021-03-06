package models;

import java.util.Objects;

public class Employees {
    private int id;
    private String name;
    private String position;
    private String email;
    private int departmentId;

    public Employees(String name, String position, String email, int departmentId) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employees)) return false;
        Employees employees = (Employees) o;
        return getDepartmentId() == employees.getDepartmentId() && getName().equals(employees.getName()) && getPosition().equals(employees.getPosition()) && getEmail().equals(employees.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition(), getEmail(), getDepartmentId());
    }
}
