package example3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1) Реализовать вывод нескольких списков из набора Cart продуктов в виде одной строки
        // 2) Определить общую сумму всех продуктов вместе и среднюю цену стоимости корзины

        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart(List.of("bread", "potatoes", "apple", "coffee"), 1000));
        carts.add(new Cart(List.of("lemon", "orange", "sugar"), 2500));
        carts.add(new Cart(List.of("pineapple", "pear", "watermelon"), 1700));

        System.out.println(method1(carts));
        System.out.println(method2(carts).getAsDouble());
    }
    public static String method1(List<Cart> carts) {
        return carts.stream()
                .map(Cart::getProducts)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.joining(" ", "[", "]")).trim();
    }
    public static OptionalDouble method2(List<Cart> carts) { // int
        return carts.stream()
                .mapToInt(Cart::getTotalPrice)
//                .sum();
//                .reduce(0, (priceAcc,price) -> priceAcc += price);
                .average();
    }

}
