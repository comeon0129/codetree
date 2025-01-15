import java.util.Scanner;
import java.util.Arrays;

class Student implements Comparable<Student> {
	String name;
	int height;
	int weight;
	
	public Student(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	@Override
	public int compareTo(Student o) {
		if(this.height == o.height) {
			return o.weight - this.weight;
		}
		return this.height - o.height ;
	}
	
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Student[] students = new Student[n];
		for(int i=0; i<n; i++) {
			String name = sc.next();
			int height = sc.nextInt();
			int weight = sc.nextInt();
			students[i] = new Student(name, height, weight);
		}
		Arrays.sort(students);
		
		for(int i=0; i<n; i++) {
			System.out.print(students[i].name+" ");
			System.out.print(students[i].height+" ");
			System.out.println(students[i].weight+" ");
		}
		
		sc.close();
    }
}