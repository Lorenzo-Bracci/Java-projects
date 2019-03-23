
public class Polyline1 {
	private Point[] vertices;
	private String colour = "black";
	private  int width = 1;
		public Polyline1() {
			this.vertices =  vertices;
		}

		public Polyline1(Point[] vertices) {
			this.vertices = vertices;
			for (int i = 0; i < vertices.length; i++)
				this.vertices[i] =  vertices[i];
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < vertices.length; i ++ )
				sb.append(vertices[i]);
			String stringForVertices = sb.toString();
			return "{" + "[" + stringForVertices + "]" + "," + colour + "," + width + "}";

		}

		public Point[] getVertices() {
			return vertices;
		}

		public String getColour() {
			return colour;
		}

		public int getWidth() {
			return width;
		}

		public void setColour(String colour) {
			this.colour = colour;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public double length() {
			double a = 0;
			if(this.vertices.length >= 2) {
			for (int i = 0; i < this.vertices.length - 1 ; i++) {
				
					a = a + this.vertices[i].distance(this.vertices[i + 1]);
					}
			}
			else {
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
			Point [] h = new Point [this.vertices.length + 1];
			int i = 0;
			
			
			for ( i = 0; i < vertices.length; i ++) {
				if (this.vertices[i].getName().equals(vertexName) ) {
					h[i] = new Point (vertex);
					break;
				}
			}
			
			for ( int j = 0; j < i; j ++) {
				h [j] = this.vertices [j];

				}
			for (int k = i + 1; k < h.length; k ++)
				h[k] = this.vertices[k-1];
			this.vertices = h;
			
		}

		public void remove(String vertexName) {
			Point [] h = new Point [this.vertices.length - 1];
			int i = 0;
			
			
			for ( i = 0; i < this.vertices.length; i ++) {
				if (this.vertices[i].getName().equals(vertexName) )
				break;
			}
	for (int j = 0; j < i; j ++) {
		h [j] = this.vertices [j];

		}
	for (int k = i ; k < h.length; k ++) {
		h[k] = this.vertices[k+1];
	}
	this.vertices = h;


		}
}
