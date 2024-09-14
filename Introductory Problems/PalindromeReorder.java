import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1755

public class PalindromeReorder {

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		String input = fr.next();
		char[] inputArr = input.toCharArray();
		int n = inputArr.length;
		int[] frequency = new int[26];
		int start = 0, end = n - 1;
		boolean isOddUsed = false;

		for (char c : inputArr) {
			frequency[c - 'A']++;
		}

		for (int i = 0; i < 26; i++) {
			if (frequency[i] != 0) {

				int count = frequency[i];
				if ((count & 1) == 1) { // if count is odd
					if (isOddUsed) {
						out.println("NO SOLUTION");
						out.flush();
						return;
					}
					isOddUsed = true;
					inputArr[n / 2] = (char) ((int) 'A' + i);
				}

				count = count / 2;
				while (count > 0) {
					count--;
					inputArr[start++] = (char) ((int) 'A' + i);
					inputArr[end--] = (char) ((int) 'A' + i);
				}
			}

		}

		out.println(new String(inputArr));
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
