import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/2205

public class GrayCode {

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = fr.nextInt();
		char[][] gc = new char[1 << n][n];

		int sw = (gc.length >> 1) - 1;
		for (int i = 0; i < gc.length; i++) {
			char c = '0';
			if (i > sw)
				c = '1';
			gc[i][0] = c;
		}

		int count = gc.length >> 1;
		int j = 0;
		while (count > 1) {
			j++;
			int set = 0;
			boolean flip = false;
			sw = (count >> 1) - 1;

			for (int i = 0; i < gc.length; i++) {
				if (set == count) {
					flip = !flip;
					set = 0;
				}

				char c = flip ? '1' : '0';

				if (set > sw) {
					c = flip ? '0' : '1';
				}
				gc[i][j] = c;
				set++;
			}
			count = count >> 1;
		}

		for (char[] num : gc)
			out.println(new String(num));

		out.flush();
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
