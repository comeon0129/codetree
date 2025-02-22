import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ArrayList<Integer> v = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String command = sc.next();
			if(command.equals("push_back")) {
				int value = sc.nextInt();
				v.add(value);
			}
			else if(command.equals("pop_back"))
				v.remove(v.size()-1);
			else if(command.equals("size"))
				System.out.println(v.size());
			else {
				int getIdx = sc.nextInt();
				System.out.println(v.get(getIdx-1));
			}
		}
		
		
		sc.close();
    }
}