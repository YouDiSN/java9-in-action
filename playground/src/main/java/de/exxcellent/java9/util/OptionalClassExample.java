package de.exxcellent.java9.util;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xiwang on 9/27/17.
 * OptionalClassExample
 */
public class OptionalClassExample {

    public static void main(String[] args) {
        optionalOr("value1", null);
        optionalStream();
    }

    @SuppressWarnings("SameParameterValue")
    private static void optionalOr(String value1, String value2) {
        Optional.ofNullable(value1).or(() -> Optional.ofNullable(value2))
                .map(String::length)
                .filter(length -> 10 < length)
                .map(length -> Integer.toString(length))
                .ifPresentOrElse(System.out::println, () -> System.out.println("None"));
    }

    private static void optionalStream() {
        List<Optional<String>> list = List.of(
                Optional.of("1"),
                Optional.of("2"),
                Optional.empty(),
                Optional.of("4"),
                Optional.empty(),
                Optional.of("6")
        );

        // in java 9
        Set<String> stringSet = list.stream()
                .flatMap(Optional::stream)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        // in java 8
        Set<String> stringSet1 = list.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

}
