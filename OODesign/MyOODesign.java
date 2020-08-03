package myoodesign;

public class MyOODesign {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Shape circle = new ConcreteDecorate(new Circle());
        Shape square = new ConcreteDecorate(new Square());
        circle.draw();
        square.draw();
	}

}
