import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        // 변수 선언 및 입력
        Scanner sc = new Scanner(System.in);
        String s= sc.next();
        String[] arr=s.split("\\.");  
        // 출력
        System.out.println(arr[1] + "-" + arr[2] + "-" + arr[0]);
    }
}