import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Введите пример для вычесления: ");
        Сalculations c = new Сalculations();
        c.resulted();
    }
}

class Сalculations {
    static Scanner scanner = new Scanner(System.in);
    static String str = scanner.nextLine();
    static String[] s = new StringBuilder(str).toString().split(" ");
    static int num1 = number1();
    static int num2 = number2();
    static char op = operation();
    static int result = calculated(num1, num2, op);

    public static int number1() {
        int num;
        if (s[0].matches("^([1-9]|1[0-0])$"))
            return num = Integer.parseInt(s[0]);
        else if (s[0].matches("X|IX|IV|V?I{0,3}")) {
            return num = RomanToArab.toArab(s[0]);
        } else
            System.out.println("Ошибка ввода");
        return 0;
    }

    public static char operation() {
        char op = s[1].charAt(0);
        return op;
    }

    public static int number2() {
        int num;
        if (s[2].matches("^([1-9]|1[0-0])$"))
            return num = Integer.parseInt(s[2]);
        else if (s[2].matches("X|IX|IV|V?I{0,3}")) {
            return num = RomanToArab.toArab(s[2]);
        } else
            System.out.println("Ошибка ввода");


        return 0;
    }

    public static int calculated(int num1, int num2, char op) {
        int result;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Оператор не найден");
                result = 0;
                break;
        }
        return result;
    }

    public void resulted() {

        if (s[0].matches("^-?\\d+$")) System.out.println(result);
        else
            System.out.println(RomanToArab.toRoman(result));

    }

    static class RomanToArab {
        public static String toRoman(int input) {
            String s = "";

            while (input == 100) {
                s += "C";
                input -= 100;
            }
            while (input >= 90) {
                s += "XC";
                input -= 90;
            }
            while (input >= 50) {
                s += "L";
                input -= 50;
            }
            while (input >= 40) {
                s += "XL";
                input -= 40;
            }
            while (input >= 10) {
                s += "X";
                input -= 10;
            }
            while (input >= 9) {
                s += "IX";
                input -= 9;
            }
            while (input >= 5) {
                s += "V";
                input -= 5;
            }
            while (input >= 4) {
                s += "IV";
                input -= 4;
            }
            while (input >= 1) {
                s += "I";
                input -= 1;
            }
            return s;
        }

        public static int toArab(String input) {
            String[] Rome = {"X", "IX", "V", "IV", "I"};
            int[] Arab = {10, 9, 5, 4, 1};
            StringBuffer romeN = new StringBuffer(input);
            int arabN = 0, i = 0;
            if (romeN.length() > 0) {
                while (true) {
                    do {
                        if (Rome[i].length() <= romeN.length()) {
                            if (Rome[i].equals(romeN.substring(0, Rome[i].length()))) {
                                arabN += Arab[i];
                                romeN.delete(0, Rome[i].length());
                                if (romeN.length() == 0)
                                    return arabN;
                            } else break;
                        } else break;
                    } while (true && romeN.length() != 0);
                    i++;
                }
            }
            return 0;
        }
    }
}