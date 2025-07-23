package example1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
/*

        System.out.println(UserGenerator.generateRandomUser());
        List<Book> books = BookGenerator.generateRandomBooks(10);
        Stream<Book> streamOfBooks = books.stream();
        streamOfBooks.forEach(System.out::println);

//        Рассмотрим несколько способов генерирования стримов:

        Stream.generate(UserGenerator::generateRandomUser)
                .limit(10)
                .skip(3)
                .forEach(System.out::println);

        Stream.of( // полезно для тестирования
                UserGenerator.generateRandomUser(),
                UserGenerator.generateRandomUser(),
                UserGenerator.generateRandomUser(),
                UserGenerator.generateRandomUser(),
                UserGenerator.generateRandomUser()
        ).forEach(System.out::println);

// на основе предыдущего значения выполняется некоторая унарная операция в виде лямбда-выражения:
        Stream.iterate(2L, i -> i * 2)
                .limit(10)
                .forEach(System.out::println);

        Stream<User> users = Stream.generate(UserGenerator::generateRandomUser)
                .limit(10);
        Stream<String> strings = Stream.of("a1", "c1", "a5", "b1", "b3", "c2", "a4", "b3", "b2");
//        strings.skip(3).forEach(System.out::println); дважды обратиться к одному и тому стриму нельзя
        strings.map(s -> s.substring(0, 1))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        users.map(User::name).forEach(System.out::println);

//        Рассмотрим пример использования метода flatMap():
//        - метод выпрямляет список списков (например) в один поток

        Stream<User> users2 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(10);
        users2.map(User::books)
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        // Рассмотрим промежуточный метод dropWhile(), который принимает на вход поток элементов и
        // пропускает их мимо, пока условие внутри метода возвращает true, а потом, как только первый раз false -
        // следующие элементы начинают обрабатываться:
        Stream<String> strings2 = Stream.of("a1", "c1", "a5", "b1", "b3", "c2", "a4", "b3", "b2");
        strings2.dropWhile(s -> !s.contains("5"))
                .forEach(System.out::println);

//        Рассмотрим различные способы сортировки:
//        - sorted() принимает компаратор, либо без аргументов сортирует в  естественном порядке
        Stream<String> strings3 = Stream.of("avvv1", "c1", "ae5", "b9", "bv3", "cv2", "eeea4", "b3", "b2");
        strings3
                .sorted(String.CASE_INSENSITIVE_ORDER::compare) // (o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1, o2)
                .sorted(Comparator.reverseOrder())
                .sorted((o1, o2) -> o2.substring(o2.length() - 1).compareTo(o1.substring(o1.length() - 1)))
                .sorted(Comparator.naturalOrder())
                .sorted(Comparator.comparing(String::length, Comparator.reverseOrder()))
                .forEach(System.out::println);

        // Для того, чтобы можно было сортировать пользователей без передачи компаратора - методом sorted() - необходимо, чтобы
        // класс User реализовывал интерфейс Comparable<T>:
        Stream<User> users3 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(10);
        users3.sorted()
                .forEach(System.out::println); // compareTo() переопределен на  сравнение по возрасту

        Stream<User> users4 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(10);
        users4.sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.name(), o2.name()))
                .sorted(Comparator.comparing(User::age))
                .sorted((o1, o2) -> Integer.compare(o2.age(), o1.age()))
                .forEach(System.out::println);

        // Задачка: вывести все уникальные книги, которые есть у пользователей старше 30-ти лет, в отсортированном порядке по названиям:
        Stream<User> users5 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(9);
        users5.filter(u -> u.age() >= 30)
                .map(User::books)
                .flatMap(Collection::stream)// books -> books.stream()
                .distinct()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);

        // Далее рассмотрим терминальные операции:

        Stream<User> users6 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(9);

        Map<String, List<User>> collect1 = users6.collect(Collectors.groupingBy(User::name));
        System.out.println(collect1);

        Stream<User> users7 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(3);

        Map<String, Set<User>> collect2 = users7.collect(Collectors.groupingBy(User::name, Collectors.toSet()));
        System.out.println(collect2);

        Stream<User> users8 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(100);
        Map<String, Long> result = users8.collect(Collectors.groupingBy(User::name, TreeMap::new, Collectors.counting()));
        System.out.println(result);


//        Посчитаем количество уникальных книг у пользователей:

        Stream<User> users9 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(10);

        var count = users9
                .map(User::books)
                .flatMap(Collection::stream)
                .distinct()
                .count();
        System.out.println(count);

//        Посчитаем количество всех книг у пользователей:
        Stream<User> users10 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(10);

        var sum = users10
                .map(User::books)
                .mapToInt(List::size)
                .sum();
        System.out.println(sum);

//        Посчитаем среднее количество книг у каждого пользователя:
        Stream<User> users11 = Stream.generate(UserGenerator::generateRandomUser)
                .limit(5);
        var average = users11
                .map(User::books)
                .mapToInt(List::size)
                .average();
        System.out.println(average);

 */
        // Рассмотрим терминальные методы, что возвращают boolean:
        Stream<String> strings11 = Stream.of("a1", "c1", "a5", "b1", "b3", "c2", "a4", "b3", "b2");

        var isTrue = strings11
                .noneMatch(s -> s.isEmpty()); // .allMatch(s -> !s.isEmpty());
        System.out.println(isTrue);
    }
}
