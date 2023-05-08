package com.fqq.validate_field;

import java.lang.reflect.Field;

public class FieldValidate {
    private FieldValidate() {
    }

    public static boolean validate(Class<?> clazz, Object instance) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            boolean present = field.isAnnotationPresent(Important.class);
            if (present) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(instance);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value == null) {
                    System.out.println("important field value of " + clazz + " was null, field: " + field.getName());
                    return false;
                }
            }
        }
        return true;
    }
}
