package example1.custommocks;

import example1.PreferencesService;
import example1.enums.Preference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static example1.enums.Preference.FOOTBALL;
import static example1.enums.Preference.READING;
import static example1.enums.Preference.WALKING;
import static example1.enums.Preference.WATCHING_FILMS;

public class PreferencesServiceMock implements PreferencesService {

    private Set<Preference> preferences;

    public void setPreferences(Set<Preference> preferences) {
        this.preferences = preferences;
    }

    @Override
    public Set<Preference> get(String userId) {
        return switch (userId) {
            case "1" -> new HashSet<>(
                    List.of(FOOTBALL, READING, WATCHING_FILMS, WALKING)
            );
            case "2" -> new HashSet<>(
                    List.of(Preference.WATCHING_FILMS, Preference.WATCHING_FILMS)
            );
            case "3" -> new HashSet<>(
                    List.of(WATCHING_FILMS, WALKING)
            );
            case "11" -> new HashSet<>(
                    List.of(FOOTBALL, WALKING)
            );
            default -> new HashSet<>(
                    List.of(WALKING)
            );
        };
    }
}
