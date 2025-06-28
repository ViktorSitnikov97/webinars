package task1;

public class Pair<T, L> {
    private final T first;
    private final L second;

    public Pair(T first, L second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return this.first;
    }

    public L getSecond() {
        return this.second;
    }
}
