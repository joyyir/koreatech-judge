package kr.pe.joyyir.koreatechjudge.problem;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Problem1083Test {
    private Problem1083_Wrong problem = new Problem1083_Wrong();

    @Test
    public void transform_case1() {
        int[] result = problem.transform(new int[]{0, 1, 1, 0, 0, 2, 2}, 1, 3);
        assertEquals(arrayToString(result), arrayToString(new int[]{0, 3, 3, 0, 0, 2, 2}));
    }

    @Test
    public void transform_case2() {
        int[] result = problem.transform(new int[]{0, 1, 1, 0, 0, 2, 2}, 3, 3);
        assertEquals(arrayToString(result), arrayToString(new int[]{0, 1, 1, 3, 0, 2, 2}));
    }

    @Test
    public void transform_case3() {
        int[] result = problem.transform(new int[]{0, 1, 1, 0, 0, 2, 2}, 5, 3);
        assertEquals(arrayToString(result), arrayToString(new int[]{0, 1, 1, 0, 0, 3, 3}));
    }

    @Test
    public void logic() throws Exception {
        String input = "2\n" +
                "3\n" +
                "1 3 6 8 2 5\n" +
                "3\n" +
                "1 2 4 7 1 6";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos, true, "UTF-8");

        problem.logic(is, ps);
        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(output, "2\r\n" +
                "1 5 6 8\r\n" +
                "1\r\n" +
                "1 7\r\n");
    }

    @Test
    public void count_case1() {
        assertEquals(problem.count(new int[]{0, 1, 1, 0, 0, 2, 2}), "2\r\n1 2 5 6");
    }

    @Test
    public void count_case2() {
        assertEquals(problem.count(new int[]{0, 1, 1, 2, 2}), "2\r\n1 2 3 4");
    }

    @Test
    public void count_case3() {
        assertEquals(problem.count(new int[]{0, 0, 0, 0, 0}), "0\r\n");
    }

    private String arrayToString(int[] arr) {
        return Arrays.stream(arr).mapToObj(x -> String.valueOf(x)).collect(Collectors.joining(","));
    }
}