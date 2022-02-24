package cecs277LabDecoratorDesignPattern;

public enum Color {
	BLACK, BLUE, RED, GREEN, ORANGE, PUCE, PURPLE;
	
	public String toString () {
		return this.name().substring(0, 1) + 
				(this.name().substring(1)).toLowerCase();
	}
}
