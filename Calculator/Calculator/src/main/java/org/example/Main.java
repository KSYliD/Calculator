package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int firstNum = getInt();
        char operation = getOperation();
        int secondNum = getInt();
        int result = calculate(firstNum,operation,secondNum);
        System.out.println("Результат операції: "+result);
    }

    public static int getInt(){
        System.out.println("Введіть число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Неправильно введене число. Спробуйте ще раз.");
            scanner.next();//рекурсія
            num = getInt();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Введіть операцію:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Неправильно введена операція. Спробуйте ще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static int calculate(int firstNum, char operation, int secondNum){
        return switch (operation) {
            case '+' -> firstNum + secondNum;
            case '-' -> firstNum - secondNum;
            case '*' -> firstNum * secondNum;
            case '/' -> firstNum / secondNum;
            default -> {
                System.out.println("Операція не розпізнана, повторіть операцію.");
                yield calculate(firstNum, getOperation(), secondNum);
            }
        };
    }

}