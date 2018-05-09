package yun;

import java.util.ArrayList;
//import java.util.*;

public class ArrayList_Test {

	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<String>();
		fruits.add("포도");
		fruits.add("딸기");
		fruits.add("복숭아");
		fruits.add("아보카도");
		System.out.println("과일출력");
		
		int size= fruits.size();
		
		for(int i=0; i<size; i++) {
				System.out.println(fruits.get(i));	
		}
		
		fruits.remove(2);
		
		size= fruits.size();
		for(int i=0; i<size; i++) {
			System.out.println(fruits.get(i));	
	}
		
		
		
/*		System.out.println(fruits.get(0));
		System.out.println(fruits.get(1));
		System.out.println(fruits.get(2));
		System.out.println(fruits.get(3));
		*/
		/*String[] fruits = new String[3];
		fruits[0]="포도";
		fruits[1]="딸기";
		fruits[2]="복숭아";
		fruits[3]="아보카도";
		System.out.println("과일출력");*/
		}
	}
