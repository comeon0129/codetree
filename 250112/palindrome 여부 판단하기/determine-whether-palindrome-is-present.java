import java.util.Scanner;


public class Main {
	public static boolean test(String s) {
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		if(test(a)) {
			System.out.println("Yes");
		}
		else
			System.out.println("No");
		
		sc.close();
    }
}