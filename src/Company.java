import java.util.List;
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
                System.out.println("Ошибка: Некорректный ввод. Пожалуйста, введите число.");
                scanner.next();
            }
        }
        System.out.println();

        Employee[] employees = Generate.generateEmployeeData(numberOfEmployees);

        String filename = "employee_records.txt";
        //Work_with_file.saveEmployeeRecordsToFile(employees, filename);

       //Work_with_file.clearEmployeeFile(filename);

        int employeeIdToDelete = 10913; // Замените на конкретный ID, который нужно удалить
        //Work_with_file.deleteEmployeeById(employeeIdToDelete, "employee_records.txt");

        List<Employee> employeesList = Work_with_file.parseEmployeesFromFile(filename);
        if (!employeesList.isEmpty()) {
            Employee lowestSalaryEmployee = employeesList.get(0);
            Employee highestSalaryEmployee = employeesList.get(0);

            for (Employee employee : employeesList) {
                employee.introduce();
                System.out.println();

                double salary = employee.getSalary();
                if (salary < lowestSalaryEmployee.getSalary()) {
                    lowestSalaryEmployee = employee;
                }
                if (salary > highestSalaryEmployee.getSalary()) {
                    highestSalaryEmployee = employee;
                }
            }

            System.out.println("Сотрудник с самой низкой зарплатой: " + lowestSalaryEmployee.getName()
                    + " (ID: " + lowestSalaryEmployee.getEmployeeId() + "). У него зарплата: " + lowestSalaryEmployee.getSalary() + " долларов.");

            System.out.println("Сотрудник с самой высокой зарплатой: " + highestSalaryEmployee.getName()
                    + " (ID: " + highestSalaryEmployee.getEmployeeId() + "). У него зарплата: " + highestSalaryEmployee.getSalary() + " долларов.");
        } else {
            System.out.println("Список сотрудников пуст.");
        }

    }


}