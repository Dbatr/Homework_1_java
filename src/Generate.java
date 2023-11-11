import java.util.Random;

public class Generate {
    public static Employee[] generateEmployeeData(int numberOfEmployees) {
        Employee[] employees = new Employee[numberOfEmployees];
        Random random = new Random();

        for (int i = 0; i < numberOfEmployees; i++) {
            Names name = Names.values()[random.nextInt(Names.values().length)];
            int employeeId = random.nextInt(9999) + 1000;
            int yearsOfService = random.nextInt(10) + 1;
            int baseSalary = random.nextInt(891) + 10;
            int salary = baseSalary * 100;
            ProgrammingLanguage language = ProgrammingLanguage.values()
                    [random.nextInt(ProgrammingLanguage.values().length)];

            employees[i] = (i % 2 == 0) ?
                    new Manager(name.getName(), employeeId, yearsOfService, salary, "Department №" + (i / 2 + 1)) :
                    new Developer(name.getName(), employeeId, yearsOfService, salary, language.getLanguage());
        }

        return employees;
    }
}
