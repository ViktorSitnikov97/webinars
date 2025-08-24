package example1.custommocks;

import example1.WeatherService;
import example1.enums.Weather;

public class WeatherServiceMock implements WeatherService {
    private Weather weather;

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public Weather currentWeather() {
        return this.weather;
    }
}
