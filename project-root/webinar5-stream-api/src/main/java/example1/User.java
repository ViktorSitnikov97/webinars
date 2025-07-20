package example1;

import java.util.List;

public record User(
        String name,
        int age,
        List<Book> books
) {
    public void printMessage() {
        System.out.println("Method1");
    }
}
