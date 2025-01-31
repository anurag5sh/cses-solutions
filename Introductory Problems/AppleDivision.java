import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1623

public class AppleDivision {
	static long minDiff;

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int n = fr.nextInt();
		long[] apples = new long[n];
		long totalSum = 0;
		for (int i = 0; i < n; i++) {
			apples[i] = fr.nextInt();
			totalSum += apples[i];
		}
		minDiff = n == 1 ? apples[0] : Long.MAX_VALUE;

		findMinDiff(apples, 0, 0, totalSum, 0);
		out.println(minDiff);

		out.flush();
	}

	public static void findMinDiff(long[] apples, int i, long cumulativeSum, long totalSum, int applesUsed) {
		if ((applesUsed + 1) == apples.length || i == apples.length)
			return;

		findMinDiff(apples, i + 1, cumulativeSum, totalSum, applesUsed); // skip current index
		cumulativeSum += apples[i];
		minDiff = Math.min(minDiff, Math.abs(totalSum - cumulativeSum - cumulativeSum));
		findMinDiff(apples, i + 1, cumulativeSum, totalSum, applesUsed + 1); // skip current index
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(
					new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
