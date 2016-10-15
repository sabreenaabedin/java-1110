import java.util.ArrayList;


public class UniqueArrayList extends ArrayList<String> {

	@Override
	public boolean add(String o) {
		if (!this.contains(o)) {
			super.add(o);
			return true;
		} else {
			return false;
		}
	}
	
	// You also would need to Override .remove()
	
	public static void main(String[] args) {

	}

}
