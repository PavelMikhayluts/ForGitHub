package dataStructure;

import java.io.*;



public class WriteATextFile {
	
	

	public static void main(String[] args) {
		
	
		
		try {
			FileWriter writer=new FileWriter("SongList.txt");
			
		writer.write(" Pink Moon/Nick Drake/5/80 \n SomerSault/Zero 7/4/84 \n Shiva Moon/Prem Joshua/6/120 \n Circles/BT/5/110 \n Deep Channel/Headmix/4/100 \n Listen/Tahiti/2/90 ");
		
		writer.close();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		

	}

}
