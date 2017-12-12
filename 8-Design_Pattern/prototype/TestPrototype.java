package com.myra.design.pattern.prototype;

public class TestPrototype {

	public static void main(String[] args) {
		Cubic cubic = new Cubic(12, 20, 66);
        System.out.print("Cubic 的长、宽、高: ");
        System.out.println(cubic.length + ", " + cubic.width + ", " + cubic.height + ".");
        
        try {
        	Cubic cubicCopy = (Cubic) cubic.cloneMe();
        	System.out.print("CubicCopy 的长、宽、高: ");
            System.out.println(cubicCopy.length + ", " + cubicCopy.width + ", " + cubicCopy.height + ".");
        } catch (CloneNotSupportedException cnse) {
        	
        }
        
        Goat goat = new Goat();
        goat.setColor(new StringBuffer("白颜色的山羊"));
        System.out.println("Goat 是: " + goat.getColor() + ".");
        
        try {
        	Goat goatCopy = (Goat) goat.cloneMe();
        	System.out.println("GoatCopy 是: " + goatCopy.getColor() + ".");
        	System.out.println("GoatCopy 将自己的颜色改变为黑色.");
        	goatCopy.setColor(new StringBuffer("黑颜色的山羊"));
        	System.out.println("Goat 仍然是: " + goat.getColor() + ".");
        	System.out.println("GoatCopy 是: " + goatCopy.getColor() + ".");
        } catch (CloneNotSupportedException cnse) {
        	
        }
	}

}
