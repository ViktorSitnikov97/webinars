package example1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {

        // Рассмотрим следующий код:

        Integer[] array = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LinkedList<Integer> list = new LinkedList<>();
        Collections.addAll(list, array);

        // Что цикл foreach, что обход коллекции с помощью оператора -
        // - это одно и то же

        for (Integer item: list) {
        // здесь, за этим циклом, полностью скрыта реализация с итератором,
        // которая представлена ниже
            System.out.println(item);
        }

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // Рассмотрим следующий пример:
        // Заполним лист случайными элементами и  помощью итератора удалим
        // все значения, что больше 128

        LinkedList<Integer> listRand = getRandomList();
        Iterator<Integer> iterator = listRand.iterator();

        while (iterator.hasNext()) {
            int item = iterator.next();
            if (item > 128) {
                iterator.remove(); // удаление за константное время item
            }
        }
        System.out.println("Size: " + listRand.size());

        // Самый быстрый способ удалить элементы из коллекции - это использовать метод removeIf():

        listRand.removeIf((item) -> item > 64);
        System.out.println("Size: " + listRand.size());
    }

    public static LinkedList<Integer> getRandomList() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            list.add((int) Math.round(Math.random() * 256));
        }
        return list;
    }
}
