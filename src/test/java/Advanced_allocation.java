package test.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Advanced_allocation {
    @Test
    public void testAdvanced_allocation() {
        String[] args = new String[2];
        args[0] = "C:\\Users\\mikis\\Desktop\\self-test-data\\advanced-allocation\\store.json";
        args[1] = "C:\\Users\\mikis\\Desktop\\self-test-data\\advanced-allocation\\orders.json";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        main.java.Main.main(args);
        String programOutput = outContent.toString().trim();

        String expectedOutput = """
                P1 order-1 09:00\r
                P2 order-2 09:00\r
                P1 order-5 09:15\r
                P2 order-3 09:30\r
                P2 order-4 09:45\r
                P2 order-6 10:00\r
                P1 order-7 10:15""";

        assertEquals(expectedOutput, programOutput);
    }
}





