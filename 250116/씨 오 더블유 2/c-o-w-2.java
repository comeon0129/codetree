import java.util.Scanner;

public class Main {
	
//	public static final int MAX_N = 100;
//	public static int n;
//	public static char[] sentence= new char[MAX_N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		String s = sc.next();
		int cnt =0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='C') {
				for(int j=i+1; j<s.length(); j++) {
					if(s.charAt(j)=='O') {
						for(int k=j+1; k<s.length(); k++) {
							if(s.charAt(k) == 'W') {
								cnt++;
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
		
		
		
		sc.close();
    }
}