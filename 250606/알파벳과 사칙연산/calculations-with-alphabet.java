import java.util.Scanner;

public class Main {
	public static int[] value;
	public static String s;
	
	public static int maxResult = Integer.MIN_VALUE;
	
	public static int calcResult() {
		int[] alphabet = new int[128];
		
		alphabet['a'] = value[0];
		alphabet['b'] = value[1];
		alphabet['c'] = value[2];
		alphabet['d'] = value[3];
		alphabet['e'] = value[4];
		alphabet['f'] = value[5];
		
		int result = alphabet[s.charAt(0)];
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '+') {
				result += alphabet[s.charAt(i+1)];
			}
			else if(s.charAt(i) == '-') {
				result -= alphabet[s.charAt(i+1)];
			}
			else if(s.charAt(i) == '*') {
				result *= alphabet[s.charAt(i+1)];
			}
		}
		
		return result;
	}
	
	public static void chooseValue(int cnt) {
		if(cnt == 6) {
			maxResult = Math.max(maxResult, calcResult());
			return;
		}
		
		for(int i=1; i<=4; i++) {
			value[cnt] = i;
			chooseValue(cnt+1);
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		value = new int[6];
		
		s = sc.next();
		
		chooseValue(0);
		
		System.out.println(maxResult);
		sc.close();
	}
}