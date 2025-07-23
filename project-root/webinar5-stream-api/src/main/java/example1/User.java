package example1;

import java.util.List;
import java.util.Objects;

public record User(
        String name,
        int age,
        List<Book> books
) implements Comparable<User> {
    public void printMessage() {
        System.out.println("Method1");
    }

    @Override
    public int compareTo(User o) {
        if (age == o.age) {
            return 0;
        } else if (age < o.age) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(books, user.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, books);
    }
}
