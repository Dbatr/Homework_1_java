import java.util.Scanner;
public class Company {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEmployees = 0;
        while (numberOfEmployees <= 0) {
            System.out.print("Введите количество сотрудников: ");
            try {
                numberOfEmployees = scanner.nextInt();
                if (numberOfEmployees <= 0)
                    System.out.println("Предупреждение: Введено некорректное количество сотрудников. " +
                                        "Пожалуйста, введите положительное значение.");

            } catch (java.util.InputMismatchException e) {
                System.out.println("Ошибка: Некорректный ввод. Пожалуйста, введите положительное значение.");
                scanner.next();
            }
        }
        System.out.println();

        Employee[] employees = Generate.generateEmployeeData(numberOfEmployees);

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