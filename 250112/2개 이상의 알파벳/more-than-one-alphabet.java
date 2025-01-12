import java.util.Scanner;

public class Main {
	public static boolean test(String s) {
		for(int i=0; i<s.length()-1; i++){
			if(s.charAt(i) != s.charAt(i+1)) {
				return true;
			}
			
		}
		return false;
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