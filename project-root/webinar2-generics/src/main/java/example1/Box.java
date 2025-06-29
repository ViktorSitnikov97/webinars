package example1;

public class Box<T> { // Здесть T - это параметр типа
// класс параметризуется определенным типом T, который примет переменная value
    private T value;
    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public boolean isEmpty() {
        return !isPresent();
    }
}
