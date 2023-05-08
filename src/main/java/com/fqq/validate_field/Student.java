package com.fqq.validate_field;

public class Student {
    @Important
    private String name;
    @Important
    private String addr;
    @Important
    private Integer age;

    public Student() {
    }

    public Student(String name, String addr, Integer age) {
        this.name = name;
        this.addr = addr;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isHealthy() {
        return FieldValidate.validate(Student.class, this);
    }
}
