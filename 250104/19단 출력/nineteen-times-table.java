import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();	
		
		for(int i=1; i<=19; i++) {
			for(int j=1; j<=19; j++) {
				System.out.print(i+" * "+j+" = "+i*j);
				
				if(j==19) {
					System.out.println();
					break;
				}
				if(j % 2 == 0) {
					System.out.println();
				}
				else {
					System.out.print(" / ");
				}
			}
		}
			
		sc.close();
	}
		
}
