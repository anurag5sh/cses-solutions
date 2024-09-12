import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1072/

public class TwoKnights {

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = fr.nextInt();

		for (int i = 1; i <= n; i++) {
			long sq = i * i;
			long maxPos = (sq * (sq - 1)) / 2; // nC2 combinations to place 2 knights over complete board
			long invalidPos = 4 * (i - 1) * (i - 2); // calculate the invalid positions
			// since the knight moves in L shape, we can mask a 2x3 array which would
			// contribute to 2 invalid positions each.
			// there would exist 3x2 arrays too. So in total count the 2x3 and 3x2 arrays
			// that exist for a given nxn board.
			out.println(maxPos - invalidPos);
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
