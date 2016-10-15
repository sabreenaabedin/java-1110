import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Lab11_TestingSetsAndMaps {

	public static void main(String[] args) {
		// Hash Map ----------
		HashMap<String, String> hm = new HashMap<String, String>(); // Maps have key-value pairs
		hm.put("1", "Test");
		hm.put("2", "Test");

				
		Set set = hm.keySet(); // Returns a Set view of the keys contained in this map.
		Iterator iter = set.iterator();
		
		System.out.println("Beginning HashMap output");
		while (iter.hasNext()) { // if there are more elements
			String Str = (String) iter.next(); // returns the next element
			System.out.println(hm.get(Str)); // Returns the value to which the specified key is mapped, 
											// or null if this map contains no mapping for the key.  hm.get(key)
		}
		
		
		// Hash Set  ----------
		HashSet<String> hs = new HashSet<String>();
		hs.add("Test");
		hs.add("Test"); // Will this be successful?
		hs.add("Apple");
		hs.add("Zebra");
		hs.add("Orange");
		
		Iterator<String> It = hs.iterator();
		System.out.println("Beginning HashSet output");		
		while (It.hasNext()) {
			String St = It.next();
			System.out.println(St);
		}
		
		
		// Tree Set  ----------
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("Test");
		ts.add("Test"); // Will this be successful?
		ts.add("Apple");
		
		Iterator<String> Itr = ts.iterator();
		System.out.println("Beginning TreeSet output");		
		while (Itr.hasNext()) {
			String St = Itr.next();
			System.out.println(St);
		} // notice the output is ordered (and also no duplicates)		
		
		
		// Tree Map  ----------
		TreeMap<String, String> tm = new TreeMap<String, String>();
		tm.put("3", "Apple");
		tm.put("1", "Test");
		tm.put("2", "Test"); 
		
		
		Set mySet = tm.keySet(); // Returns a Set view of the keys contained in this map.
		Iterator myIter = mySet.iterator();		
		
		System.out.println("Beginning TreeMap output");		
		while (myIter.hasNext()) {
			String St = (String) myIter.next();
			System.out.println(tm.get(St));
		} 		
		
				
//		Output:
		
//		Beginning HashMap output
//		Test
//		Test
//		Beginning HashSet output
//		Apple
//		Test
//		Zebra
//		Orange
//		Beginning TreeSet output
//		Apple
//		Test
//		Beginning TreeMap output
//		Test
//		Test
//		Apple
		
		
	}
}