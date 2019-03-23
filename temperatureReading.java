import java.util.*;
/*      */    

public class temperatureReading {
	public static void main(String[] args) {
		System.out.println("TEMPERATURES\n");
		// input tools
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		// enter the number of weeks and measurements
		System.out.print("number  of weeks: ");
		int nofWeeks = in.nextInt();
		System.out.print("number  of  measurements  per  week: ");
		int nofMeasurementsPerWeek = in.nextInt();
		// storage space for temperature data
		double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];
		// read the temperatures
		for (int week = 1; week <= nofWeeks; week++) {
			System.out.println("temperatures  - week " + week + ":");
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
				t[week][reading] = in.nextDouble();
		}
		System.out.println();
		// show the temperatures
		System.out.println("the  temperatures:");
		for (int week = 1; week <= nofWeeks; week++) {
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
				System.out.print(t[week][reading] + " ");
			System.out.println();
		}
		System.out.println();
		// the least , greatest and average temperature - weekly
		double[] minT = new double[nofWeeks + 1];
		double[] maxT = new double[nofWeeks + 1];
		double[] sumT = new double[nofWeeks + 1];
		double[] avgT = new double[nofWeeks + 1];

		for (int week = 1; week <= nofWeeks; week++) 
		{
			minT[week] = Double.POSITIVE_INFINITY;

			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++) {
				if (minT[week] > t[week][reading])
					minT[week] = t[week][reading];
				
			}
			System.out.println("The minimum temperature of week " + week + " is: " + minT[week]);
			maxT[week] = Double.NEGATIVE_INFINITY;
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++) {
				if (maxT[week] < t[week][reading])
					maxT[week] = t[week][reading];
				
			}
			System.out.println("The maximum temperature of week " + week + " is: " + maxT[week]);

			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
				sumT[week] += t[week][reading];
			double average = sumT[week] / nofMeasurementsPerWeek;
			System.out.println("The sum of the temperatures of week " + week + " is: " + sumT[week]);

			System.out.println("The average temperature of week " + week + " is: " + average);

		}

		// the least , greatest and average temperature - whole period
		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumTemp = sumT[0];
		double avgTemp = 0;
		for (int i = 1; i <= nofWeeks; i++) 
		{
			if (minT[i] < minTemp)
				minTemp = minT[i];
			
		}
		System.out.println("The minimum temperature is :" + minTemp);
		for (int i = 1; i <= nofWeeks; i++) 
		{
		
			if (maxT[i] > maxTemp)
				maxTemp = maxT[i];
			
		}
		System.out.println("The maximum temperature is :" + maxTemp);

		for (int i = 1; i <= nofWeeks; i++)
			sumTemp += sumT[i];

		double averageTemp = sumTemp / nofWeeks;
		System.out.println("The sum of the temperatures is: " + sumTemp);
		System.out.println("The average of the temperatures is: " + averageTemp);

		// compute and store the least , greatest and average
		// temperature for the whole period
		// *** WRITE YOUR CODE HERE ***
		// show the least , greatest and average temperature for
		// the whole period
		// *** WRITE YOUR CODE HERE
	}

}

