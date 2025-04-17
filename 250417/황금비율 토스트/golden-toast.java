import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Main {
	
	public static int n,m; // n: 식빵의 개수 m: 암호문의 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		String bread = sc.next();
		String[] breadArr = bread.split("");
		ArrayList<String> l = new ArrayList<>(Arrays.asList(breadArr));
		ListIterator<String> it = l.listIterator();
		while(it.hasNext())
			it.next();
		while(m-->0) {
			char c = sc.next().charAt(0);
			if(c=='L') {
				if(it.hasPrevious()) {
					it.previous();
					System.out.println(it.nextIndex());
				}
			}
			else if(c=='R') {
				if(it.hasNext()) {
					it.next();
					System.out.println(it.nextIndex());
				}
			}
			else if(c=='D') {
				if(it.hasNext()) {
					it.next();
					it.remove();
				}
			}
			else if(c=='P') {
				String s = sc.next();
				it.add(s);
				System.out.println(it.nextIndex());
			}
		}
		for(int i=0; i<l.size(); i++) {
			System.out.print(l.get(i));
		}
		
		sc.close();
    }
}
