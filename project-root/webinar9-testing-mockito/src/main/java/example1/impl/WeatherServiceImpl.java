package example1.impl;

import example1.WeatherService;
import example1.enums.Weather;

public class WeatherServiceImpl implements WeatherService {
    @Override
    public Weather currentWeather() {
        return Weather.RAINY;
    }
}
