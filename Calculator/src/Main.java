import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = sc.nextInt();
        System.out.println("Введите второе число");
        int b = sc.nextInt();
        System.out.println("Ведите операцию (+,-,*,/)");
        char operation = sc.next().charAt(0);

        if (operation == '+'){
            int result = a + b;
            System.out.println("Сумма чисеел " + a + "и" + b + "равно" + result);
        }
        if (operation == '-'){
            int result = a - b;
            System.out.println("Сумма чисеел " + a + "и" + b + "равно" + result);
        }
        if (operation == '*'){
            int result = a * b;
            System.out.println("Сумма чисеел " + a + "и" + b + "равно" + result);
        }
        if (operation == '/'){
            int result = a / b;
            System.out.println("Сумма чисеел " + a + "и" + b + "равно" + result);
        }
    }
}
