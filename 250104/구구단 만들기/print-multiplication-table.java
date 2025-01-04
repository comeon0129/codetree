import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();	
		int b = sc.nextInt();	
			
		for(int i=1; i<=9; i++) {
			for(int j=0; j<b/a; j++) {
					System.out.print(b-2*j+" * "+ i +" = "+(b-2*j)*i);
					if(j<b/a-1)
						System.out.print(" / ");
			}
			System.out.println();
		}
			
		sc.close();
	}
		
}
