package example2;

import java.util.Iterator;

public class Main {
    // foreach цикл можно использовать с тем классом,
    // который реализует интерфейс Iterable

    // Рассмотрим следующий пример:

    // Реализуем класс, который позволит итерироваться по циклу в фиксированном диапазоне:
    private static class Range implements Iterable<Integer> {

        int start;
        int end;

        public static Range fromTo(int from, int to) {
            return new Range(from, to);
        }
        private Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
// Главное, что необходимо реализовать в классе, что использовать foreach:

        @Override
        public Iterator iterator() {
            return new Iterator(start);
        }
// т е Iterable - это все что угодно, что может возвращать итератор

        class Iterator implements java.util.Iterator<Integer> {
            int current;

            public Iterator(int current) {
                this.current = current;
            }

            @Override
            public boolean hasNext() {
                return current <= end;
            }

            @Override
            public Integer next() {
                return current++;
            }
        }
    }

    public static void main(String[] args) {

        // Теперь можно создать следующий цикл:

        for (int i: Range.fromTo(0, 100)) { // таким образом здесь используется далеко не коллекция
            System.out.println(i);
        }
        // итератор создается автоматически при создании объекта Range и далее работают методы hasNext() и next()
    }



}
