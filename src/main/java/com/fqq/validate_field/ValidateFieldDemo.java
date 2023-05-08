package com.fqq.validate_field;

public class ValidateFieldDemo {
    public static void main(String[] args) {
        Student student = new Student("driftBottle", "addr", null);
        boolean healthy = student.isHealthy();
        System.out.println(healthy);
    }
}
