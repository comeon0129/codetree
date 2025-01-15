import java.util.Scanner;
import java.util.Arrays;

class Person implements Comparable<Person>{
	String name;
	int kor;
	int eng;
	int math;
	
	public Person(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public int compareTo(Person p) {
		return (this.kor+this.eng+this.math) - (p.kor+p.eng+p.math);
	}
	
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		Person[] people = new Person[n];
		for(int i=0; i<n; i++) {
			String name =sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();
			people[i] = new Person(name,kor,eng,math);
		}
		Arrays.sort(people);
		for(int i=0; i<n; i++) {
			System.out.println(people[i].name+" "+people[i].kor+" "+people[i].eng+" "+people[i].math);
		}
		
		sc.close();
    }
}
