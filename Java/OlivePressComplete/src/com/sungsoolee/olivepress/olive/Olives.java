package com.sungsoolee.olivepress.olive;
/*Put characteristics of Olive: colors, types, and oil.
	we will be creating a olive press to squeeze oil out of olives.
	 */



public class Olives {
//declare characteristics (variables and constants)
	public static final long BLACK = 0x000000; //color is black
	public static final long GREEN = 0x00FF00; //color is green (made it up)
	public String name = "CutiePie";
	public String taste = "Disgusting";
	public static long color = BLACK;
	private int oil = 3;
	/**
	 * @return the oil
	 */
	public int getOil() {
		return oil;
	}
	/**
	 * @param oil the oil to set
	 */
	public void setOil(int oil) {
		this.oil = oil;
	}
	
	public int crush() {
		System.out.println("Ouch!");
		return oil;
	}
		
	}

