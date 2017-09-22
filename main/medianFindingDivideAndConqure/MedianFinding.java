package medianFinding;

import java.util.ArrayList;

public class MedianFinding {
	public static void main(String[] args) {
		int[] a = new int[530];
		for (int i = 0; i < 530; i++) {
			a[i] = i + 1;
		}
		System.out.println(findMedian(a, a.length / 2));

	}

	private static int findMedian(int[] a, int target) {
		if (target == 1)
			return a[0];
		int x0, top1 = 0, top2 = 0;
		int[] b = new int[a.length];
		int[] c = new int[a.length];
		x0 = mFinder(a);
		/*
		 * dividing into two sub arrays based on median of median
		 * as it ensures geometric decrease in the sub problem size
		 */
		for (int x : a) {
			if (x < x0) {
				b[top1] = x;
				top1++;
			} else {
				c[top2] = x;
				top2++;
			}
		}
		if (top1 < target) {
			target = target - top1;

			return findMedian(c, target);
		} else if (top1 == target) {
			return (int) b[top1 - 1];
		} else
			return findMedian(b, target);

	}
/*
 *   mFinder finds median of medians
 */
	public static int mFinder(int[] list) {
		int[][] listMatrix;
		int n = list.length;
		int n0, top = 0, i, j, temp;
		if (n % 5 == 0) {
			n0 = n / 5;
			listMatrix = new int[5][n0];
		} else {
			n0 = n / 5 + 1;
			listMatrix = new int[5][n0];
		}
		int[] median = new int[n0];

		for (i = 0; i < 5 && i < n; i++) {
			for (j = 0; j < n0; j++) {
				if (top >= n)
					break;
				listMatrix[i][j] = list[top];
				top++;
			}
			if (top >= n)
				break;
		}
		if (n0 != 1) {
			/*
			 * computing medians of first n0-1 columns excluding last in case of half full
			 * last column. else all computed here
			 */
			for (int k = 0; k < list.length / 5; k++) {
				for (i = 1; i < 5; i++) {
					for (j = i; j > 0; j--) {
						if (listMatrix[j][k] > listMatrix[j - 1][k]) { // sorting can be considered as constant
							temp = listMatrix[j - 1][k]; // time here as only sorting 5 elements
							listMatrix[j - 1][k] = listMatrix[j][k];
							listMatrix[j][k] = temp;
						}
					}
				}
				median[k] = listMatrix[2][k];
			}

		} else {
			top = 0;
			for (i = 0; i < n; i++) {
				listMatrix[i][0] = list[i];
			}
		}

		/*
		 * for computing median of last semi-full column if exists.
		 */
		if (list.length % 5 != 0 || n == 5) {
			for (i = 1; i < 5; i++) {
				for (j = i; j > 0; j--) {
					if (listMatrix[j][n0 - 1] > listMatrix[j - 1][n0 - 1]) {
						temp = listMatrix[j - 1][n0 - 1];
						listMatrix[j - 1][n0 - 1] = listMatrix[j][n0 - 1];
						listMatrix[j][n0 - 1] = temp;
					}
				}
			}
			if (n % 5 != 0)
				top = n % 5;
			else
				top = 2;
			median[n0 - 1] = listMatrix[(top / 2)][n0 - 1];
		}
		if (n0 == 1)
			return median[0];
		return mFinder(median);
	}
}
