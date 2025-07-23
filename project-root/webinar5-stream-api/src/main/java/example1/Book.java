package example1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    @Getter
    private final String title;

    @Getter
    private final String author;

    @Getter
    private final int age;

//    public Book(String title, String author, int age) {
//        this.title = title;
//        this.author = author;
//        this.age = age;
//    }
}
