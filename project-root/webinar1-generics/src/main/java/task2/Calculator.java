package task2;

public class Calculator {

    public static <T extends Number> double calculateAverage(T[] array) {
        double sum = 0.0;
        for (T item : array) {
            sum += item.doubleValue();
        }
        return sum / array.length;
    }
}
