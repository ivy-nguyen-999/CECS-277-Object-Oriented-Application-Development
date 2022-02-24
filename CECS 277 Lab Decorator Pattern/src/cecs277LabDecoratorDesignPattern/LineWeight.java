package cecs277LabDecoratorDesignPattern;

public enum LineWeight {
	LIGHT, MEDIUM, HEAVY;
	
	public String toString () {
		return this.name().toLowerCase();
	}
}
