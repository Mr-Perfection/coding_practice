package com.StephenLee.olivepress.press;

import java.util.ArrayList;

import com.StephenLee.olivepress.olives.Olive;

public class OlivePress {
	public OlivePress() {
	}
	public void getOil(ArrayList<Olive> olives){
		int oil = 0;
		for (Olive olive : olives) {
			oil += olive.crush();
			}//for loop ends
		System.out.println("You got " + oil + " units of oil");
		}//getOil ends
	}//class OlivePress ends

