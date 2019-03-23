import java.util.*;

public class TheLeastInteger {
	// The min method returns the least element in a sequential
	// collection. If the collection is empty an
	// IllegalArgumentException is thrown.
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Insert the number of elements is the sequence: ");
		int m = in.nextInt();
		int[] a = new int[m];
		System.out.println("Insert sequence of numbers: ");
		for (int i = 0; i < m ; i++){
			a[i] = in.nextInt();
			
		}
		int b = min (a);
		
		System.out.println("The least integer is: " + b);
	}
	

	public static int min(int[] elements) throws IllegalArgumentException {
		if (elements.length == 0)
			throw new IllegalArgumentException("empty  collection");
		// Is used in trace printing 2:
		// int nofIters = 1;
		int[] sequence = elements;
		int nofPairs = sequence.length / 2;
		int nofUnpairedElements = sequence.length % 2;

		int nofPossibleElements = nofPairs + nofUnpairedElements;
		int[] partialSeq = new int[nofPossibleElements];
		int i = 0;
		int j = 0;
		while ((nofPairs * 2) + nofUnpairedElements > 1) {
			// extract a partial sequence of possible elements
			i = 0;
			j = 0;
			while (j < nofPairs ) {
				partialSeq[j++] = (sequence[i] < sequence[i + 1]) ? sequence[i] : sequence[i + 1];
				
				i += 2;
			}
			if (nofUnpairedElements == 1)
				partialSeq[j] = sequence[ sequence.length  - 1];
			// now turn to the partial sequence
			sequence = partialSeq;
			nofPairs = nofPossibleElements / 2;
			nofUnpairedElements = nofPossibleElements % 2;
			//THE PROBLEM APPEARS ALSO AT N = 11 
			nofPossibleElements = nofPairs + nofUnpairedElements;
			
			
			 System.out.println (java.util.Arrays.toString (sequence ));
			// Trace printing 2 - to terminate the loop preemptively
			// (to be able to see what happens initially)
			// if (nofIters ++ == 10)
			// System.exit (0);
		}
		// sequence [0] is the only remaining possible element
		// - it is the least element
		
		return sequence [0];
	}
	public static int minUpdate(int[] elements) {
		int min = elements[0];
		for (int i = 1; i < elements.length; i ++) {
			if (elements[i] < min)
			min = elements[i];
	
	}
		return min;
	}
}
