package example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        filterExample();
        groupingByExample();
        System.out.println(ExampleType.CORRECT);
        System.out.println(ExampleType.WRONG);

        long count = Stream.of("1", "2", "3", "4", "5")
                .map(Integer::parseInt)
                .filter(i -> i > 2)
                .count();
        System.out.println(count);
        flatMapExample();
        advancedMapExample1();

        List<Integer> examples = new ArrayList<>(List.of(1, 2, 3));
        for (var item: examples) {
            item =+ item + 10;
        }
        System.out.println(examples);

        // Внутри метода forEach() содержится Consumer => возвращаемое значение void. Поэтому изменить
        // через метод forEach() можно только те объекты, на которые есть ссылки:
        examples.forEach(item -> item = item + 10);
        System.out.println(examples);

        List<Example> examplesNew = getExamples();
        System.out.println(examplesNew);
        examplesNew.forEach(ex -> ex.setExample("GG, WP"));
        // Модифицировать коллекцию при прохождении ее элементов запрещено:
        examplesNew.forEach(ex -> {
            ex.setExample("GG, WP");
            examplesNew.remove(ex);
        });
        System.out.println(examplesNew);
         */

    }

    public static void advancedMapExample1() {
        // обработать stream stream'ов и вернуть его же обратно
        List<List<String>> examples = List.of(
                List.of("1", "2", "3", "4"),
                List.of("11", "22", "33", "44"),
                List.of("", "222", "333", ""),
                List.of("1111", "", "3333", "4444")
        );
        System.out.println(examples);
        List<List<String>> examplesNew = examples.stream()
                .map(list -> list.stream()
                        .filter(l -> !l.isEmpty())
                        .collect(Collectors.toList()))
                .toList();
        System.out.println(examplesNew);

    }

    public static void flatMapExample() {
        List<List<String>> examples = List.of(
                List.of("1", "2", "3", "4"),
                List.of("11", "22", "33", "44"),
                List.of("111", "222", "333", "444"),
                List.of("1111", "2222", "3333", "4444")
        );

        List<Integer> result = examples.stream()
                .flatMap(Collection::stream)
                .map(Integer::parseInt)
                .toList();
        System.out.println(result);
    }

    public static void groupingByExample() {
        List<Example> examples = getExamples();

        Map<ExampleType, List<Example>> collect = examples.stream()
                .collect(Collectors.groupingBy(Example::getType, Collectors.toList()));
        System.out.println(collect);
    }

    public static void filterExample() {
        List<Example> exampleList = getExamples();
        List<Example> filteredExampleList = exampleList.stream()
                .filter(ex -> ex.getType() == ExampleType.CORRECT)
                .collect(Collectors.toList()); // toList(); - 16 version of Java
        System.out.println(exampleList);
    }

    private static List<Example> getExamples() {
        var example1 = new Example("Example1");
        var example2 = new Example("Example2");
        var example3 = new Example("Wrong Example1");
        var example4 = new Example("Wrong Example2");
        example3.setType(ExampleType.WRONG);
        example4.setType(ExampleType.WRONG);
        List<Example> examples = List.of(example1, example2, example3, example4);
        return examples;
    }
}
