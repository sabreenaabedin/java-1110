
/** Sabreena Abedin (sa7cx): lab 102 and Kathryn Murray (kam4rc): lab 100  Homework 2  **/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PlayList{

	private String name;
	private ArrayList<Playable> playableList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Playable> getplayableList() {
		return playableList;
	}

	public void setplayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

	public PlayList() {
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>();

	}

	public PlayList(String newName) {
		this.name = newName;
		this.playableList = new ArrayList<Playable>();
	}

	public boolean loadSongs(
			String fileName) { /**
								 * loops through the text file and pulls the
								 * title, artist, and time one by one. the get
								 * seconds method deals with different times
								 **/

		try {
			Scanner textReader = new Scanner(new File(fileName));
			while (textReader.hasNextLine()) {
				String title = textReader.nextLine().trim();
				String artist = textReader.nextLine().trim();
				String time = textReader.nextLine().trim();
				String min = time.substring(0, time.indexOf(":"));
				String sec = time.substring(time.indexOf(":") + 1, time.length());
				int minutes = Integer.parseInt(min);
				int seconds = Integer.parseInt(sec);
				if (seconds > 59) {
					minutes += seconds / 60;
					seconds = seconds % 60;
				}
				textReader.nextLine();
				Song s = new Song(title, artist, minutes, seconds);
				addSong(s);

			}
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (NoSuchElementException e) {
			System.out.println(e.toString());
		}

		return true;

	}

	public boolean clear() { /**
								 * replaces song list with a null array to
								 * remove all songs
								 **/
		if (this.playableList.size() == 0) {
			return false;
		} else {
			for (int i = 0; i < this.playableList.size(); i++) {
				this.playableList.remove(i);
			}
			return true;
		}

	}

	public boolean addSong(
			Song s) { /** adds the song given to end of play list **/
		playableList.add(s);
		return true;
	}

	// public Song removeSong(
	// int index) { /** finds song at index given and removes it **/
	// Song answer = playableList.get(index);
	// if (!(index < 0)) {
	// playableList.remove(index);
	// return answer;
	// }
	// return null;
	//
	// }
	//
	// public Song removeSong(
	// Song s) { /**
	// * finds the index of song s and removes the song at
	// * that index and returns the removed song
	// **/
	// while (playableList.contains(s)) {
	// int index = playableList.indexOf(s);
	// if (index >= 0) {
	// Song answer = playableList.get(index);
	// playableList.remove(index);
	// return answer;
	// }
	// }
	// return null;
	// }

	public Playable getPlayable(
			int index) { /** returns song at the index given **/
		if (playableList.size() < 0) {
			return null;
		} else if (index < 0 || index >= playableList.size()) {
			return null;
		}

		else {
			Playable answer = playableList.get(index);
			return answer;
		}

	}

	public void play() { /**
							 * loops through the entire playlist and calls play
							 * on each song
							 **/
		for (int i = 0; i < playableList.size() - 1; i++) {
			playableList.get(i).play();
		}
	}

	public int size() { /**
						 * returns the size of the play list by counting number
						 * of entries
						 **/
		int size = playableList.size();
		return size;

	}

	public boolean addPlayList(PlayList pl) {
		if (this.playableList.contains(pl)) {
			return false;
		}
		this.playableList.add((Playable) pl);
		return true;
	}

	public static void main(String[] args) {
		PlayList p = new PlayList();
		p.loadSongs("test.txt");

	}

	public String toString() {
		String contents = "";

		for (int i = 0; i < playableList.size(); i++) {
			contents += playableList.get(i).toString();

		}
		return "Name: " + name + "Contents: " + contents;

	}
	
	public ArrayList<Playable> sortByName(){
		return null;
		
//	Collections.sort((List<T>) playableList);
		
	//finish this
		
	}
	
	public ArrayList<Playable> sortByTime(){
		return null;
		
		//finish this
	}

}