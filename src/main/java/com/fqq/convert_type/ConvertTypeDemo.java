package com.fqq.convert_type;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;

import java.util.LinkedHashMap;

public class ConvertTypeDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("stuId", "some id");
        map.put("name", "some name");
        map.put("age", "11");
        Student student = ConvertTypeDemo.convertType(map, Student.class);
        System.out.println(student);
        String student_string = ConvertTypeDemo.convertType("student String", String.class);
        System.out.println(student_string);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stuId", "some id");
        jsonObject.put("name", "some name");
        jsonObject.put("age", "11");
        jsonObject.put("age1", "11");
        Student student1 = jsonObject.toJavaObject(Student.class, JSONReader.Feature.FieldBased);
        System.out.println(student1);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("student",jsonObject);
        Student student2 = jsonObject1.getObject("student", Student.class, JSONReader.Feature.FieldBased);
        System.out.println(student2);
    }

    private static <T> T convertType(Object object, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(object), clazz);
    }
}
