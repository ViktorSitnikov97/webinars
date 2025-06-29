package example1;

public class Main {
    public static void main(String[] args) {
        Box<String> strBox = new Box<>("value1");
        Box<Integer> intBox = new Box<>(13337);
        var obj = new Box<>(null); // внутри будет Object
//        <String> <Integer> здесь являются аргументами типа

    }
}
