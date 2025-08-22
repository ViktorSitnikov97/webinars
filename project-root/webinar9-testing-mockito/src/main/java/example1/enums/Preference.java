package example1.enums;

public enum Preference {
    FOOTBALL("Play to football"),
    WALKING("I walk a lonely road"),
    WATCHING_FILMS("The wind is in our favor, that's all we need!"),
    READING("Clean Code");

    private final String value;
    Preference(String value) {
        this.value = value;
    }

}
