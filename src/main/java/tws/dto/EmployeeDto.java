package tws.dto;

import tws.entity.Employee;

public class EmployeeDto {
    private String id;
    private String name;
    private int age;
    private  String description;

    public EmployeeDto(String id, String name, int age, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public EmployeeDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
