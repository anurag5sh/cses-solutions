import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1754

public class CoinPiles {

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = fr.nextInt();
		while (t-- > 0) {
			long pile1 = fr.nextLong();
			long pile2 = fr.nextLong();

			long temp = Math.max(pile1, pile2);
			pile2 = Math.min(pile1, pile2);
			pile1 = temp;

			if ((pile1 + pile2) % 3 == 0 && pile2 * 2 >= pile1) {
				out.println("YES");
			} else {
				out.println("NO");
			}
		}
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
