import java.util.Random;
import java.util.Scanner;
public class Company {

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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество сотрудников: ");
        int numberOfEmployees = scanner.nextInt();
        System.out.println();

        Employee[] employees = generateEmployeeData(numberOfEmployees);

        Employee lowestSalaryEmployee = null;
        Employee highestSalaryEmployee = null;
        double lowestSalary = Double.MAX_VALUE;
        double highestSalary = Double.MIN_VALUE;

        for (Employee employee : employees) {
            employee.introduce();
            employee.work();
            System.out.println();

            double salary = employee.getSalary();
            if (salary < lowestSalary) {
                lowestSalary = salary;
                lowestSalaryEmployee = employee;
            }
            if (salary > highestSalary) {
                highestSalary = salary;
                highestSalaryEmployee = employee;
            }
        }
        System.out.println("Сотрудник с самой низкой зарплатой: " + lowestSalaryEmployee.getName()
                + " (ID: " + lowestSalaryEmployee.getEmployeeId() + "). У него зарплата: " + String.format("%.2f", lowestSalary) + " долларов.");
        System.out.println("Сотрудник с самой высокой зарплатой: " + highestSalaryEmployee.getName()
                + " (ID: " + highestSalaryEmployee.getEmployeeId() + "). У него зарплата: " + String.format("%.2f", highestSalary) + " долларов.");
    }


}