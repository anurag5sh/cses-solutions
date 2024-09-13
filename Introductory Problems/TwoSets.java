import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1092

public class TwoSets {

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		long n = fr.nextLong();
		long sum = n * (n + 1) / 2;

		if (sum % 2 == 0) {
			out.println("YES");
			long setSum = sum / 2, temp = 0;
			long i = 1, j = n;
			while (temp != setSum) {
				long s = i + j;
				if ((temp + s) <= setSum) {
					temp += s;
					sb.append(i + " " + j + " ");
					i++;
					j--;
				} else {
					if ((temp + i) == setSum) {
						temp += i;
						sb.append(i + " ");
						i++;
					} else {
						temp += j;
						sb.append(j + " ");
						j--;
					}
				}
			}
			long set1size = i + n - j - 1;
			out.println(set1size);
			out.println(sb.toString());
			out.println(n - set1size);
			for (long k = i; k <= j; k++) {
				out.print(k + " ");
			}
		} else {
			out.println("NO");
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
