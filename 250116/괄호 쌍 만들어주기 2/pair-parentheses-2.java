import java.util.Scanner;

public class Main {
	
//	public static final int MAX_N = 100;
//	public static int n;
//	public static char[] sentence= new char[MAX_N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int cnt =0;
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i)=='('&& s.charAt(i+1) == '(') {
				for(int j=i+2; j<s.length()-1; j++) {
					if(s.charAt(j)==')' && s.charAt(j+1)==')') {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		
		
		
		sc.close();
    }
}
