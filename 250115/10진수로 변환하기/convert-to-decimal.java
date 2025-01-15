import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] binary = s.toCharArray();
		int num = 0;
		for(int i=0; i<s.length(); i++) {
			num = num * 2 + (binary[i]-'0');
		}
		System.out.println(num);
		sc.close();
    }
}
