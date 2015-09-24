package com.ghe.exercise;


public class Animal implements Cloneable {
	int height;
	int weight;
	
	public Animal() {
		height=0;
		weight=0;
	}
	
	public Animal(int height, int weight) {
		this.height=height;
		this.weight=weight;
	}

	public int getHeight() {
		return height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override public String toString() {
		return("I am an Animal(" + height + "," + weight + ")");
	}
	
	@Override public Animal clone()  {
        //super.clone() returns an Object type, but it has the space of Animal, because 
		//"clone" means to create a copy of its caller. Eg:
		//    Animal a = new Animal(10,20);
		//    Animal b = a.clone();
		//when a.clone() is calling, a's super.clone creates a copy of "a" but returns Object type
		//as the result -- hat's why we should and be able to cast it to "Animal" type. 
		try {
    		return (Animal) super.clone();
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}

	public Animal getAnother() {
		Animal t = new Animal(10,20);
		return(t);
	}
	
	public static void main(String[] args) {
   		Animal first = new Animal(1,11);
    	Animal second = first.clone();
	    System.out.println("second:" + second);
	}

}
