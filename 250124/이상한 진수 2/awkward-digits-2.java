import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String binary = sc.next();
		char[] copy = binary.toCharArray();
		int len = copy.length;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<len; i++) {
			if(copy[i] == '0') {
				copy[i] = '1';
			}
			else {
				copy[i] = '0';
			}
			String s = String.valueOf(copy);
			int number = Integer.parseInt(s,2);
			max = Math.max(max, number);
			copy = binary.toCharArray();
		}
		System.out.println(max);
		sc.close();
    }
}