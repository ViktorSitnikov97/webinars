package example2;

public class RawBox {
    // пример без использования дженериков через Object

    private Object value;

    public RawBox(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
