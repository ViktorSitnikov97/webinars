package example3;

import example1.Box;

public class Main {
    public static void main(String[] args) {
        NumBox<Integer> numBox1 = new NumBox<>(1);
        System.out.println(numBox1.usEven());

        NumBox<Double> numBox2 = new NumBox<>(2.0);
        System.out.println(numBox2.usEven());

        NumBox<Integer> numBox3 = new NumBox<>(5);
        NumBox<Double> numBox4 = new NumBox<>(5.0);

        System.out.println(numBox3.isEqual(numBox4));

// Создаем объект NumBox<Number>, т е параметризованным более общим типом Number
        NumBox<Number> nBox = new NumBox<>(1);
// компилятор запретит операцию для первой версии метода setInt(nBox, 2); потому что у NumBox тип выше (<Number> выше <Integer>)
        setInt(nBox, 2);


        Box<Integer> iBox = new Box<>(1);
// не сработает при версии getDouble(Box<Number> box):
//      Double d = getDouble(iBox);
// сработает при версии getDouble(Box<? extends Number> box):
        Double d = getDouble(iBox);
    }
/* пусть будет функция для помещения целочисленного значения в коробку Box
    public static void setInt(Box<Integer> box, Integer value) {
        box.setValue(value);
    }

    тогда в параметре метода в параметризованном типе Box<? super Integer> мы указываем, что
    можем записывать теперь типы данных Integer и выше согласно второй версии метода:
 */
    public static void setInt(Box<? super Number> box, Integer value) {
        box.setValue(value);
        Double d = 12.44;
        Object obj = (Object) "string";
        Long l= 12900L;
        Number number = 12;
        box.setValue(number);
        box.setValue(d);
        box.setValue(l);
        // box.setValue(obj); - нельзя !!!!
        // <? super Number> блокирует следующую инструкцию:
        // Integer v = box.getValue(); ничего определенного взять мы из коробки не можем, коробка выступает потребителем
        // Number v = box.getValue(); аналогично, но доступен только Object:
        Object o = box.getValue();
        /*
        Опция с ограничением снизу <? super Number> в методе позволяет этому методу принимать объекты типа Box,
        где Number или любой его предок является типом, с которым Box может работать. Это значит,
        что можно передавать в метод setInt() объекты Box<Number>, Box<Object> и другие, содержащие подтипы Number и предков.
        Это ограничение позволяет добавить значения типа Number и всех его подтипов (например, Integer, Double, Long) в Box,
        потому что они совместимы с типами, являющимися предками Number. Каждый из этих типов может быть установлен в объект,
        описанный как супертип Number, что делает ваш код универсальным.
         */
    }
    // согласно PECS в данном случае Box выступает в качестве потребителя, т к в нее мы записываем данные

    // рассмотрим случай с получением значения Double из Box<Number>:
//    public static Double getDouble(Box<Number> box) {
//        return box.getValue().doubleValue();
//    }

    public static Double getDouble(Box<? extends Number> box) {
// но ничего нельзя будет в такую коробку положить:
// box.setValue(12.3); - !!!!!!! вдруг в коробке лежат целые числа, а мы кладем целые - компилятор не даст это сделать !!!!
// т е нет однозначности, что стоит за <? extends Number> - Integer Double и т д
// т е сейчас коробка работает только как продюсер
        Integer i = box.getValue().intValue();
        Double d = box.getValue().doubleValue();
        return box.getValue().doubleValue();
    }
}
