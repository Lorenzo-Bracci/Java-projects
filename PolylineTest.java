
public class PolylineTest {
	public static void main(String[]args) {
		Point vertex = new Point ("e",3,5);
		Point a = new Point("a",3,4);
		Point b = new Point("b",1,2);
		Point c = new Point("c",2,3);
		Point d = new Point("d",5,1);
		Point [] vertices =  {a,b,c,d};
		Polyline polyline = null ;
		polyline = new NPolyline (vertices);
		for ( Point n : polyline )
			System . out. println ( n );
		double length = polyline.length();
		
		polyline.insertBefore( vertex,"d" );// (1)
		//polyline.remove("yellow");
		// polyline = new NPolyline (); // (2)
		System.out.println(polyline);
		System.out.println(length);
		

	}
}
