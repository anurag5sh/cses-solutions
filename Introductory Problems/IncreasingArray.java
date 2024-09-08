import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1094

public class IncreasingArray {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		long result = 0;

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			max = Math.max(max, num);
			result += max - num;
		}
		System.out.println(result);
		sc.close();
	}
}
