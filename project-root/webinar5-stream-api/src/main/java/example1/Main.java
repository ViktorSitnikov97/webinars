package example1;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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
        // элементы начинают обрабатываться:
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
*/

    }
}
