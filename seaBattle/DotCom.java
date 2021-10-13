package seaBattle;
import java.util.ArrayList;

public class DotCom {
	
	private ArrayList<String>locationCells;
	private String name;
	
	
	public void setLocationCells(ArrayList<String> locs) {
		locationCells=locs;
	}
	
	public String checkYourself(String userInput) {
		String result="Мимо";                       //Проверяем содержится ли загаданная 
		int index=locationCells.indexOf(userInput); //пользователем ячейка внутри ArrayList,
		if(index>=0) {                              //запрашивая ее индекс.Если ее нет -метод
		   locationCells.remove(index);             //indexOf вернет -1
		   if(locationCells.isEmpty()) {            //remove удаляет угаданую ячейку
			 result="Потопил";
		   }else {
		     result="Попал";                                       
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
