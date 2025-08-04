package example4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // Рассмотрим пример использования метода reduce():

        List<Integer> numbers = Arrays.asList(3, 4, 2, 4, 6, 12, 16); // создается список фиксированной длины (remove(), add() - unsupported)
        int sum = numbers.stream()
                .reduce(0, Integer::sum); // .reduce(0, (partialResult, current) -> partialResult + current);
        // Если список будет пуст, то возвращаемое значение partialResult, который равен 0
        System.out.println("Total Sum: " + sum);
        // Если мы не передаем нейтральный элемент в метод reduce()?, то метод будет возвращать Optional
        List<Integer> list1 = List.of(1, 2); // immutable list
        Optional<Integer> optSum1 = list1.stream()
                        .reduce(Integer::sum);
        optSum1.ifPresent(System.out::println); // пример работы с Optional

        // Работа с Optional предполагает избегание работы с null

//        Лучше так не делать с Optional!!!!!!!!!!!!!!!!!!!!!!!!:
        if (optSum1.isPresent()) {
            System.out.println(optSum1.get());
        }
// !!!!!!! Надо делать работу с Optional через семейство методов orElse()!!!!!!!!!!!!!!!!!!!!

// С помощью метода reduce() следует выполнять только ассоциативные операции
// (симметричные, такие что: x + y = y + x; x * y = y * x),
// т е разность уже нельзя двух чисел искать при использовании parallelStream()!!!!!!!!!!!!!



    }
}
