package example1;

import java.util.regex.Pattern;

public class RussianPhoneValidator {
    private static final Pattern PHONE_NUMBER = Pattern.compile("^((\\+7|7|8)+([0-9]){10})$");
    public static boolean validatePhoneNumber (String phoneNumber) {
        return PHONE_NUMBER.matcher(phoneNumber).matches();
    }
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // С помощью комбинации клавиш Ctrl + Shift + T можно быстро добавить тесты для методов данного класса

}
