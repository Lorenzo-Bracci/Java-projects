
public class Polyline {
	private Point[] vertices;
	private String colour = "black";
	private int width = 1;

	public Polyline() {
		this.vertices = new Point[0];
	}

	public Polyline(Point[] vertices) {
		this.vertices = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = new Point(vertices[i]);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < vertices.length; i++)
			sb.append(vertices[i]);
		String stringForVertices = sb.toString();
		return "{" + "[" + stringForVertices + "]" + "," + colour + "," + width + "}";

	}

	public Point[] getVertices() {
		Point [] copyVertices = new Point[vertices.length];
		for (int i = 0; i< vertices.length; i++) {
		copyVertices[i] = new Point (vertices[i]);
		}
		return copyVertices;
	}

	public String getColour() {
		return new String(colour);
	}

	public int getWidth() {

		return this.width;
	}

	public void setColour(String colour) {
		this.colour = new String(colour);
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int length1() {
		return vertices.length;
	}

	public double length() {
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

	public void addLast(Point vertex) {
		Point[] h = new Point[this.vertices.length + 1];
		int i = 0;
		for (i = 0; i < this.vertices.length; i++)
			h[i] = this.vertices[i];
		h[i] = new Point(vertex);
		this.vertices = h;
	}

	public void addBefore(Point vertex, String vertexName) {
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

	public void remove(String vertexName) {
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

	public class PolylineIterator {
		private int current = -1;

		public PolylineIterator() {
			if (Polyline.this.vertices.length > 0)
				current = 0;
		}

		public boolean hasVertex() {
			return current != -1;
		}

		public Point vertex() throws java.util.NoSuchElementException {
			if (!this.hasVertex())
				throw new java.util.NoSuchElementException(" end of iteration ");
			Point vertex = Polyline.this.vertices[current];
			return vertex;
		}

		public void advance() {
			if (current >= 0 && current < Polyline.this.vertices.length - 1)
				current++;
			else
				current = -1;
		}
	}
}
