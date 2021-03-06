package com.StephenLee.olivepress.press;

import java.util.ArrayList;

import com.StephenLee.olivepress.olives.Olive;


	
public class OlivePress {
	private int totalOil = 0;
	
	public int getTotalOil() {
		return totalOil;
	}

	private void setTotalOil(int totalOil) {
		this.totalOil += totalOil;
	}

	public void getOil(ArrayList<Olive> olives){
		int oil = 0;
		for (Olive olive : olives) {
			oil += olive.crush();
			}//for loop ends
			setTotalOil(oil);
		}//getOil ends
	}//class OlivePress ends

