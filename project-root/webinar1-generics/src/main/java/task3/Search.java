package task3;

import java.util.Collection;

public class Search {
    public static <T> boolean containsElement(Collection<T> coll, T element) {
        return coll.contains(element);
    }
}
