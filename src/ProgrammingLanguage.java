public enum ProgrammingLanguage {
    JAVA("Java"),
    PYTHON("Python"),
    C("C"),
    C_PLUS_PLUS("C++"),
    C_SHARP("C#"),
    KOTLIN("Kotlin"),
    RUBY("Ruby"),
    GO("Go"),
    PHP("PHP"),
    JavaScript("JavaScript");

    private final String language;

    ProgrammingLanguage(String language) {
        this.language = language;
    }
    public String getLanguage() {
        return language;
    }
}