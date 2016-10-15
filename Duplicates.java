import java.util.HashSet;
import java.util.Set;


public class Duplicates {
	public static void main(String[] args) {
		String str[] = { "I", "Came", "I", "Saw", "I", "Conquered" }; 
		System.out.println("Size of str (number of words): " + str.length);

		// Create two sets
		Set<String> uniques = new HashSet<String>();
		Set<String> dups = new HashSet<String>();
		
		// For every string in "str" try to add it to the set "uniques"
		for (int i = 0; i < str.length; i++) {
			if(!uniques.add(str[i])) // if cannot add that word to uniques (means it already exists there)
				dups.add(str[i]);
		}
		
		// Destructive set-difference
		uniques.removeAll(dups); // remove words from uniques that show up in dups

		System.out.println("Size of the HashSet dups: " + dups.size());

		System.out.println("Unique words: " + uniques);
		System.out.println("Duplicate words: " + dups);
		
	}
}