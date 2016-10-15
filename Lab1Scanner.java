import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab1Scanner {

	public static void main(String[] args) throws FileNotFoundException {

//		 Scanner input = new Scanner(System.in);
//		 while (input.hasNextLine()) {
//		 if (input.nextLine() instanceof double){
//			 System.out.print(input.Double()); 
//		 }else if (input.nextLine() instanceof String){
//			 System.out.print(input.next());}
//		 else{
//			 
//		 }
//		 
//		 }

		File file = new File("data1.txt");
		Scanner textReader = new Scanner(file);
		
		System.out.print(file.length());
		System.out.print(file.getAbsolutePath());

	}
}
