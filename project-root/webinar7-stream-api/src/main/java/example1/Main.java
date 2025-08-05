package example1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
// Решить задачку1: вывести сгруппированный список пар длин и строк в порядке возрастания длины.
        List<String> list1 = Arrays.asList("asdf", "qwerty", "abc", "zxc", "gg");

        TreeMap<Integer, List<String>> result1 = list1.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(result1);

// Решить задачку2: вывести пары строк и длин в естественном порядке в виде списка.
        List<String> list2 = Arrays.asList("asdf", "qwerty", "abc", "zxc", "gg");

        List<HashMap<String, Integer>> result2 = list2.stream()
                .sorted()
                .map(s -> {
                    HashMap<String, Integer> pair = new HashMap<>();
                    pair.put(s, s.length());
                    return pair;
                })
                .toList();
        System.out.println(result2);
    }
}
