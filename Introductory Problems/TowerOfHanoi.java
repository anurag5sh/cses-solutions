import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/2165

public class TowerOfHanoi {

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		List<int[]> steps = new ArrayList<int[]>();

		int n = fr.nextInt();
		hanoi(n, 1, 2, 3, steps);

		out.println(steps.size());
		for (int[] s : steps) {
			out.println(s[0] + " " + s[1]);
		}

		out.flush();
	}

	public static void hanoi(int n, int start, int mid, int end, List<int[]> steps) {
		if (n == 1) {
			steps.add(new int[] { start, end });
			return;
		}

		hanoi(n - 1, start, end, mid, steps);
		steps.add(new int[] { start, end });
		hanoi(n - 1, mid, start, end, steps);
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
