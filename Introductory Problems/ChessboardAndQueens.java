import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1624

public class ChessboardAndQueens {
	static int totalSolutions = 0;
	final static int boardSize = 8;

	public static void main(String args[]) {
		FastReader fr = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		char[][] board = new char[boardSize][boardSize];

		for (int i = 0; i < boardSize; i++) {
			board[i] = fr.next().toCharArray();
		}

		solve(board, 0, new boolean[boardSize], new boolean[15], new boolean[15]);
		out.println(totalSolutions);

		out.flush();
	}

	public static void solve(char[][] board, int row, boolean[] col, boolean[] diag1, boolean[] diag2) {
		if (row == boardSize) {
			totalSolutions++;
			return;
		}

		for (int j = 0; j < boardSize; j++) {
			if (board[row][j] == '.' && !col[j] && !diag1[row + j] && !diag2[row - j + 7]) {
				col[j] = true;
				diag1[row + j] = true;
				diag2[row - j + 7] = true;
				solve(board, row + 1, col, diag1, diag2);
				col[j] = false;
				diag1[row + j] = false;
				diag2[row - j + 7] = false;
			}
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
