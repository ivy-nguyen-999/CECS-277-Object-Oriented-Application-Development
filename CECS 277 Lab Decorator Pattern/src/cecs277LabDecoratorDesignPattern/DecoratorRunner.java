package cecs277LabDecoratorDesignPattern;

public class DecoratorRunner {

	public static void main(String[] args) {
		GeometricObject c1 = new LineWeightDecorator (new FillColorDecorator 
				(new Circle (3, 4, 5), Color.BLUE), LineWeight.LIGHT); 
		c1.draw();
		System.out.println(c1);
	}
}
