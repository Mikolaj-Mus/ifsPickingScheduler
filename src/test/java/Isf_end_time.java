package test.java;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertTrue;

public class Isf_end_time {
    @Test
    public void testIsf_end_time() {
        String[] args = new String[2];
        args[0] = "C:\\Users\\mikis\\Desktop\\self-test-data\\isf-end-time\\store.json";
        args[1] = "C:\\Users\\mikis\\Desktop\\self-test-data\\isf-end-time\\orders.json";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        main.java.Main.main(args);
        String programOutput = outContent.toString().trim();

        String expectedOutput1 = "P1 order-1 09:00";
        String expectedOutput2 = "P1 order-2 09:00";

        assertTrue(expectedOutput1.equals(programOutput) || expectedOutput2.equals(programOutput));
    }
}


