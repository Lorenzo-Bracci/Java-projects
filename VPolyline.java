 
public class VPolyline implements Polyline {
	private Point [] vertices;
	private String colour = "black";
	private int width = 1;
	public VPolyline (Point [] vertices){
		this.vertices = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = new Point(vertices[i]);
	}
	public Point [] getVertices () {
		Point [] copyVertices = new Point[vertices.length];
		for (int i = 0; i< vertices.length; i++) {
			copyVertices[i] = new Point (vertices[i]);
		}
		return copyVertices;
	}
	public String getColour () {
		return new String(colour);
	}
	public int getWidth (){
		return width;
	}
	public double length (){
		double a = 0;
		if (this.vertices.length >= 2) {
			for (int i = 0; i < this.vertices.length - 1; i++) {

				a = a + this.vertices[i].distance(this.vertices[i + 1]);
			}
		} else {
			a = 0;
		}
		return a;
	}
	public void setColour ( String colour ){
		this.colour = new String(colour);
	}
	public void setWidth(int width){
		this.width = width;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.vertices.length; i++)
			sb.append(vertices[i]);
		String stringForVertices = sb.toString();
		return "{" + "[" + stringForVertices + "]" + "," + colour + "," + width + "}";

	}
	public void add ( Point vertex ){
		Point[] h = new Point[this.vertices.length + 1];
		int i = 0;
		for (i = 0; i < this.vertices.length; i++)
			h[i] = this.vertices[i];
		h[i] = new Point(vertex);
		this.vertices = h;
	}
	public void insertBefore ( Point vertex , String vertexName ){
		Point[] h = new Point[this.vertices.length + 1];
		int i = 0;

		for (i = 0; i < vertices.length; i++) {
			if (this.vertices[i].getName().equals(vertexName)) {
				h[i] = new Point(vertex);
				break;
			}
		}

		for (int j = 0; j < i; j++) {
			h[j] = this.vertices[j];

		}
		for (int k = i + 1; k < h.length; k++)
			h[k] = this.vertices[k - 1];
		this.vertices = h;

	}
	public void remove ( String vertexName ){
		Point[] h = new Point[this.vertices.length - 1];
		int i = 0;

		for (i = 0; i < this.vertices.length; i++) {
			if (this.vertices[i].getName().equals(vertexName))
				break;
		}
		for (int j = 0; j < i; j++) {
			h[j] = this.vertices[j];

		}
		for (int k = i; k < h.length; k++) {
			h[k] = this.vertices[k + 1];
		}
		this.vertices = h;
	}
	public java.util.Iterator <Point > iterator (){
		class Iterator implements java.util.Iterator<Point>{
		private int current = 0;
		private int end = VPolyline.this.vertices.length;
		public boolean hasNext() {
			if(current < end)
				return true;
			return false;
		}
		public Point next() throws java.util.NoSuchElementException{
			if (!this.hasNext())
				throw new java.util.NoSuchElementException(" end of iteration ");
			Point vertex = VPolyline.this.vertices[current];
			current ++;
			return vertex;
		}
		
		}
		return new Iterator();
	}
}
