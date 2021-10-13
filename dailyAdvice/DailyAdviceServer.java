package dailyAdvice;

import java.io.*;
import java.net.*;

public class DailyAdviceServer {
	
	String[] adviceList= {"выпить холодненького-ты заслужил","сказать Коробецкой, что она Коробяка","свалить  с работы пораньше",
			"забить на все","хлопнуть коньячку, сейчас же"};
	
	public void go() {
		
		try {
			
			ServerSocket serverSock=new ServerSocket(4242);
			
			while(true) {
				
				Socket sock=serverSock.accept();
				PrintWriter writer=new PrintWriter(sock.getOutputStream());
				String advice=getAdvice();
				writer.println(advice);
				writer.close();
				//System.out.println(advice);
			}
			
		}catch(IOException ex) {ex.printStackTrace();
		
		}
			
		}
	public String getAdvice() {
		
		int random=(int)(Math.random()*adviceList.length);
		return adviceList[random];
	}
	

	public static void main(String[] args) {
		
		DailyAdviceServer server=new DailyAdviceServer();
		server.go();
	}

}
