package de.exxcellent.java9.collections;

import java.util.List;

/**
 * Created by xiwang on 9/24/17.
 * StreamApiDemo
 */
public class StreamApiDemo {

    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(takeWhile(ints));
        System.out.println(dropWhile(ints));
    }

    private static int dropWhile(List<Integer> ints) {
        return ints.stream()
                .dropWhile(i -> i <= 3)
                .peek(System.out::println)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int takeWhile(List<Integer> list) {
        return list.stream()
                .takeWhile(i -> i < 3)
                .peek(System.out::println)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
