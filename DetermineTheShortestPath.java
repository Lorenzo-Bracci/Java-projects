import java.util.Arrays;
public class DetermineTheShortestPath {
	public static void main(String[] args) {

		double[] a = { 10, 3, 4 };
		double[][] b = { { 1, 3, 5, 6 }, { 2, 3, 4, 5 }, { 3, 4, 6, 8 } };
		double[] c = { 3, 5, 4, 1 };
		double result1 = TheShortestPath.length(a, b, c);
		System.out.println("The length of the shortest path between the stations is: " + result1);
		int[] result2 = TheShortestPath.intermediateStations(a, b, c);
		int result21 = result2 [0];
		int result22 = result2 [1];
		int finalresult1 = result21 + 1;
		int finalresult2 = result22 + 1;
		System.out.println("The first intermediate station that should be chosen is: " + finalresult1);
		System.out.println("The second intermediate station that should be chosen is: " + finalresult2);
		//System.out.println("The station in the zone z2 and z3 that should be used are:" + Arrays.toString(result2));

	}
}
