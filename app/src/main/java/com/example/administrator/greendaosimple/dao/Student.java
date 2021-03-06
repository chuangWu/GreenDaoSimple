package com.example.administrator.greendaosimple.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "STUDENT".
 */
public class Student {

    private Long id;
    private String name;
    private Integer age;
    private java.util.Date date;

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(Long id, String name, Integer age, java.util.Date date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
