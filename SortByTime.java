import java.util.Comparator;


public class SortByTime implements Comparator<Playable> {
		
	@Override
	public int compare(Playable arg0, Playable arg1) {  /** compares seconds by subtraction**/
		return  
				arg0.getPlayTimeSeconds() - arg1.getPlayTimeSeconds();
	}


}
