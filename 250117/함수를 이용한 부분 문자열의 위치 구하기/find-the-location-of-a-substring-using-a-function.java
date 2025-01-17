import java.util.Scanner;

public class Main {
	
	public static String input, target;
	
	public static int answer(String input, String target) {
		return input.indexOf(target);
	}
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        input =sc.next();
        target = sc.next();
        System.out.println(answer(input,target));
        
       
        sc.close();
    }
}