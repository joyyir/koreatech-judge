package kr.pe.joyyir.koreatechjudge.problem;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem1077 implements Problem {
    @Override
    public void logic(InputStream is, PrintStream ps) {
        int T, count;
        Scanner sc = new Scanner(is);

        T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            count = sc.nextInt();
            Integer[] arr = new Integer[count];
            for (int i = 0; i < count; i++) {
                arr[i] = sc.nextInt();
            }
            ps.println(isDuplicated(Arrays.asList(arr)));
        }
    }

    protected boolean isDuplicated(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList()).size() != list.size();
    }
}
