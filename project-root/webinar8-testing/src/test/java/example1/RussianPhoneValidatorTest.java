package example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RussianPhoneValidatorTest {

    @Test
    void validatePhoneNumberPositive() {
//        given
        String phoneNumber = "+79967467999";
//        when
        boolean isValid = RussianPhoneValidator.validatePhoneNumber(phoneNumber);
//        then
        Assertions.assertTrue(isValid);
    }

    @Test
    void validatePhoneNumberNegative() {
//        given
        String phoneNumber = "+12345678910";
//        when
        boolean isValid = RussianPhoneValidator.validatePhoneNumber(phoneNumber);
//        then
        Assertions.assertFalse(isValid);
    }

    // Создадим параметризированные тесты:

    //
    @ParameterizedTest
    @CsvSource({
            "+79997467989, true",
            "89967467989, true",
            "+79167467989, true",
            "+79997467989, true",
            "86999746798991, false",
            "+119997467989, false",
            "+7099974679, false"
    })
    void validatePhoneNumbers(String phoneNumber, boolean expectedResult) {
        // в качестве параметров в метод переданы номер телефона и ожидаемый результат,
        // оба параметра находятся в аннотации @CsvSource, которые автоматически парсятся
        // в два параметра (или больше, если в строке больше параметров через запятую) из строки
        boolean isValid = RussianPhoneValidator.validatePhoneNumber(phoneNumber);
        Assertions.assertEquals(expectedResult, isValid);
    }

    // Также можно воспользоваться аннотацией @ValueSource для случая, когда входные данные
    // ожидают проверки либо только на позитивный случай, либо только на негативный:
    @ParameterizedTest
    @ValueSource(strings = {"+91231231223123", "666122211", "-12237891221"})
    void validatePhoneNumbersNegativeNew(String phoneNumber) {
        boolean actual = RussianPhoneValidator.validatePhoneNumber(phoneNumber);
        Assertions.assertFalse(actual);
    }
}