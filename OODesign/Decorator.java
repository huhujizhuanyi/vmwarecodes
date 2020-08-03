package myoodesign;

public class Decorator implements Shape {
	
    public Shape shape;
    
    public Decorator(Shape shape) {
        this.shape = shape;
    }
    
    @Override
    public void draw() {
        // TODO Auto-generated method stub
    	shape.draw();
    }
}
