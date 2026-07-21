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
            long W = in.nextLong();
            long[] w = new long[n];
            int[] v = new int[n];
            int maxPossibleValue = 0;
            for(int i = 0; i < n; i++) {
                w[i] = in.nextLong();
                v[i] = in.nextInt();
                maxPossibleValue += v[i];
            }

            long[] dp = new long[maxPossibleValue + 1]; // minimum weight for given value
            long inf = (long)(1e18+7);
            Arrays.fill(dp, inf);
            dp[0] = 0l;
            for(int i = 0; i < n; i++) {
                for(int j = maxPossibleValue - v[i]; j >= 0; j--) {
                    if(dp[j] != inf) {
                        dp[j + v[i]] = Math.min(dp[j + v[i]], dp[j] + w[i]);
                    }
                }
            }
            int ans = 0;
            for(int i = 0; i <= maxPossibleValue; i++) {
                if(dp[i] <= W) ans = i;
            }
            out.println(ans);
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