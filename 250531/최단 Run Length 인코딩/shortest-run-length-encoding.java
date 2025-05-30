import java.util.Scanner;


public class Main {
	public static String sentence;
	public static int minLen = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sentence = sc.next();
		int n = sentence.length();
		char[] s = sentence.toCharArray();
 		
		for(int i=0; i<n; i++) {
			char temp = s[n-1];
			for(int j= n-1; j>=1; j--) {
				s[j] = s[j-1];
			}
			s[0] = temp;
			
			int length = 1;
			
			for(int j=0; j<n-1; j++) {
				if(s[j] != s[j+1]) {
					length++;
				}
			}
			if(length == 1)//모든 알파벳이 같은경우
				minLen = Math.min(minLen, 3);
			else
				minLen = Math.min(minLen, 2*length);
		}
		
		System.out.println(minLen);
		
		
		sc.close();
	}
}
