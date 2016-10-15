import java.util.ArrayList;
import java.util.Collections;


public class Student implements Comparable<Student> {
	
	private String last;
	private String first;
	private double gpa;
	
	public String getLast() {
		return this.last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getFirst() {
		return this.first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public double getGpa() {
		return this.gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public Student(String last, String first, double gpa) {
		this.last = last;
		this.first = first;
		this.gpa = gpa;
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.gpa < o.gpa) {
			return 1;
		} else if(this.gpa > o.gpa) {
			return -1;
		} else {
			return this.last.compareTo(o.last);
				
		}
	}
	
	public String toString() {
		return this.last + "," + this.first + "," + this.gpa;
	}
	
	public static void main(String[] args) {
		Student a = new Student("zabedin", "sabreena", 4.0);
		Student b = new Student("dunoyer", "edward", 3.1);
		Student c = new Student("jefferson", "thomas", 4.0);
		Student d = new Student("bennett", "tony", 3.9);
		
		ArrayList<Student> honorRoll = new ArrayList<Student>();
		honorRoll.add(a);
		honorRoll.add(b);
		honorRoll.add(c);
		honorRoll.add(d);
		System.out.println(honorRoll);
		Collections.sort(honorRoll);
		System.out.println(honorRoll);
	}
	
	
}
