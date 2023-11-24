public class Developer extends Employee {
    private final String programmingLanguage;

    public Developer(String name, int employeeId, int yearsOfService, double salary, String programmingLanguage) {
        super(name, "Разработчик", employeeId, yearsOfService, salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    public String work() {
        return "Я программирую на " + programmingLanguage + " и разрабатываю ПО.";
    }

    @Override
    public String toString() {
        return super.toString() + work();
    }
}
