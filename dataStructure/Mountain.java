package dataStructure;

public class Mountain {
	
	String name;
	int height;
	
	Mountain(String n,int h){
		name=n;
		height=h;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name+" "+height;
	}
	

	

}
