public enum Names {
    Sasha("Саша"),
    Denis("Денис"),
    Lena("Лена"),
    John("Джон"),
    Maria("Мария"),
    Vladimir("Владимир"),
    Ivan("Иван"),
    Artem("Артем"),
    Pavel("Павел");
    // Cписок имен можно дополнить.

    private final String name;

    Names(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
