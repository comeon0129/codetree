import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[] pos = new int[3];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			pos[i] = sc.nextInt();
		}
		Arrays.sort(pos);
		if(pos[1]-pos[0] == 1 && pos[2]-pos[1] == 1) {
			System.out.println(0);
		}
		else if(pos[1]-pos[0] == 2 || pos[2]-pos[1] == 2) {
			System.out.println(1);
		}
		else {
			System.out.println(2);
		}
		
		
		sc.close();
    }
}