package example1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static void exampleGroupingBy() {
        List<Example> examples = new getExamples();

        Map<ExampleType, List<Example>> collect = examples.stream()
                .collect(Collectors.groupingBy(Example::getType, Collectors.toList()));
        System.out.println(collect);
    }

    public static void filterExample() {
        List<Example> exampleList = examples.stream()
                .filter(ex -> ex.getType == ExampleType.CoRRECT)
                .collect(Collectors.toList()); // toList();
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
