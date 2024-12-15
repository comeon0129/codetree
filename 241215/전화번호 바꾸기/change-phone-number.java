import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        // 변수 선언 및 입력
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 출력
        System.out.println("010" + "-" + c + "-" + b);
    }
}