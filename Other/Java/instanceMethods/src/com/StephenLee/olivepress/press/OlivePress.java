package com.StephenLee.olivepress.press;

import com.StephenLee.olivepress.olives.Olive;

public class OlivePress {
	public void getOil(Olive[] olives){
		for (Olive olive : olives) {
			olive.crush();
			}//for loop ends
		}//getOil ends
	}//class OlivePress ends
