import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int ans =0;
		for(int i=0; i<word.length()-1; i++) {
			if(word.charAt(i) == '(') {
				for(int j= i+1; j<word.length(); j++) {
					if(word.charAt(j) == ')') {
						ans++;
					}
				}
			}
			
		}
		System.out.println(ans);
		
		sc.close();
    }
}
