import java.util.Scanner;

public class Calc {
    public void selectInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите действие кальулятора:");
        Object action = scanner.next();
        System.out.println("Введите первое значение:");
        Object firstVal = scanner.next();
        System.out.println("Введите второе значение:");
        Object secondVal = scanner.next();
        scanner.close();

        if ("+".equals(action)) {
            System.out.printf("Результат после сложения: %s%n", addition(firstVal, secondVal));
        } else if ("-".equals(action)) {
            System.out.printf("Результат после вычитания: %s%n", subtraction(firstVal, secondVal));
        } else if ("*".equals(action)) {
            System.out.printf("Результат после умножения: %s%n", multiplication(firstVal, secondVal));
        } else if ("/".equals(action)) {
            System.out.printf("Результат после деления: %s%n", division(firstVal, secondVal));
        } else {
            System.out.println("Введено некорректное действие калькулятора");
        }
    }

    public Object addition(Object first, Object second) {
        return Integer.parseInt(String.valueOf(first)) + Integer.parseInt(String.valueOf(second));
    }

    public Object subtraction(Object first, Object second) {
        return Integer.parseInt(String.valueOf(first)) - Integer.parseInt(String.valueOf(second));
    }

    public Object multiplication(Object first, Object second) {
        return Integer.parseInt(String.valueOf(first)) * Integer.parseInt(String.valueOf(second));
    }

    public Object division(Object first, Object second) {
        return Integer.parseInt(String.valueOf(first)) / Integer.parseInt(String.valueOf(second));
    }
}
