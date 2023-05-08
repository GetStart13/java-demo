package com.fqq.stream_optional;

import com.fqq.convert_type.Student;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        OptionalDemo optionalDemo = new OptionalDemo();
        optionalDemo.testNullable();
//        optionalDemo.testThrow();
        optionalDemo.testThrowAndDoSomething();
    }

    void testNullable() {
        Student student = null;
        String orElse = Optional.ofNullable(student)
                // 入参不为空时执行，将一个值转化成另一个值
                .map(s -> s.getName())
                // 如果值（student.getName()）不为空，返回它的 optional，否则返回你指定的 optional
                .or(() -> Optional.empty())
                // 如果不为空，返回该值，相当于检查后（isPresent）的 get()，否则返回你指定的默认值
                .orElse(null);
        System.out.println(orElse);
        Optional.ofNullable(student)
                // 可以使用 filter 进行 if(e == null) 操作
                .filter(e -> e != null)
                //  如果值存在，执行该方法体内容
                .ifPresent(s -> {
                    String name = s.getName();
                    System.out.println("ifPresent: 如果值存在，执行该方法体内容 " + name);
                });
    }

    void testThrow() {
        Student student = null;

        String name = Optional.ofNullable(student)
                .orElseThrow(() -> new RuntimeException("throw when null"))
                .getName();
        System.out.println(name);
    }

    /**
     * 如果存在，则执行正常流程，如果不存在，则抛出异常
     */
    void testThrowAndDoSomething() {
        Student student = null;

        Optional.ofNullable(student)
                .ifPresentOrElse(v -> {
                    String name = v.getName();
                    System.out.println("testThrowAndDoSomething: " + name);
                }, () -> {
                    throw new RuntimeException("do something and throw when null");
                });
    }
}
