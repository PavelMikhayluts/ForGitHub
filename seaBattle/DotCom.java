package seaBattle;
import java.util.ArrayList;

public class DotCom {
	
	private ArrayList<String>locationCells;
	private String name;
	
	
	public void setLocationCells(ArrayList<String> locs) {
		locationCells=locs;
	}
	
	public String checkYourself(String userInput) {
		String result="����";                       //��������� ���������� �� ���������� 
		int index=locationCells.indexOf(userInput); //������������� ������ ������ ArrayList,
		if(index>=0) {                              //���������� �� ������.���� �� ��� -�����
		   locationCells.remove(index);             //indexOf ������ -1
		   if(locationCells.isEmpty()) {            //remove ������� �������� ������
			 result="�������";
		   }else {
		     result="�����";                                       
		   }
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	

}
