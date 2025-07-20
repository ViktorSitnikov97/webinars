package example1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Book {

    @Getter
    private final String title;

    @Getter
    private final String author;

    @Getter
    private final int age;
    
}
