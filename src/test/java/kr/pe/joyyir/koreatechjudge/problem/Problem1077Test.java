package kr.pe.joyyir.koreatechjudge.problem;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Problem1077Test {
    private Problem1077 problem = new Problem1077();

    @Test
    public void logic() throws Exception {
        String input = "2\n"
                + "5\n"
                + "5 4 7 1 4\n"
                + "4\n"
                + "1 2 3 4";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos, true, "UTF-8");

        problem.logic(is, ps);
        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(output, "true\r\nfalse\r\n");
    }

    @Test
    public void isDuplicated_case1() {
        assertTrue(problem.isDuplicated(Arrays.asList(5, 4, 7, 1, 4)));
    }

    @Test
    public void isDuplicated_case2() {
        assertFalse(problem.isDuplicated(Arrays.asList(1, 2, 3, 4)));
    }
}