
public class Student extends Person {

	private String campusAddress;
	private double gpa;
	public Student(String name, String address, String campusAddress) {
		super(name, address);
		this.campusAddress = campusAddress;
		gpa = 0.0;
	}
	@Override
	public String toString() {
		return "{Student: campusAddress=" + campusAddress + ", gpa=" + gpa
				+ ", name=" + name + ", homeAddress=" + homeAddress + "}";
	}
	
	
}
