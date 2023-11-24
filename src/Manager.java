public class Manager extends Employee {
    private final String department;

    public Manager(String name, int employeeId, int yearsOfService, double salary, String department) {
        super(name, "Менеджер", employeeId, yearsOfService, salary);
        this.department = department;
    }
    @Override
    public String work() {
        return "Я управляю проектами и командами в отделе " + department + ".";
    }

    @Override
    public String toString() {
        return super.toString() + work();
    }
}
