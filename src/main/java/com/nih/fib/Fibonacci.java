package com.nih.fib;

public class Fibonacci {

	// it is not possible to compute fib numbers of big length due to recursion that causes stack overflow
	public static int fib(int n) {
		if (n <= 0) throw new IllegalArgumentException("Length should be greater than 0");
		if (n == 1) return 0;
		if (n == 2 || n == 3) return 1;
		return fib(n - 2) + fib(n - 1);
	}

	public static void pringSequenceRecursively(int length) {
		for (int i = 1; i <= length; i++)
			print(fib(i), i, length);
	}

	public static void printSequence(int length) {
		if (length <= 0) throw new IllegalArgumentException("Length should be greater than 0");
		int first = 0, second = 1, third = 1;

		for (int i = 1; i <= length; i++) {
			if (i == 1) {
				print(first, i, length);
			} else if (i == 2 || i == 3) {
				print(second, i, length);
			} else {
				int buf = third;
				third = second + third;
				second = buf;
				print(third, i, length);
			}
		}
	}

	private static void print(int fib, int i, int length) {
		System.out.print(fib);
		if (i != length) System.out.print(", ");
		else System.out.println();
	}
}
