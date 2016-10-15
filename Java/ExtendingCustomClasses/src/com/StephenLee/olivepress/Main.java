package com.StephenLee.olivepress;

import java.util.ArrayList;

import com.StephenLee.olivepress.olives.Kalamata;
import com.StephenLee.olivepress.olives.Ligarian;
import com.StephenLee.olivepress.olives.Olive;
import com.StephenLee.olivepress.press.OlivePress;

public class Main {
/*public means a method can be called 
from anywhere in the application;
private means it's available within the class;
Static means that is a class method that 
can be called from the class definition, but otherwise,
it's an instance method.
ex) Main -class definition, Olive and OlivePress- instance methods;
*/
	public static void main(String[] args) {
		
		ArrayList<Olive> olives = new ArrayList<Olive>();
		
		Olive olive = new Kalamata();
		System.out.println(olive.name);
		olives.add(olive);
		
		olive = new Ligarian();
		System.out.println(olive.name);
		olives.add(olive);
		
		olive = new Kalamata();
		System.out.println(olive.name);
		olives.add(olive);
		
	
		OlivePress press = new OlivePress();
		press.getOil(olives);
		
		
		
		
	}//public static void ends

}//Main ends
