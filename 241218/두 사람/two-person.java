import java.util.Scanner;

public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int f_age = sc.nextInt();
		char f_sex = sc.next().charAt(0);
		int s_age = sc.nextInt();
		char s_sex = sc.next().charAt(0);
		if((f_age >= 19 && f_sex == 'M') || (s_age >= 19 && s_sex == 'M'))
			System.out.println(1);
		else
			System.out.println(0);
			
	}
}


