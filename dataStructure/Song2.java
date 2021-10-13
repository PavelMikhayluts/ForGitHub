package dataStructure;

public class Song2 {
	
	String title;
	String artist;
	String rating;
	String bpm;
	int c=1;
	
	Song2(String t,String a,String r,String b){
		title=t;
		artist=a;
		rating=r;
		bpm=b;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getRating() {
		return rating;
	}
	
	public String getBpm() {
		return bpm;
	}
	
	public String toString() {
		new JukeBox2();
		if(JukeBox2.flag>0) {
		return artist;
		}else {
			return title;}
		
		}
		
		
	
	}
	
	//public String toString1() {
	//	return artist;
	//}
	
	//public int compareTo(Song2 s) {
	//	return title.compareTo(s.getTitle());
	//}
	


