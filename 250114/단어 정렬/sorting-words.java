import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n];
		for(int i=0; i<n; i++) {
			words[i] = sc.next();
		}
		Arrays.sort(words);
		for(int i=0; i<n; i++) {
			System.out.println(words[i]);
		}
		
		sc.close();
    }
}