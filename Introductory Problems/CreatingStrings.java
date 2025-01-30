import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1622

public class CreatingStrings {

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		List<String> output = new ArrayList<String>();

		char[] input = fr.next().toCharArray();
		char[] buffer = new char[input.length];
		boolean[] visited = new boolean[input.length];
		Arrays.sort(input);

		printString(input, buffer, 0, output, visited);

		out.println(output.size());
		for (String s : output) {
			out.println(s);
		}

		out.flush();
	}

	public static void printString(char[] input, char[] buffer, int bidx, List<String> output,
			boolean[] visited) {

		if (bidx == (buffer.length)) {
			output.add(new String(buffer));
			return;
		}

		for (int i = 0; i < input.length; i++) {
			if (visited[i])
				continue;

			if (i > 0 && input[i] == input[i - 1] && !visited[i - 1])
				continue;

			visited[i] = true;
			buffer[bidx] = input[i];
			printString(input, buffer, bidx + 1, output, visited);
			visited[i] = false;
		}

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
