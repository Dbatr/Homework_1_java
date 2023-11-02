public class Manager extends Employee {
    private final String department;

    public Manager(String name, int employeeId, int yearsOfService, double salary, String department) {
        super(name, "Менеджер", employeeId, yearsOfService, salary);
        this.department = department;
    }
    @Override
    public void work() {
        System.out.println("Я управляю проектами и командами в отделе " + department + ".");
    }
}
