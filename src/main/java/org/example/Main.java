package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Задание 1: ");
        List<String> words = Arrays.asList("карандаш","книга", "тетрадь", "ручка","азбука","азбука","книга","ручка");
        System.out.println(words.stream()
                        .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                        .entrySet().stream()
                        .filter(o -> o.getValue() == words.stream()
                                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                                .values().stream().mapToInt(Long::intValue).max().getAsInt())
                        .map(Map.Entry::getKey)
                        .sorted()
                        .collect(Collectors.joining(", ","Самые часто встречающееся слова: ","")));

        System.out.println("Задание 2: ");
        List<chel> chels = new ArrayList<>(Arrays.asList(
                new chel("Женя", 19, 10),
                new chel("Евгений", 200, 10),
                new chel("Даня", 17, 100),
                new chel("Данила", 23, 100),
                new chel("Вадя", 13, 10),
                new chel("Вадим", 45, 100)));
        Double avgZarplata = chels.stream()
                .collect(Collectors.averagingInt(chel::getZarplata));
        System.out.println("Средняя запрлата людей: "+avgZarplata);

        System.out.println("Задание 3: ");
        int n = 3;
        System.out.println(n+" самых старших сотрудников зовут: ");
        chels.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(chel::getAge)))
                .map((Function<chel, String>) c -> c.getName())
                .limit(n)
                .forEach(System.out::println);







    }
}