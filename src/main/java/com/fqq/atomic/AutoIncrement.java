package com.fqq.atomic;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AutoIncrement {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        AtomicInteger index = new AtomicInteger();
        list.forEach(v -> {
            System.out.println(index.addAndGet(1));
            System.out.println(index.getAndIncrement());
        });
    }
}
