package example1;

import example1.enums.Preference;

import java.util.Set;

public interface PreferencesService {
    Set<Preference> get(String userId);
}
