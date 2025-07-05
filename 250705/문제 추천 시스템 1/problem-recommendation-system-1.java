import java.util.Scanner;
import java.util.TreeSet;

class Problem implements Comparable<Problem>{
	int number, difficulty;
	
	public Problem(int number, int difficulty) {
		this.number = number;
		this.difficulty = difficulty;
	}
	
	@Override
	public int compareTo(Problem o) {
		if(this.difficulty > o.difficulty) {
			return 1;
		}
		else if(this.difficulty == o.difficulty) {
			return this.number-o.number;
		}
		else
			return -1;
	}
	
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       
        TreeSet<Problem> s = new TreeSet<>();
        
        while(n-->0) {
        	int number = sc.nextInt();
        	int difficulty = sc.nextInt();
        	s.add(new Problem(number, difficulty));
        }
        
        int m = sc.nextInt();
        
        while(m-->0) {
        	String command = sc.next();
        	
        	if(command.equals("ad")) {
        		int number = sc.nextInt();
        		int difficulty = sc.nextInt();
        		s.add(new Problem(number, difficulty));
        	}
        	
        	else if(command.equals("sv")) {
        		int number = sc.nextInt();
        		int difficulty = sc.nextInt();
        		s.remove(new Problem(number, difficulty));
        	}
        	
        	else if(command.equals("rc")) {
        		int x = sc.nextInt();
        		
        		if(x== 1) {
        			System.out.println(s.last().number);
        		}
        		
        		else if(x== -1) {
        			
        			System.out.println(s.first().number);
        		}
        	}
        }
       
        sc.close();
    }
}