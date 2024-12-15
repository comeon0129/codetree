import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       sc.useDelimiter(":");
       int hour = sc.nextInt();
       int minute = sc.nextInt();
       System.out.println((hour+1)+":"+minute);
    }
}
