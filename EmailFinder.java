// William Richardson (wgr8hd) and Sabreena Abedin (sa7cx)

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailFinder {

	public static void main(String[] args) throws Exception {
		System.out
				.print("What web page should we search for email addresses? ");
		Scanner keyboard = new Scanner(System.in);
		String URL = keyboard.next();

		URL test = new URL(URL);
		Scanner input = new Scanner(test.openStream());

		ArrayList<String> list1 = new ArrayList<String>();

		String wholePage = "";
		while (input.hasNextLine()) {
			wholePage += input.nextLine() + "\n";
		}

		wholePage = wholePage.toLowerCase();
		wholePage = wholePage.replace(" at ", "@");
		wholePage = wholePage.replace(" dot ", ".");
		wholePage = wholePage.replace("<br>", "");
		wholePage = wholePage.replace("?", "");
		wholePage = wholePage.replace("(at)", "@");
		wholePage = wholePage.replace(" (dot)", ".");
		wholePage = wholePage.replace("(dot)", ".");
		wholePage = wholePage.replace("!", "");
		wholePage = wholePage.replace("/", "");
		wholePage = wholePage.replace("\\", "");
		wholePage = wholePage.replace("'", "");
		wholePage = wholePage.replace("\"", "");
		wholePage = wholePage.replace("nospam", "");
		wholePage = wholePage.replace("href=", "");
		wholePage = wholePage.replace(">this<a>", "");
		wholePage = wholePage.replace(">", " ");
		wholePage = wholePage.replace("<a", "");
		wholePage = wholePage.replace("\n", " ");
		wholePage = wholePage.replace("_", "e");
		wholePage = wholePage.replace(",", "");

		String[] wordArray = wholePage.split(" ");

		for (int i = 0; i < wordArray.length; i++) {
			if ((wordArray[i].length() - wordArray[i].indexOf(".") >= 3)) {
				
					if (wordArray[i].indexOf(".") != wordArray[i].length() - 1) {

						if (wordArray[i].contains("@")
								&& wordArray[i].contains(".")) {

							if (wordArray[i].endsWith(".")) {
								ArrayList<String> list2 = new ArrayList<String>();
								for (int j = 0; j < wordArray[i].length(); j++) {
									list2.add(wordArray[i].charAt(j) + "");
								}

								list2.remove(list2.size() - 1);

								String listString = "";

								for (String s : list2) {
									listString += s;
								}
								wordArray[i] = listString;
							}
							String sub = wordArray[i].substring(wordArray[i].lastIndexOf("."), wordArray[i].length()-1);
							if (!sub.contains("0") && !sub.contains("1") && !sub.contains("2") && !sub.contains("3") && !sub.contains("4") && !sub.contains("5") && !sub.contains("6") && !sub.contains("7") &&!sub.contains("8") && !sub.contains("9")) {

							if (!list1.contains(wordArray[i])) {
								list1.add(wordArray[i]);
							}
						}
					}
				}
			}

		}
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("Found: <" + list1.get(i) + ">");
		}
	}

}
