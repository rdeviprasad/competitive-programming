import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        Task solver = new Task();
        solver.solve(1, in, out);

        out.flush();
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int inf = (int)(1e9+5);
            int[] stones = in.readIntArray(n);
            int[] dp = new int[n];
            Arrays.fill(dp, inf);
            dp[0] = 0;
            dp[1] = Math.abs(stones[0] - stones[1]);

            for(int i = 2; i < n; i++) {
                for(int j = 1; j <= k; j++) {
                    if(i - j >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(stones[i] - stones[i - j]));
                    }
                }
            }
            out.println(dp[n - 1]);
        }
    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) return null;
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] readIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }
    }
}