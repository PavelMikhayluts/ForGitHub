package dataStructure;

import java.io.*;
import java.util.*;

public class SortMauntains {
	
	LinkedList<Mountain>mtn=new LinkedList<Mountain>();
	
	class NameCompare implements Comparator<Mountain>{
		public int compare(Mountain one,Mountain two) {
			return one.getName().compareTo(two.getName());
		}
	}
	
	class HeightCompare implements Comparator<Mountain>{
		public int compare(Mountain one,Mountain two) {
			return (two.height-one.height);
		}
		
	}

	public static void main(String[] args) {
		new SortMauntains().go();

	}
	
	public void go() {
		mtn.add(new Mountain("����������",14255));
		mtn.add(new Mountain("�������",14433));
		mtn.add(new Mountain("�����",14156));
		mtn.add(new Mountain("����",14265));
		
		System.out.println("� ������� ����������:\n"+mtn);
		
		NameCompare nc= new NameCompare();
		Collections.sort(mtn,nc);
		System.out.println("�� ��������:\n"+mtn);
		
		HeightCompare hc= new HeightCompare();
		Collections.sort(mtn,hc);
		System.out.println("�� ������:\n"+mtn);
		
		
		
		
		
		
		
	}

}
