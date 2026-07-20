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
            int[] dp = new int[3];
            for(int day = 0; day < n; day++) {
                int[] newDp = new int[3];
                int[] activities = in.readIntArray(3);
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        if(i != j) {
                            newDp[j] = Math.max(newDp[j], dp[i] + activities[j]);
                        }
                    }
                }
                dp = newDp;
            }
            out.println(Math.max(dp[0], Math.max(dp[1], dp[2])));
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