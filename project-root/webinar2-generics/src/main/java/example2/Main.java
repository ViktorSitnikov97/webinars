package example2;

import example1.Box;

public class Main {
    public static void main(String[] args) {
        // Рассмотрим случай, в котором не обеспечивается типовая безопасность
        RawBox box1 = new RawBox("123");
        // ОЧЕНЬ МНОГО КОДА ДО 40000 СТРОК
        Integer box2 = (Integer) box1.getValue();
        // нам не подсвечивается ошибка, но вылетит ClassCastException на 8 строке
        // Таким образом, мы не защищены от ошибок при работе с классом RawBox, внутри которого используется Object
        // Но такой ошибки можно избежать при использовании Generics
        Box<Integer> box3 = new Box<>(123);
        // String number = (String )box3.getValue(); компилятор запретит такую инструкцию и не даст начать компиляцию

    }
}
