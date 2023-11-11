public abstract class Employee {
    private final String name;
    private final String position;
    private final int employeeId;
    private final int yearsOfService;
    private final double salary;

    public double getSalary() {
        return salary;
    }
    public Employee(String name, String position, int employeeId, int yearsOfService, double salary) {
        this.name = name;
        this.position = position;
        this.employeeId = employeeId;
        this.yearsOfService = yearsOfService;
        this.salary = salary;
    }

    public abstract void work();
    public void introduce() {
        System.out.println("Привет, меня зовут " + name + ". Вот мои данные:" + "\n" +
                "ID сотрудника: " + employeeId + "\n" +
                "Имя: " + name + "\n" +
                "Должность: " + position + "\n" +
                "Стаж: " + getYearsString() + "\n" +
                "Зарплата в $: " + formatSalary(salary));
    }


    private String getYearsString() {
        if (yearsOfService >= 11 && yearsOfService <= 14) {
            return yearsOfService + " лет";
        }
        int lastDigit = yearsOfService % 10;
        if (lastDigit == 1) {
            return yearsOfService + " год";
        }
        if (lastDigit >= 2 && lastDigit <= 4) {
            return yearsOfService + " года";
        }
        return yearsOfService + " лет";
    }

    private String formatSalary(double salary) {
        return String.format("%.2f", salary);
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
}
