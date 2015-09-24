/* Bar.java works with Foo.java and Animal.java Tiger.java to demo "covariant return type"
 * in Override function.
 * covariant return type is a new feature introduced in java 1.5.
 */
package com.ghe.exercise;

public class Bar extends Foo{

	public Bar() {
		// TODO Auto-generated constructor stub
	}

	@Override
    Tiger getAnimal() {
        return new Tiger();
    }
	
	public static void main(String[] args) {
		Bar b = new Bar();
		Animal a = b.getAnimal();
		System.out.println("what:" + a);
	}
}
