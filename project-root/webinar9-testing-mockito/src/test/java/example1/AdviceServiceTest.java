package example1;

import example1.custommocks.PreferencesServiceMock;
import example1.custommocks.WeatherServiceMock;
import example1.enums.Preference;
import example1.enums.Weather;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Set;

import static example1.enums.Preference.FOOTBALL;
import static example1.enums.Preference.READING;
import static example1.enums.Preference.WALKING;
import static example1.enums.Preference.WATCHING_FILMS;
import static org.junit.jupiter.api.Assertions.*;

class AdviceServiceTest {
    // Реализуем сначала моки вручную:
    @Test
    void getAdviceRAINY() {
        //given
        Set<Preference> expected = Set.of(READING, WATCHING_FILMS, WALKING);

        WeatherServiceMock weatherServiceMock = new WeatherServiceMock();
        weatherServiceMock.setWeather(Weather.RAINY);

        PreferencesServiceMock preferencesServiceMock = new PreferencesServiceMock();
        preferencesServiceMock.setPreferences(Set.of(FOOTBALL, READING, WATCHING_FILMS, WALKING));

        //when
//        Поскольку мы хотим получать ожидаемый и независимый ответ от работы сервиса, то вместо настоящего сервиса используем мок:
//        AdviceService adviceService = new AdviceService(new PreferencesServiceImpl(), new WeatherServiceImpl());
        AdviceService adviceService = new AdviceService(preferencesServiceMock, weatherServiceMock);
        Set<Preference> actual = adviceService.getAdvice("1");
        //then
        assertEquals(actual, expected);
    }

    void getAdviceSUNNY() {
        //given
        Set<Preference> expected = Set.of(FOOTBALL, WATCHING_FILMS, WALKING);

        WeatherServiceMock weatherServiceMock = new WeatherServiceMock();
        weatherServiceMock.setWeather(Weather.SUNNY);

        PreferencesServiceMock preferencesServiceMock = new PreferencesServiceMock();
        preferencesServiceMock.setPreferences(Set.of(FOOTBALL, READING, WATCHING_FILMS, WALKING));

        //when
//        Поскольку мы хотим получать ожидаемый и независимый ответ от работы сервиса, то вместо настоящего сервиса используем мок:
//        AdviceService adviceService = new AdviceService(new PreferencesServiceImpl(), new WeatherServiceImpl());
        AdviceService adviceService = new AdviceService(preferencesServiceMock, weatherServiceMock);
        Set<Preference> actual = adviceService.getAdvice("1");
        //then
        assertEquals(actual, expected);
    }

    // Теперь реализуем с помощью библиотеки Mockito

    @Test
    void getAdviceWithMockitoSunny() {

        Set<Preference> expected = Set.of(WATCHING_FILMS);

        // Теперь фактическая реализация заглушек не нужна, все локально в тесте настраивается:
        WeatherService weatherServiceMock =  Mockito.mock(WeatherService.class);
        // даже если в интерфейсе будет больше методов, через Mockito мы можем выбрать только желаемые методы, а не обязательно все
        Mockito.when(weatherServiceMock.currentWeather()).thenReturn(Weather.SUNNY);


        PreferencesService preferencesServiceMock = Mockito.mock(PreferencesService.class);
        Mockito.when(preferencesServiceMock.get("2")).thenReturn(Set.of(Preference.WATCHING_FILMS, Preference.READING));

        AdviceService adviceService = new AdviceService(preferencesServiceMock, weatherServiceMock);
        Set<Preference> actual = adviceService.getAdvice("2");
        assertEquals(actual, expected);
    }
    @Test
    void getAdviceWithMockitoRAINY() {

        Set<Preference> expected = Set.of(WALKING);

        WeatherService weatherServiceMock = Mockito.mock(WeatherService.class);
        Mockito.when(weatherServiceMock.currentWeather()).thenReturn(Weather.RAINY);

        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);
        Mockito.when(preferencesService.get("11")).thenReturn(Set.of(WALKING));

        AdviceService adviceService = new AdviceService(preferencesService, weatherServiceMock);
        Set<Preference> actual = adviceService.getAdvice("11");
        assertEquals(expected, actual);
    }

}