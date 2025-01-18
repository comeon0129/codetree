import java.util.Scanner;
import java.util.Arrays;


public class Main {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String t = sc.next();
		String[] words = new String[n];
		String[] tWords= new String[n];
		for(int i=0; i<n; i++) {
			words[i] = sc.next();
		}
		
	    int idx= 0;
		for(int i=0; i<n; i++) {
			if(words[i].indexOf(t)==0) {
				tWords[idx] = words[i];
				idx++;
			}
		}
		Arrays.sort(tWords,0,idx);
		System.out.println(tWords[k-1]);
		sc.close();
    }
}
