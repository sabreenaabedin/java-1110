import java.util.ArrayList;

public class Lab4Driver {

	public static void main(String[] args) {
		
		ArrayList<String> list1 = new ArrayList<String>();
		 UniqueArrayList list2 = new UniqueArrayList();
		 BoundedArrayList list3 = new BoundedArrayList(4);
		
		ArrayList<String> listAlias = list1;  // change this to test each kind of list
		
		String[] hamlet = { "to", "be", "or", "not", "to", "be" };
		for (int i=0; i < hamlet.length; ++i) {
			listAlias.add( hamlet[i] );
			list2.add( hamlet[i]);
			list3.add(hamlet[i]);
		}
		
		System.out.println(listAlias);
		System.out.println(list2);
		System.out.println(list3);

	}

}