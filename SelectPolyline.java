import java.util.Random;
//import java.util.Arrays;

class SelectPolyline {
	//	public static final Random rand = new Random();
	//public static final int NOF_POLYLINES = 10;
	public static Polyline yellowPolyline(Polyline [] polylines) {
		Polyline a = null;
		int i = 0;
		for (i = 0; i < polylines.length; i++) {
			if (polylines[i].getColour().equals("yellow")) {
				a = polylines[i];
				break;
			}
		}

		for (int j = i; j < polylines.length; j++) {

			if (polylines[j].getColour().equals("yellow") && polylines[j].length() < a.length())
				a = polylines[j];
		}

		return a;
	
}
	public static void main (String [] args) {
		Point a = new Point("A" ,1 ,2 );
		Point b = new Point("B" ,3 ,4 );
		Point c = new Point("C" ,5 ,2 );
		Point d = new Point("D" ,6 ,3 );
		Point e = new Point("E" ,4 ,9 );
		Point f = new Point("F" ,1 ,4 );
		Point g = new Point("G" ,3 ,6 );
		Point h = new Point("H" ,2 ,4 );
		Point i = new Point("I" ,6 ,9 );
		Point [] array1 = {a,b,c};
		Point [] array2 = {d,e,f};
		Point [] array3 = {g,h,i};
		Polyline l = new NPolyline(array1);
		Polyline m = new VPolyline(array2);
		Polyline n = new NPolyline(array3);
		l.setColour("yellow");
		m.setColour("blue");
		n.setColour("yellow");
		Polyline [] polylines = {l,m,n};
		Polyline leastYellow = yellowPolyline(polylines);
		System.out.println(leastYellow);
	}

}
