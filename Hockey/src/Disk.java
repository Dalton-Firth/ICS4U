
public class Disk extends Circle {

	private double thickness;

	public Disk(double r, double t) {
		super(r);
		thickness = t;
	}

	public void setThickness(double newThickness) {
		thickness = newThickness;
	}

	public double getThickness() {
		return (thickness);
	}

	public double volume() {
		double v;
		v = super.area() * thickness;

		return v;
	}

	public boolean equals(Object d){
		
		Disk testObj = (Disk)d;
		
		if(testObj.getRadius() == super.getRadius()&&testObj.getThickness() == thickness)
			return true;
		
		return false;
	}
	
	public String toString() {
		return("The disk has a radius "+super.getRadius()+" and thickness"+ thickness+".");
	}
}
