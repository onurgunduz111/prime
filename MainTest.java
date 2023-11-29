import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainTest {


    @BeforeAll
    public static void init(){
        new MockUp<System>() {
            @Mock
            public void exit(int value) {
                throw new RuntimeException(String.valueOf(value));
            }
        };
    }


    @Test
    public void shouldExitIfMultipleCommandLineParametersEntered(){

        String[] arguments = new String[] { "9", "11" };

        try {
            Main.main(arguments);
        } catch(RuntimeException ex){
            assertEquals("-1", ex.getMessage());
        }

    }

    @Test
    public void shouldExitIfNonIntegerCommandLineParameterEntered(){

        String[] arguments = new String[] { "9.5" };

        try {
            Main.main(arguments);
        } catch(RuntimeException ex){
            assertEquals("-1", ex.getMessage());
        }

    }

    @Test
    public void shouldExitIfNonPositiveIntegerCommandLineParameterEnteredZero(){

        String[] arguments = new String[] { "0" };

        try {
            Main.main(arguments);
        } catch(RuntimeException ex){
            assertEquals("-1", ex.getMessage());
        }

    }

    @Test
    public void shouldExitIfNonPositiveIntegerCommandLineParameterEnteredNegative(){

        String[] arguments = new String[] { "-5" };

        try {
            Main.main(arguments);
        } catch(RuntimeException ex){
            assertEquals("-1", ex.getMessage());
        }

    }

    @Test
    public void shouldExitIfCommandLineParameterOneEntered(){

        String[] arguments = new String[] { "1" };

        try {
            Main.main(arguments);
        } catch(RuntimeException ex){
            assertEquals("-1", ex.getMessage());
        }

    }

    @Test
    public void shouldExitIfPrimeIntegerCommandLineParameterEntered0(){

        String[] arguments = new String[] { "2" };

        try {
            Main.main(arguments);
        } catch(RuntimeException ex){
            assertEquals("-1", ex.getMessage());
        }

    }

    @Test
    public void shouldExitIfPrimeIntegerCommandLineParameterEntered1(){

        String[] arguments = new String[] { "3" };

        try {
            Main.main(arguments);
        } catch(RuntimeException ex){
            assertEquals("-1", ex.getMessage());
        }

    }

    @Test
    public void shouldExitIfPrimeIntegerCommandLineParameterEntered2(){

        String[] arguments = new String[] { "5" };

        try {
            Main.main(arguments);
        } catch(RuntimeException ex){
            assertEquals("-1", ex.getMessage());
        }

    }

    @Test
    public void shouldExitIfPrimeIntegerCommandLineParameterEntered3(){

        String[] arguments = new String[] { "7" };

        try {
            Main.main(arguments);
        } catch(RuntimeException ex){
            assertEquals("-1", ex.getMessage());
        }

    }


    @Test
    public void shouldOutputTableIfNonPrimeIntegerCommandLineParameterEntered0(){
        String[] arguments = new String[] { "4" };

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        System.setOut(out);

        Main.main(arguments);

        String consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset());
        assertTrue(consoleOutput.contains("Prime           Count"));
        assertTrue(consoleOutput.contains("2               2"));

        out.close();
    }

    @Test
    public void shouldOutputTableIfNonPrimeIntegerCommandLineParameterEntered1(){
        String[] arguments = new String[] { "18" };

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        System.setOut(out);

        Main.main(arguments);

        String consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset());
        assertTrue(consoleOutput.contains("Prime           Count"));
        assertTrue(consoleOutput.contains("2               1"));
        assertTrue(consoleOutput.contains("3               2"));

        out.close();
    }

    @Test
    public void shouldOutputTableIfNonPrimeIntegerCommandLineParameterEntered2(){
        String[] arguments = new String[] { "2147483646" };

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        System.setOut(out);

        Main.main(arguments);

        String consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset());
        assertTrue(consoleOutput.contains("Prime           Count"));
        assertTrue(consoleOutput.contains("2               1"));
        assertTrue(consoleOutput.contains("3               2"));
        assertTrue(consoleOutput.contains("7               1"));
        assertTrue(consoleOutput.contains("151               1"));
        assertTrue(consoleOutput.contains("11               1"));
        assertTrue(consoleOutput.contains("331               1"));
        assertTrue(consoleOutput.contains("31               1"));

        out.close();
    }


}
