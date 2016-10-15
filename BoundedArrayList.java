import java.util.ArrayList;


public class BoundedArrayList extends ArrayList<String>{
	
	private int i;
	
	
	public BoundedArrayList(int i) {
		this.i = i;
	}
	
	
	@Override
	public boolean add(String o) {
		if (this.size() < this.i ) {
			super.add(o);
			return true;
		} else {
			return false;
		}
	}

	
	public static void main(String[] args) {

	}

}
