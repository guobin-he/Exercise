package com.ghe.exercise;

public class Tiger extends Animal {
	int teeth;

	public Tiger() {
		super();
		teeth=10;
	}
	
	public Tiger(int teeth) {
		super();
		this.teeth=teeth;
	}

	public Tiger(int height, int weight, int teeth) {
		super(height, weight);
		this.teeth=teeth;
	}
	
	public int getTeeth() {
		return teeth;
	}
	
	@Override public Tiger getAnother() {
		return new Tiger();
	}

	@Override public String toString() {
		return("I am a Tigger(" + height + "," + weight + "," + teeth + ")");
	}
	
	@Override public Tiger clone() {
   		return (Tiger) super.clone();
	}

	public static void main(String[] args) {
		Tiger first = new Tiger();
		first.teeth = 1;
		System.out.println("first:    " + first);
		Tiger second = first.getAnother();
		System.out.println("second:    " + second);
		Tiger third = first.clone();
		System.out.println("third:    " + third);
	}

}
