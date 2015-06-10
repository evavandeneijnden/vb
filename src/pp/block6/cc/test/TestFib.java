package pp.block6.cc.test;

import org.junit.Test;
import pp.block6.cc.FuncPascalCompiler;
import pp.block6.cc.ParseException;
import pp.iloc.Simulator;
import pp.iloc.model.Program;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by antoine on 10/06/15.
 */
public class TestFib {
    private final static String BASE_DIR = "./src/pp/block6/cc/sample";
    private final static String EXT = ".pascal";
    private final FuncPascalCompiler compiler = FuncPascalCompiler
            .instance();

    @Test
    public void testFIB() throws IOException, ParseException {
        try {
            Program program = compile("fib");
            String out = sim(program, "1");
            assertEquals("Result: 1", out.trim());
            out = sim(program, "10");
            assertEquals("Result: 55", out.trim());
        } catch (pp.block5.cc.ParseException e) {
            e.printStackTrace();
        }
    }

    private Program compile(String filename) throws IOException, ParseException, pp.block5.cc.ParseException {
        return this.compiler.compile(new File(BASE_DIR, filename + EXT));
    }


    private String sim(Program prog, String input) {
        Simulator sim = new Simulator(prog);
        sim.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        sim.setOut(out);
        sim.run();
        return out.toString();
    }
}
