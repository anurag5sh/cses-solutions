import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1070

public class Permutations {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n == 1) {
			System.out.println("1");
			sc.close();
			return;
		}

		if (n == 2 || n == 3) {
			System.out.println("NO SOLUTION");
			sc.close();
			return;
		}

		// Use stringbuilder as sysout is expensive for every number
		StringBuilder sb = new StringBuilder();

		for (int i = 2; i <= n; i += 2) {
			sb.append(i + " ");
		}

		for (int i = 1; i <= n; i += 2) {
			sb.append(i + " ");
		}

		System.out.println(sb.toString());

		sc.close();
	}
}
