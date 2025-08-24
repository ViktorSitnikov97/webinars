package example1.enums;

import example1.AdviceService;
import example1.impl.PreferencesServiceImpl;
import example1.impl.WeatherServiceImpl;

import java.util.Set;

public class AdviceController {
    private AdviceService adviceService;

    public AdviceController() {
        this.adviceService = new AdviceService(new PreferencesServiceImpl(), new WeatherServiceImpl());
    }

    public Set<Preference> getPreferences(String id) {
        return adviceService.getAdvice(id);
    }
}
