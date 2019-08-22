package kr.pe.joyyir.koreatechjudge.problem;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class Problem1082Test {
    private Problem1082 problem = new Problem1082();

    @Test
    public void logic() throws Exception {
        String input = "7\n" +
                "algorithm_10.mov\n" +
                "algorithm_3.mov\n" +
                "algorithm_4.mov\n" +
                "algorithm_2.mov\n" +
                "algorithm_23.mov\n" +
                "algorithm_100.mov\n" +
                "algorithm_9999.mov";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos, true, "UTF-8");

        problem.logic(is, ps);
        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(output, "algorithm_2.mov\r\n" +
                "algorithm_3.mov\r\n" +
                "algorithm_4.mov\r\n" +
                "algorithm_10.mov\r\n" +
                "algorithm_23.mov\r\n" +
                "algorithm_100.mov\r\n" +
                "algorithm_9999.mov\r\n");
    }
}