
public class Song implements Comparable, Playable {

	private String artist;
	private String title;
	private int minutes;
	private int seconds;

	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
		this.minutes = 0;
		this.seconds = 0;
	}

	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		if (seconds >= 60) {
			minutes += seconds / 60;
			seconds = seconds % 60;
		}
		return seconds;

	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
		if (seconds >= 60) {
			minutes += seconds / 60;
			seconds = seconds % 60;
		}
	}

	public Song(Song s) {

	}

	public boolean equals(
			Object o) { /**
						 * checks that the object is a song, if it is it checks
						 * that all of the fields are equivalent to the given
						 * song
						 **/
		boolean answer = false;
		if (o instanceof Song) {
			if (this.artist.equals(((Song) o).getArtist()) && this.title.equals(((Song) o).getTitle())) {
				if (this.minutes == ((Song) o).getMinutes() && this.seconds == ((Song) o).getSeconds()) {
					answer = true;
				}
			}
		}

		return answer;
	}

	public String toString() { /** prints the expected output **/
		return "{Song: title=" + title + " artist=" + artist + " mintutes=" + minutes + " seconds=" + seconds + " }";

	}

	public void play() { /** prints expected output **/
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	}

	public static void main(String[] args) {

	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return this.title;
	}

	public int getPlayTimeSeconds() {
		return seconds;
	}
}
