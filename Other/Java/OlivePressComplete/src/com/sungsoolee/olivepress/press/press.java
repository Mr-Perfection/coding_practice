package com.sungsoolee.olivepress.press;

import java.util.ArrayList;

import com.sungsoolee.olivepress.olive.Olives;

public class press {
	public void getOil(ArrayList<Olives> Olive) {
	int oil = 0;
	for (Olives olive : Olive) {
		oil += olive.crush();
	}//for loop ends
	System.out.println("You got " + oil + " units of oil");
	
	}
	
}
