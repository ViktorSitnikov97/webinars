package example1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Вывести на основе списка строк упорядоченный список в обратном порядке
        // первых букв в верхнем регистре:
        List<String> list1 = Arrays.asList("ba", "rsy", "ka", "eb", "al", "twa", "ri");
        System.out.println(perform(list1));


    }
    public static List<String> perform(List<String> list) {
        return list.stream()
                .map(s -> s.charAt(0))// s -> s.substring(0, 1)
                .map(s -> s.toString().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
