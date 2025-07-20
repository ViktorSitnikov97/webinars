package example1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookGenerator {
    private static final String[] TITLES = {"The Great Gatsby", "Book number 1", "Book2", "Book3", "1984"};
    private static final String[] AUTHORS = {"Author1", "Author2", "Author3", "Author4", "Author5"};
    private static final int[] YEARS = {1234, 234, 1567, 1789, 2003};

    public static List<Book> generateRandomBooks(int n) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            books.add(generateRandomBook());
        }
        return books;
    }

    private static Book generateRandomBook() {
        Random random = new Random();
        String title = TITLES[random.nextInt(TITLES.length)];
        String author = AUTHORS[random.nextInt(AUTHORS.length)];
        int year = YEARS[random.nextInt(YEARS.length)];
        return new Book(title, author, year);
    }


}
