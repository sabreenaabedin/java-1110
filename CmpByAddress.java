import java.util.Comparator;


public class CmpByAddress implements Comparator {
	
	
	
	public static void main(String[] args) {

	}

	@Override
	public int compare(Object a, Object b) {
		Person c = (Person) a;
		Person d = (Person) b;
	
		return c.homeAddress.compareTo(d.homeAddress);
	}

}
