package seaBattle;
import java.util.*;

public class DotComBust {
	
	//Обьявляем и инициализируем переменные
	private GameHelper helper=new GameHelper();                  
	private ArrayList<DotCom> dotComList=new ArrayList<DotCom>();
	private int numOfGuesses=0;
	
	private void setUpGame() {
    //Создадим 3 кораблика и присвоим им адреса
	//Cоздадим 3 объекта DotCom присвоим им имена и поместим их в Array List
		DotCom one=new DotCom();
		one.setName("Аврора");
		DotCom two=new DotCom();
		two.setName("Варяг");
		DotCom three=new DotCom();
		three.setName("Потемкин");
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
	//Выводим краткие инструкции для пользователя
		System.out.println("Ваша цель - потопить 3 кораблика.");
		System.out.println("Аврора,Варяг,Потемкин. Каждый кораблик состоит из трех клеток. ");
		System.out.println("Попытайтесь их потопить за минимальное количество ходов.");
		
		
		
		//поочередно вызываем обьекты из dotComList и связываем их с dotComToSet
		for(DotCom dotComToSet:dotComList) {
			
			//Запрашиваем у вспомогательного обьекта helper адрес кораблика
			ArrayList<String> newLocation=helper.placeDotCom(3);
			
			//Вызываем сеттер из обьекта DotCom, чтобы передать ему местоположение полученное
			//из вспомогательного обьекта.
			dotComToSet.setLocationCells(newLocation);
			}
		}
	
	private void startPlaying() {
		
		//До тех пор пока список обьектов DotCom не станет пустым
		while(!dotComList.isEmpty()) {
			
			//получаем пользовательский ввод
			String userGuess=helper.getUserInput("Сделайте ход.");
			
			//Вызываем метод checkUserGuess
			checkUserGuess(userGuess);
			}
		
		//Вызываем метод finishGame
		finishGame();
		}
	
	private void checkUserGuess(String userGuess) {
		
		//ИНкрементируем кол во попыток, которые сделал пользователь
		numOfGuesses++;
		
		//Подразумеваем промах, пока не выяснили обратное
		String result="Мимо";
		DotCom ship=new DotCom();
		
		
		//Повторяем для всех объектов DotCom в списке
		for(DotCom dotComToTest:dotComList) {
			
			//Просим DotCom проверить ход пользователя, ищем попадание или потопление
			result=dotComToTest.checkYourself(userGuess);
		    //ship=dotComToTest;
			
			if(result.equals("Попал")) {
				break;// выбираемся из цикла,нет смысла проверять другие кораблики
			}
			if(result.equals("Потопил")) {
				dotComList.remove(dotComToTest);
				break;
			}
			
		}
		System.out.println(" ");
		System.out.println(result+" Ваш следующий ход");//+" "+ship.getName());
		//Ему пришел конец, так что удаляем его из списка корабликов
		//и завершаем цикл
		
	}
	
	private void finishGame(){
		
		//Выводим результат для пользователя
		System.out.println("Вся вражеская эскадра пошла на дно! ПОБЕДА!!!");
		System.out.println("");
		if(numOfGuesses<=18) {
			System.out.println("Вам потребовалось всего "+numOfGuesses+" попыток"); 
			System.out.println("чтобы отправить вражеские корабли на корм рыбам");
		}else {
			System.out.println("Вам потребовалось аж "+numOfGuesses+" попыток.");
			System.out.println("Ваши враги успели заскучать!");
		}
	}
	
    public static void main(String[] args) {
	
    	//Создаем игровой обьект
    	DotComBust game=new DotComBust();	
    	
    	//Подготовка игры
    	game.setUpGame();
    	
    	//Начинаем главный игровой цикл: запрашиваем пользовательский ввод и
    	//сравниваем полученные данные
    	game.startPlaying();
		
	}

}
