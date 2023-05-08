package com.fqq.stream_optional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();
        demo.takeWhileTest();
        demo.findAny();
        demo.testFilter();
        demo.test();
        demo.dropWileTest();
    }

    /**
     * <p> 2022/12/24 21:46 </p>
     * 通过 filter 过滤掉数据
     * <p> 通过 takeWhile 停止流的迭代，相当于无序的 break;
     * <br> 不希望使用此方法遍历查找流中的某个值并终止，takeWhile 意义在于获取流中符合条件的集合，而不是查找到某个值则终止
     */
    void takeWhileTest() {
        Stream<Integer> stream = Stream.of(4, 4, 4, 5, 6, 7, 9);

        List<Integer> list = stream
                .takeWhile(v -> {
                    System.out.println("》》》》》》 进入 takeWhile，值: " + v + " 》》》》》");
                    // 返回 false 时，流被终止
                    return v.equals(4);
                })
                .toList();

        System.out.println("过滤得到符合条件的流并转成集合，并且终止掉流，list: " + list);
    }

    /**
     * dropWhile 用于获取流中不符合条件的集合
     */
    void dropWileTest() {
        Stream<Integer> stream = Stream.of(3, 3, 3, 4, 5, 6, 8, 9);
        List<Integer> list = stream.dropWhile(number -> {
            System.out.println("》》》》》 进入 dropWhile 》》》》》");
            System.out.println("number: " + number);
            return Objects.equals(number, 3);
        }).toList();

        System.out.println("不符合条件的集合: " + list);
    }

    /**
     * <p> 2022/12/24 22:08 </p>
     * 只要找到一个结果，就会终止流，推荐使用该方法去获取流中某个值
     */
    void findAny() {
        Stream<Integer> stream = Stream.of(2, 2, 2, 3, 3, 4, 5, 7, 9);
        stream.filter(v -> {
                    System.out.println("过滤了: " + v);
                    return v.equals(3);
                })
                .findAny()
                .ifPresent(v -> System.out.println("处理的值: " + v));
    }

    /**
     * filter 后 foreach，会先遍历一遍集合，再 foreach
     */
    void testFilter() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add(null);
        strings.add("three");
        strings.stream()
                .filter(s -> s != null)
                .forEach(s -> {
                    boolean b = s.startsWith("o");
                    System.out.println(b);
                });
    }

    void test() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "a");
        hashMap.put("b", "a");
        hashMap.put("c", "a");
        hashMap.put("d", "a");
        hashMap.put("dd", "a");
        hashMap.put("ds", "a");
        hashMap.put("dww", "a");
        hashMap.forEach((k, v) -> {
            if ("a".equals(v)) {
                // hashMap.remove(v); 迭代中修改集合将导致异常
            }
        });
        System.out.println(hashMap);
    }
}
