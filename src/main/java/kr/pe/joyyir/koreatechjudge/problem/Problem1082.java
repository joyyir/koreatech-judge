package kr.pe.joyyir.koreatechjudge.problem;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem1082 implements Problem {
    @Override
    public void logic(InputStream is, PrintStream ps) {
        final Scanner sc = new Scanner(is);
        final int count = sc.nextInt();
        final String[] input = new String[count];
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            input[i] = sc.nextLine();
        }
        ps.println(getResult(Arrays.asList(input)));
    }

    protected String getResult(List<String> input) {
        return input.stream()
                    .sorted(Comparator.comparing(a -> Integer.valueOf(a.split("_")[1].split("[.]")[0])))
                    .collect(Collectors.joining("\r\n"));
    }
}
