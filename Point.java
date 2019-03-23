
public class Point {

	int x;
	int y;
	String a;

	public Point(String a, int x, int y) {
		this.a = a;
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		a = p.a;
		x = p.x;
		y = p.y;
	}
	public String toString() {
		return " (" + a + " ," + x + " ,"  + y + " )" ;
		}
	public int getX() {
		return x;
		}
	public void setX(int x) {
		this.x = x;
		
		}
	public int getY() {
		return y;
		}
	public String getName(){
	return a;
	}
	public void setY(int y) {
		this.y = y;
		
		}
	public double distance(Point p2) {

		
		int x2 = p2.getX();
		
		int y2 = p2.getY();
		double z1 = Math.pow((x - x2), 2);
		double z2 = Math.pow((y - y2), 2);
		double result = Math.sqrt(z1 + z2);
		return result;
	}
	public boolean equal(Point p2) {
		if (p2.getX() == x && p2.getY() == y ) {
			return true;
		}
		return false;
	}
	
}
