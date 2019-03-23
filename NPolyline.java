
public class NPolyline implements Polyline {
	private static class Node {
		public Point vertex;
		public Node nextNode;

		public Node(Point vertex) {
			this.vertex = vertex;
			nextNode = null;
		}
	}

	private Node vertices;
	private String colour = " black ";
	private int width = 1; // pixels

	public NPolyline() {
		this.vertices = null;
	}

	public NPolyline(Point[] vertices) {
		if (vertices.length > 0) {

			Node node = new Node(new Point(vertices[0]));
			this.vertices = node;
			int pos = 1;
			while (pos < vertices.length) {
				node.nextNode = new Node(new Point(vertices[pos++]));
				node = node.nextNode;
			}
		}
	}

	public int size() {
		int a = 0;
		Node b = vertices;
		if (b != null) {
			a = 1;
			while (b.nextNode != null) {

				b = b.nextNode;
				a++;
			}
		}
		return a;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = vertices;
		if (node != null) {
			sb.append(node.vertex);
			while (node.nextNode != null) {
				node = node.nextNode;
				sb.append(node.vertex);

			}
		}
		String stringForVertices = sb.toString();
		return "{" + "[" + stringForVertices + "]" + "," + colour + "," + width + "}";

	}

	public Point[] getVertices() {

		Point[] newVertices = new Point[NPolyline.this.size()];
		Node node = vertices;
		int i = 1;
		if (node != null) {
			newVertices[0] = node.vertex;
			while (node.nextNode != null) {
				node = node.nextNode;
				newVertices[i] = node.vertex;
				i++;
			}
		}
		return newVertices;
	}

	public String getColour() {
		return new String(colour);
	}

	public int getWidth() {
		return width;
	}

	public double length() {
		Node node = vertices;
		double a = 0;
		if (NPolyline.this.size() >= 2) {
			for (int i = 0; i < NPolyline.this.size() - 1; i++) {

				a = a + node.vertex.distance(node.nextNode.vertex);
				node = node.nextNode;
			}
		} else {
			a = 0;
		}
		return a;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void add(Point vertex) {
		Node node = vertices;
		Node n = new Node(vertex);
		if (node == null)
			vertices = n;
		else {
			while (node.nextNode != null)
				node = node.nextNode;
			node.nextNode = n;
			// node = n;
		}

	}

	public void insertBefore(Point vertex, String vertexName) {
		Node node = vertices;
		Node node1 = new Node(vertex);

		if (node == null) {
			node = node1;

		}
		if (vertices.vertex.getName() == vertexName) {
			Node b = vertices;
			vertices = node1;
			node = vertices;
			node.nextNode = b;
			while (node.nextNode != null)
				node = node.nextNode;
			return;
		} else {
			while (node.nextNode != null) {
				if (node.nextNode.vertex.getName() == vertexName) {
					node1.nextNode = node.nextNode;
					node.nextNode = node1;
					break;
				} else
					node = node.nextNode;
			}
		}

	}

	public void remove(String vertexName) {

		Node node = vertices;
		// Node node2 = node.nextNode;
		if (node == null)
			return;
		if (vertices.vertex.getName() == vertexName) {
			vertices = vertices.nextNode;
			while (node.nextNode != null)
				node = node.nextNode;
		} else {
			while (node.nextNode != null) {
				if (node.nextNode.vertex.getName().equals(vertexName)) {
					node.nextNode = node.nextNode.nextNode;
					// node.vertex = null ;
					break;

				} else
					node = node.nextNode;
			}

		}

	}

	public java.util.Iterator<Point> iterator() {
		class Iterator implements java.util.Iterator<Point> {
			private int current = 0;
			private int end = NPolyline.this.size() ;

			public boolean hasNext() {
				if (current < end)
					return true;
				return false;
			}

			public Point next() throws java.util.NoSuchElementException {
				Node node = vertices;
				int i = 0;
				if (!this.hasNext())
					throw new java.util.NoSuchElementException(" end of iteration ");
				if (current == 0) {
					Point v = node.vertex;
					current++;
					return v;
				}

				while (i < current) {
					node = node.nextNode;
					i++;
				}
				
				Point vertex = node.vertex;
				current++;
				return vertex;
				
			}

		}
		return new Iterator();
	}

}
