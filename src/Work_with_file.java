import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Work_with_file {
    public static void saveEmployeeRecordsToFile(Employee[] employees, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Employee employee : employees) {

                // Добавляем информацию из метода work в файл
                if (employee instanceof Developer) {
                    writer.write(employee.toString());

                } else if (employee instanceof Manager) {
                    writer.write(employee.toString());

                }

                // Разделитель между записями
                writer.newLine();
            }
            System.out.println("Записи о сотрудниках сохранены в файле " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записей о сотрудниках в файл: " + e.getMessage());
        }
    }
    public static void deleteEmployeeById(int employeeId, String fileName) {
        try {
            List<String> lines = new ArrayList<>();
            File file = new File(fileName);

            // Читаем все строки из файла
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Проверяем, содержит ли текущая строка ID сотрудника для удаления
                    if (!line.contains("ID сотрудника: " + employeeId)) {
                        lines.add(line);
                    }
                }
            }

            // Записываем обновленные данные обратно в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Сотрудник с ID " + employeeId + " удален из файла " + fileName);

        } catch (IOException e) {
            System.out.println("Ошибка при удалении сотрудника: " + e.getMessage());
        }
    }

    public static void clearEmployeeFile(String fileName) {
        try {
            File file = new File(fileName);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Ничего не записываем, приведет к удалению всех данных в файле
            }

            System.out.println("Все записи удалены из файла " + fileName);

        } catch (IOException e) {
            System.out.println("Ошибка при удалении записей: " + e.getMessage());
        }
    }

    public static List<Employee> parseEmployeesFromFile(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Employee employee = parseEmployeeData(line);
                if (employee != null) {
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return employees;
    }

    private static Employee parseEmployeeData(String line) {
        try {
            String[] parts = line.split(" ");
            int employeeId = Integer.parseInt(parts[2]);
            String name = parts[4];
            String position = parts[6];
            int yearsOfService =Integer.parseInt(parts[8]);

            double salary = Double.parseDouble(parts[13].replace(",", "."));

            if (position.equals("Менеджер")) {
                String department = extractDepartmentOrPrLang(line);
                return new Manager(name, employeeId, yearsOfService, salary, department);
            } else if (position.equals("Разработчик")) {
                String programmingLanguage = extractDepartmentOrPrLang(line);
                return new Developer(name, employeeId, yearsOfService, salary, programmingLanguage);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка при парсинге данных: " + e.getMessage());
        }
        return null;

    }
    private static String extractDepartmentOrPrLang(String line) {
        int start = 14;
        int end = line.lastIndexOf(".");
        return line.substring(start, end).trim();
    }


}
