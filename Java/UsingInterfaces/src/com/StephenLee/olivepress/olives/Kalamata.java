package com.StephenLee.olivepress.olives;

public class Kalamata extends Olive {

	public Kalamata() {
		super(2);
		this.name = "Kalamata";
		this.flavor = "grassy";
		this.color = Olive.BLACK;
	}
	@Override
	public int crush(){
		System.out.println("crush from subclass");
		return super.crush();
	}
	public String getOrigin(){
		return "Greece";
	}
}
