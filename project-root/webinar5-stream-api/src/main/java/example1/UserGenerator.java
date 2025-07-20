package example1;


import java.util.List;
import java.util.Random;

import static example1.BookGenerator.generateRandomBooks;

public class UserGenerator {
    private static final String[] NAMES = {"Alice", "Baby Bob", "David", "Lyaya", "Henry", "Ivy"};
    private static final int MAX_BOOKS_PER_USER = 5;

    public static User generateRandomUser() {
        Random random = new Random();
        String name = NAMES[random.nextInt(NAMES.length)];
        int age = random.nextInt(50) + 20; // от 20 до 70
        List<Book> books = generateRandomBooks(random.nextInt(MAX_BOOKS_PER_USER) + 1); // от 1 до MAX_BOOKS_PER_USER
        return new User(name, age, books);
    }
}
