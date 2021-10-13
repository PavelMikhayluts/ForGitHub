package seaBattle;
import java.util.*;

public class DotComBust {
	
	//��������� � �������������� ����������
	private GameHelper helper=new GameHelper();                  
	private ArrayList<DotCom> dotComList=new ArrayList<DotCom>();
	private int numOfGuesses=0;
	
	private void setUpGame() {
    //�������� 3 ��������� � �������� �� ������
	//C������� 3 ������� DotCom �������� �� ����� � �������� �� � Array List
		DotCom one=new DotCom();
		one.setName("������");
		DotCom two=new DotCom();
		two.setName("�����");
		DotCom three=new DotCom();
		three.setName("��������");
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
	//������� ������� ���������� ��� ������������
		System.out.println("���� ���� - �������� 3 ���������.");
		System.out.println("������,�����,��������. ������ �������� ������� �� ���� ������. ");
		System.out.println("����������� �� �������� �� ����������� ���������� �����.");
		
		
		
		//���������� �������� ������� �� dotComList � ��������� �� � dotComToSet
		for(DotCom dotComToSet:dotComList) {
			
			//����������� � ���������������� ������� helper ����� ���������
			ArrayList<String> newLocation=helper.placeDotCom(3);
			
			//�������� ������ �� ������� DotCom, ����� �������� ��� �������������� ����������
			//�� ���������������� �������.
			dotComToSet.setLocationCells(newLocation);
			}
		}
	
	private void startPlaying() {
		
		//�� ��� ��� ���� ������ �������� DotCom �� ������ ������
		while(!dotComList.isEmpty()) {
			
			//�������� ���������������� ����
			String userGuess=helper.getUserInput("�������� ���.");
			
			//�������� ����� checkUserGuess
			checkUserGuess(userGuess);
			}
		
		//�������� ����� finishGame
		finishGame();
		}
	
	private void checkUserGuess(String userGuess) {
		
		//�������������� ��� �� �������, ������� ������ ������������
		numOfGuesses++;
		
		//������������� ������, ���� �� �������� ��������
		String result="����";
		DotCom ship=new DotCom();
		
		
		//��������� ��� ���� �������� DotCom � ������
		for(DotCom dotComToTest:dotComList) {
			
			//������ DotCom ��������� ��� ������������, ���� ��������� ��� ����������
			result=dotComToTest.checkYourself(userGuess);
		    //ship=dotComToTest;
			
			if(result.equals("�����")) {
				break;// ���������� �� �����,��� ������ ��������� ������ ���������
			}
			if(result.equals("�������")) {
				dotComList.remove(dotComToTest);
				break;
			}
			
		}
		System.out.println(" ");
		System.out.println(result+" ��� ��������� ���");//+" "+ship.getName());
		//��� ������ �����, ��� ��� ������� ��� �� ������ ����������
		//� ��������� ����
		
	}
	
	private void finishGame(){
		
		//������� ��������� ��� ������������
		System.out.println("��� ��������� ������� ����� �� ���! ������!!!");
		System.out.println("");
		if(numOfGuesses<=18) {
			System.out.println("��� ������������� ����� "+numOfGuesses+" �������"); 
			System.out.println("����� ��������� ��������� ������� �� ���� �����");
		}else {
			System.out.println("��� ������������� �� "+numOfGuesses+" �������.");
			System.out.println("���� ����� ������ ���������!");
		}
	}
	
    public static void main(String[] args) {
	
    	//������� ������� ������
    	DotComBust game=new DotComBust();	
    	
    	//���������� ����
    	game.setUpGame();
    	
    	//�������� ������� ������� ����: ����������� ���������������� ���� �
    	//���������� ���������� ������
    	game.startPlaying();
		
	}

}
