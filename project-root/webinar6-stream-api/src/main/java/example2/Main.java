package example2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1) вывести на экран в виде одной строки все слова, которые отсортированы в обратном порядке
        // 2) сгруппировать слова по длине слов и представить в отсортированном виде

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana", "orange"),
                Arrays.asList("pear", "coconut"),
                Arrays.asList("carrot", "lime", "tomato")
        );
        System.out.println(method1(listOfLists));
        System.out.println(method2(listOfLists));

    }
    public static String method1(List<List<String>> listOfLists) {
        return listOfLists.stream()
                //.flatMap(list -> list.stream())
                .flatMap(Collection::stream)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(" ")).trim();
    }
    public static TreeMap<Integer, Set<String>> method2(List<List<String>> listOfLists) {
        return listOfLists.stream()
                .flatMap((Collection::stream))
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
    }
}
