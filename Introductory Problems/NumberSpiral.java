import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1071/

public class NumberSpiral {
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

    public static void main(String args[]) {
        FastReader fs = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();

        for (int i = 0; i < t; i++) {
            long y = fs.nextLong();
            long x = fs.nextLong();
            long max = Math.max(x, y);
            boolean isEven = max % 2 == 0;
            long result = 0;
            long sq = max * max;

            if (isEven) {
                if (x == max)
                    result = sq - max - (max - y) + 1;
                else
                    result = sq - x + 1;
            } else {
                if (x == max)
                    result = sq - y + 1;
                else
                    result = sq - max - (max - x) + 1;
            }

            out.println(result + "\n");
        }

        out.flush();
    }
}
