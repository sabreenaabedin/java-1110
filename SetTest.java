
// Filename: SetTest.java
// Description: Using a HashSet to remove duplicates & report on
//              number of unique colors

// Java core packages
import java.util.*;

public class SetTest {
   private String colors[] = { "red", "white", "yellow", "blue",
      "green", "gray", "orange", "tan", "white", "cyan",
      "peach", "gray", "orange", "purple", "cyan" };
                  
   // create and output ArrayList
   public SetTest()
   {
      ArrayList myColorList = new ArrayList( Arrays.asList( colors ) );
      System.out.println("Original ArrayList: " + myColorList);
      printNonDuplicatesAndSize(myColorList);
   }

   // create set from array to eliminate duplicates
   public void printNonDuplicatesAndSize( Collection collection )
   {
      // create a HashSet and obtain its iterator
      HashSet mySet = new HashSet( collection );   
      Iterator iterator = mySet.iterator(); 

      System.out.println("\nNonduplicates are: ");
      
      // iterate and print
      while ( iterator.hasNext() )
      System.out.print( iterator.next() + " ");
      System.out.println(); // new line after printing list of unique colors
	  System.out.println("Size of unique colors: "+ mySet.size());	  
   }

   // execute application
   public static void main( String args[] )
   {
      new SetTest();
   }   
                                        
}  // end class SetTest