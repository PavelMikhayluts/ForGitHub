package chatClient;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.util.*;

public class SimpleChatClient {
	
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;

	public static void main(String[] args) {
		
		SimpleChatClient client=new SimpleChatClient();
		client.go();
	}
	
	public void go() {
		
		JFrame frame=new JFrame("??????? ??? ??????");
		JPanel mainPanel=new JPanel();
		incoming=new JTextArea(15,30);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller=new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		outgoing=new JTextField(20);
		JButton sendButton=new JButton("?????????");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(qScroller);
		mainPanel.add(sendButton);
		mainPanel.add(outgoing);
		
		setUpNetworking();
		
		Thread readerThread=new Thread(new IncomingReader());
		readerThread.start();
		
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
	
	public void setUpNetworking(){
		
		try {
			sock=new Socket("127.0.0.1",5000);
			InputStreamReader streamReader=new InputStreamReader(sock.getInputStream());
			reader=new BufferedReader(streamReader);
			writer=new PrintWriter(sock.getOutputStream());
			System.out.println("??????? ?????????? ???????????");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
   public class  SendButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		
		try {
			writer.println(outgoing.getText());
			writer.flush();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		outgoing.setText(" ");
		outgoing.requestFocus();
		} 
   }
   
   public class IncomingReader implements Runnable{

	
	public void run() {
		
		String message;
		
		try {
			
			while((message=reader.readLine())!=null) {
				System.out.println("????? "+message);
				incoming.append(message+"\n");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	}
   
   
	

}
