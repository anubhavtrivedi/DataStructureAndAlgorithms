package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		a = insertionSort(a);
		display(a);
	}

	public static int[] insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 1; j--) {
				if (a[j - 1] > a[j]) {
					a[j] = a[j] + a[j - 1];
					a[j - 1] = a[j] - a[j - 1];
					a[j] = a[j] - a[j - 1];
				}
			}
		}
		return a;
	}

	public static void display(int[] a) {
		System.out.println("Sorted array is :");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
	}

}
