package example2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Cart> list1 = new ArrayList<>();

        list1.add(new Cart(List.of("sugar", "bread", "orange"), 450));
        list1.add(new Cart(List.of("pear", "apple", "orange"), 690));
        list1.add(new Cart(List.of("potatoes", "bread", "orange", "tomato", "lemon"), 1450));
        list1.add(new Cart(List.of("sugar", "bread", "orange", "salt", "cake", "cookie", "pizza"), 2550));

        // задача1: вывести список всех продуктов без повторений в обратном порядке
/*
        List<String> result1 = list1.stream()
                .map(Cart::products)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(result1);

        // задача2: взять первые буквы из каждой строки списка, перевести все в верхний регистр и объединить в одну строку, предварительно отсортировав.
        List<String> list2 = List.of("AQwsc", "axzq", "jhgr", "treqS", "ZXC", "ToTty");

        String result2 = list2.stream()
                .map(s -> s.substring(1, 2))
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining("!", "[", "]"));
        System.out.println(result2);
    */

        List<User> users = List.of(
                new User(12, "Mark"),
                new User(21, "Goshan"),
                new User(34, "Sergey"),
                new User(42, "Kate"),
                new User(55, "Boris"),
                new User(26, "Xenia")
        );
        // Найти: 1)сумму всех возрастов, 2)средний возраст.
        // 3) Вернуть список всех имен
        // 4) Сгруппировать имена по длине имени
        // 5) Сгруппировать в две группы относительно среднего возраста (ниже / выше)
        // 6) Вывести самое длинное имя

        List<User> users1 = users;
        Optional<Integer> sum = users1.stream()
//                .mapToInt(User::age)
//                .sum();
                .map(User::age)
        .reduce(Integer::sum);
//        .reduce((subTotal, nextItem) -> subTotal + nextItem);
        sum.ifPresent(System.out::println);


        List<User> users2 = users;
        OptionalDouble average = users2.stream()
                .mapToInt(User::age)
                .average();
        average.ifPresent(System.out::println);


        List<User> users3 = users;
        List<String> names = users3.stream()
                .map(User::name)
                .collect(Collectors.toList());
        System.out.println(names);


        List<User> users4 = users;
        Map<Integer, List<String>> result4 = users4.stream()
                .map(User::name)
                .collect(Collectors.groupingBy(String::length, HashMap::new, Collectors.toList()));
        System.out.println(result4);


        List<User> users5 = users;
        Map<Boolean, List<User>> result5 = users5.stream()
                .collect(Collectors.partitioningBy(user -> (double) user.age() < average.getAsDouble()));
        System.out.println(result5);


        List<User> users6 = users;
        String mostLengthName = users6.stream()
                .map(User::name)
                .reduce((partialItem, nextItem) -> partialItem.length() < nextItem.length() ? nextItem : partialItem)
                .orElse("GG, WP!");
        System.out.println(mostLengthName);




    }

}
