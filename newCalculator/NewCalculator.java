package newCalculator;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.BorderLayout;

public class NewCalculator  {
	

		
	//Оьявляем все компоненты калькулятора


JButton button0=new JButton("0");
JButton button1=new JButton("1");
JButton button2=new JButton("2"); 
JButton button3=new JButton("3");
JButton button4=new JButton("4");
JButton button5=new JButton("5");
JButton button6=new JButton("6");
JButton button7=new JButton("7");
JButton button8=new JButton("8");
JButton button9=new JButton("9");
JButton buttonPoint = new JButton(".");
JButton buttonDelete = new JButton("Delete");
JButton buttonEqual=new JButton("=");
JButton buttonPlus=new JButton("+");
JButton buttonMinus=new JButton("-");
JButton buttonDivide=new JButton("/");
JButton buttonMultiply=new JButton("*");

JPanel windowContent = new JPanel();

JTextField displayField = new JTextField(30);

  //Конструктор
 NewCalculator(){
   
	
	// В конструкторе создаем все компоненты
	// добавляем на фрейм с помощью комбинации
	// BorderLayout и GridLayout
		
		//Задаем схему для этой панели
		BorderLayout bl=new BorderLayout();
		windowContent.setLayout(bl);
		
		
		//Создаем и отображаем поле
		//Добавляем его в верхнюю область окна
		
		displayField = new JFormattedTextField();
		windowContent.add("North",displayField);
	    
	    //Создаем панель с GridLayout, которая содержит 12 кнопок
	    
		JPanel p1=new JPanel();
	    GridLayout gl=new GridLayout(4,3);
	    p1.setLayout(gl);
	    
	    //Добавляем кнопки на панель p1
	    p1.add(button1);
	    p1.add(button2);
	    p1.add(button3);
	    p1.add(button4);
	    p1.add(button5);
	    p1.add(button6);
	    p1.add(button7);
	    p1.add(button8);
	    p1.add(button9);
	    p1.add(button0);
	    p1.add(buttonPoint);
	    p1.add(buttonEqual);
	    //Помещаем панель р1 в центральную область окна
	    windowContent.add("Center",p1);
	    
	 // Создаем панель с менеджером расположения GridLayout
	 // на которой будет4 кнопки -// Плюс, Минус, Разделить и Умножить
	    
	    JPanel p2=new JPanel();
	    GridLayout gl2=new GridLayout(4,1);
	    p2.setLayout(gl2);
	    p2.add(buttonPlus);
	    p2.add(buttonMinus);
	    p2.add(buttonMultiply);
	    p2.add(buttonDivide);
	    
	    windowContent.add("East",p2);
	   
	    JPanel p3=new JPanel();
	    GridLayout gl3=new GridLayout(1,4);
	    p3.setLayout(gl3);
	    p3.add(buttonDelete);

	    
	    windowContent.add("South",p3);
	    
	    
	    //Создаем фрейм и задаем его основную панель
	    JFrame frame=new JFrame("Calculator");
	    frame.setContentPane(windowContent);
	    
	    //Делаем размер окна достаточным, для того чтобы вместить все его компоненты
	    frame.pack();
	    
	    //Делаем окно видимым
	    frame.setVisible(true);
	    
	    
	    // Создаем экземпляр слушателя событий и
	    // регистрируем его в каждой кнопке
	    
	    CalculatorEngine calcEngine = new CalculatorEngine(this);

      
	    button0.addActionListener(calcEngine);
	    button1.addActionListener(calcEngine);
	    button2.addActionListener(calcEngine);
	    button3.addActionListener(calcEngine);
	    button4.addActionListener(calcEngine);
	    button5.addActionListener(calcEngine);
	    button6.addActionListener(calcEngine);
	    button7.addActionListener(calcEngine);
	    button8.addActionListener(calcEngine);
	    button9.addActionListener(calcEngine);
	    buttonDelete.addActionListener(calcEngine);
	    buttonPlus.addActionListener(calcEngine);
	    buttonMinus.addActionListener(calcEngine);
	    buttonDivide.addActionListener(calcEngine);
	    buttonMultiply.addActionListener(calcEngine);
	    buttonEqual.addActionListener(calcEngine);
	    buttonPoint.addActionListener(calcEngine);
		 }
 
public static void main(String[] args) {
	// Создаем экземпляр класса“Калькулятор”
	NewCalculator calc = new NewCalculator();
}
}
	


