package example3;

import example1.Box;

// У нас возникла необходимость создать класс с дополнительным функционалом,
// при этом наследующим методы класса Box. Более того, мы указываем, что наш класс
// NumBox<T extends Number>, т е будет работать только с подклассами и классом
// Number включительно
public class NumBox<T extends Number> extends Box<T> {
    public NumBox(T value) {
        super(value);
    }
    public boolean usEven() {
        return getValue().intValue() % 2 == 0;
    }

    /* сейчас мы ограничены только работой с типом Integer:
    public boolean isEqual(NumBox<Integer> numBox) {
        if (isEmpty() && numBox.isEmpty()) {
            return true;
        }
        if (isEmpty() || numBox.isEmpty()) {
            return false;
        }
        return getValue().intValue() == numBox.getValue().intValue();
    }

    // Чтобы иметь возможность работать с несколькими числовыми типами, что указаны в параметре типа класса
    // Достаточно поставить символ (?) вместо Integer:
    */

    public boolean isEqual(NumBox<?> numBox) {
        if (isEmpty() && numBox.isEmpty()) {
            return true;
        }
        if (isEmpty() || numBox.isEmpty()) {
            return false;
        }
        return getValue().intValue() == numBox.getValue().intValue();
    }
    // таким образом мы расширили возможность сравнения объектов разных типов данных на равенство

    // Рассмотрим случай ограничения метасимвола (?) согласно специфике метода:


}
