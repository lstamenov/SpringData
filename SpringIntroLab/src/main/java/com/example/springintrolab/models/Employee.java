package com.example.springintrolab.models;


import javax.persistence.*;

@Entity(name = "users")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "salary")
    private Double salary;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "department_id", referencedColumnName = "id")
    private Department department;

    public Employee(String firstName, String lastName, Integer age, Double salary, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {
    }

    public void setAge(int age) {
        this.age = age;
    }
}