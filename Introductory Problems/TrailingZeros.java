import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1618

public class TrailingZeros {

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = fr.nextInt();
		int noOfZeros = 0;

		for (int i = 5; i <= n; i = i * 5) {
			noOfZeros += n / i;
		}

		out.println(noOfZeros);

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
