import java.util.ArrayList;

public class Course {

	private String id;
	private String name;
	private ArrayList<Student> roll = new ArrayList<Student>();

	public Course(String id, String name) {
		this.id = id;
		this.name = name;
		if (id.equals("") || name == null)
			throw new IllegalArgumentException("Error: ID field empty.");
		if (name.equals("") || name == null)
			throw new IllegalArgumentException("Error: Name field empty.");
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Student> getRoll() {
		return roll;
	}

	public void setRoll(ArrayList<Student> roll) {
		this.roll = roll;
	}

	public boolean add(Student aStudent) {
		if (!roll.contains(aStudent)) {
			roll.add(aStudent);
			return true;
		}
		return false;

	}

	public boolean drop(Student student) {
		if (roll.contains(student)) {
			roll.remove(student);
			return true;
		}
		return false;
	}

	public void cancel() {

		roll = null;
	}

	public double averageGPA() {
		double average = 0.0;
		if (roll.size() < 1) {
			return -1;
		}
		for (int i = 0; i < roll.size(); i++) {

			average += roll.get(i).getGpa();
		}

		return average / roll.size();

	}

	public String toString() {

		return "Name: " + name + " ID: " + id + " Roll: " + roll;
	}

	public static void main(String[] args) {
		Student B = new Student("nameA", 3.0);
		Student C = new Student("name1");
		Student D = new Student("nameB", 4.0);
		Course courseA = new Course("id", "name");
		Course courseB = new Course("2110", "cs");
		Course courseC = new Course("1620", "engr");
		courseB.add(B);
		courseB.add(C);
		courseB.add(D);
		System.out.println(courseB.averageGPA());
		System.out.println(courseB.getId() + courseB.getName() + courseB.getRoll());
		System.out.println(courseB);
		courseB.drop(B);
		System.out.println(courseB);
		courseB.cancel();
		System.out.println(courseB);
	}

}
