import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreesAndMaps {

	
	
	
	
	public static void main(String[] args) {
		
		TreeMap<String, Integer> phoneBook = new TreeMap<String, Integer>();
		
		phoneBook.put("Jones", 1234567); 
		phoneBook.put("Patrick", 5345467); 
		phoneBook.put("Sabreena", 7539685); 
		
		
		Set mySet = phoneBook.keySet(); // Returns a Set view of the keys contained in this map.
		Iterator myIter = mySet.iterator();		
		
		TreeMap<Integer, String> numberLookup = new TreeMap<Integer, String>();
		
		System.out.println("Beginning TreeMap output");		
		
		while (myIter.hasNext()) {
			String St = (String) myIter.next();
			System.out.println(phoneBook.get(St));
			
			numberLookup.put(phoneBook.get(St),St);
		 
		
		} 
		//testing
		Set mySet2 = numberLookup.keySet(); // Returns a Set view of the keys contained in this map.
		Iterator myIter2 = mySet2.iterator();		
		while(myIter2.hasNext()){
			Integer St = (Integer) myIter2.next();
			System.out.println(numberLookup.get(St));
		}
//		Integer value = phoneBook.values().toArray();
//		String key = phoneBook.keySet().toArray();
//		numberLookup.put((Integer) value, (String) key);
	}

}
