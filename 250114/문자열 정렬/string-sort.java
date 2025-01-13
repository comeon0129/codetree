import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s =sc.next();
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		s = String.valueOf(arr);
		System.out.println(s);
		
		
		
		sc.close();
    }
}