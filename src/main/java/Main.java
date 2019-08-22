import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        new Problem().logic(System.in, System.out);
    }

    public static class Problem {
        // paste start
        public void logic(InputStream is, PrintStream ps) {
            final Scanner sc = new Scanner(is);
            final int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int N = sc.nextInt();
                int[][] input = new int[N][2];
                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < 2; col++) {
                        input[row][col] = sc.nextInt();
                    }
                }
                ps.println(getResult(input));
            }
        }

        protected String getResult(int[][] input) {
            int[] hours = new int[24 + 1];
            for (int i = 0; i <= 24; i++) {
                hours[i] = 0;
            }
            for (int row = 0; row < input.length; row++) {
                int id = row + 1;
                int start = input[row][0];
                int end = input[row][1];
                for (int i = start; i <= end; i++) {
                    transform(hours, i, id);
                }
            }
            return count(hours);
        }

        protected int[] transform(int[] hours, int hour, int id) {
            int currentId = hours[hour];
            if (currentId > 0) {
                if (currentId != id) {
                    for (int i = 0; i < hours.length; i++) {
                        if (hours[i] == currentId) {
                            hours[i] = id;
                        }
                    }
                } else {
                    // do nothing
                }
            } else {
                hours[hour] = id;
            }
            return hours;
        }

        protected String count(int[] hours) {
            int count = 0;
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= hours.length - 1; i++) {
                int currentId = hours[i];
                if (currentId > 0) {
                    count++;
                    result.add(i);
                    int end = hours.length - 1;
                    for (int j = i + 1; j <= hours.length - 1; j++) {
                        if (currentId != hours[j]) {
                            end = j - 1;
                            break;
                        }
                    }
                    result.add(end);
                    i = end;
                }
            }
            return count + (result.size() > 0 ? "\r\n" + result.stream().map(String::valueOf).collect(Collectors.joining(" ")) : "");
        }
        // paste end
    }
}
