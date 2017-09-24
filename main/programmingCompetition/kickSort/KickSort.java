package round1SPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
/*
 * Problem

Here at Kickstart, we are fans of the well-known Quicksort algorithm, which chooses a pivot value from a list, moves each other value into one of two new lists depending on how it compares with the pivot value, and then recursively sorts each of those new lists. However, the algorithm might choose a pivot that causes all of the other values to end up in only one of the two new lists, which defeats the purpose of the divide-and-conquer strategy. We call such a pivot a worst-case pivot.

To try to avoid this problem, we have created our own variant, Kicksort. Someone told us that it is good to use a value in the middle as a pivot, so our algorithm works as follows:

  Kicksort(A): // A is a 0-indexed array with E elements
    If E ≤ 1, return A.
    Otherwise:
      Create empty new lists B and C.
      Choose A[floor((E-1)/2)] as the pivot P.
      For i = 0 to E-1, except for i = floor((E-1)/2):
        If A[i] ≤ P, append it to B.
        Otherwise, append it to C.
    Return the list Kicksort(B) + P + Kicksort(C).
For practice, we are trying Kicksort out on lists that are permutations of the numbers 1 through N. Unfortunately, it looks like Kicksort still has the same problem as Quicksort: it is possible for every pivot to be a worst-case pivot!

For example, consider the list 1 4 3 2. Kicksort will choose 4 as a pivot, and all of the other values 1 3 2 will end up in one of the two new lists. Then, when Kicksort is called on that list 1 3 2, it will choose 3, and once again, all of the other values will end up in one of the two new lists. Finally, it will choose 1 from the list 1 2, and the other value 2 will of course end up in only one of the two new lists. In every case, the algorithm will choose a worst-case pivot. (Notice that when Kicksort is called on a list with 0 or 1 elements, it does not choose a pivot at all.)

Please help us investigate this further! Given a permutation of the numbers 1 through N, determine whether Kicksort will choose only worst-case pivots.

Input

The first line of the input gives the number of test cases, T. T test cases follow; each consists of two lines. The first line has one integer N: the number of elements in the permutation. The second line contains N integers Ai, which are a permutation of the values from 1 through N.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is YES if Kicksort will choose only worst-case pivots when sorting this list, or NO otherwise.
 */
public class KickSort {
	public static void main(String[] args) {
		String[] g;
		int[] a;
		int n = 0, count = 1, r = 0, c = 0, w = 0, cnt = 0;
		String s;
		String output = null, result = "";

		try {
			Scanner in = new Scanner(Paths.get("input.txt"));
			int t = in.nextInt();
			while (t > 0) {
				n = in.nextInt();
				a = new int[n];
				for (int i = 0; i < n; i++) {
					a[i] = in.nextInt();
				}
				t--;
				result = quickSort(a, n - 1);

				if (count == 1) {
					output = "Case #" + count + ": " + result;
				} else {
					output = output + System.lineSeparator() + "Case #" + count + ": " + result;
				}

				count++;
			}
		} catch (IOException e) {

		}
		try (BufferedWriter b1 = Files.newBufferedWriter(Paths.get("output.txt"))) {
			b1.write(output);
		} catch (IOException e) {

		}
		System.out.println("terminated");
	}

	private static String quickSort(int[] a, int end) {
		if (end == 0)
			return "YES";
		int pivot = a[end / 2];
		int[] b = new int[end];
		int[] c = new int[end];
		int top1 = 0, top2 = 0;
		for (int i = 0; i <= end; i++) {
			if (i == end / 2)
				continue;
			else if (a[i] > pivot) {
				c[top2] = a[i];
				top2++;
			} else if (a[i] <= pivot) {
				b[top1] = a[i];
				top1++;
			}
		}
		if (top1 > 0 && top2 > 0) {
			return "NO";
		} else if (top1 > 0) {
			return quickSort(b, top1 - 1);
		} else if (top2 > 0) {
			return quickSort(c, top2 - 1);
		}
		return "yes";
	}
}
