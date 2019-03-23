
public class TheShortestPath {

	public static int[] intermediateStations(double[] a, double[][] b, double[] c) {

		int[] e = { 0, 0 };
		double sum = a[0] + b[0][0] + c[0];
		for (int m = 0; m < a.length; m++) {
			for (int n = 0; n < c.length; n++) {
				if ((a[m] + b[m][n] + c[n]) < sum) {
					sum = (a[m] + b[m][n] + c[n]);
					e[0] = m;
					e[1] = n;
				}
			}
		}
		return e;

	}

	public static double length(double[] a, double[][] b, double[] c) {

		double sum = a[0] + b[0][0] + c[0];
		for (int m = 0; m < a.length; m++) {
			for (int n = 0; n < c.length; n++) {
				if ((a[m] + b[m][n] + c[n]) < sum)
					sum = (a[m] + b[m][n] + c[n]);
			}
		}
		return sum;

	}
}
