import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

  public static void main(String args[]) { 
     int count[] = {34,22,10,60,30,22,75};
     Set<Integer> set = new HashSet<Integer>();
     System.out.println("Size of count array: " + count.length);
     
     try{
    	// Take each element in "count" and try to add it to "set" 
        for(int i = 0; i<count.length; i++){
           set.add(count[i]); 
        }
        System.out.println("Size of the HashSet set: " + set.size());
        System.out.println(set); //printing out "set" which is a HashSet
  
        TreeSet sortedSet = new TreeSet<Integer>(set); // place the contents of "set" into "sortedSet" (a TreeSet)
        System.out.println("The sorted list is:");
        System.out.println(sortedSet); // Printing the list in sorted order because of TreeSet properties

        System.out.println("The First element of the set is: " + (Integer)sortedSet.first());
        System.out.println("The last element of the set is: " +  (Integer)sortedSet.last());
     }
     catch(Exception e){}
  }
} 

/*Example output from a run of SetDemo:
	
	Size of count array: 7
	Size of the HashSet set: 6
	[34, 22, 10, 75, 30, 60]
	The sorted list is:
	[10, 22, 30, 34, 60, 75]
	The First element of the set is: 10
	The last element of the set is: 75*/
