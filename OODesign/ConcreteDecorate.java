package myoodesign;

public class ConcreteDecorate extends Decorator {
	
    public Shape shape;
    
    public ConcreteDecorate(Shape shape) {
        super(shape);
        this.shape = shape;
    }
    
    public void preprocess() {
        System.out.println("Preprocess");
    }
    
    public void postprocess() {
        System.out.println("Postprocess ");
    }
    
    public void draw() {
    	preprocess();
        super.draw();
        postprocess();
    }
}
