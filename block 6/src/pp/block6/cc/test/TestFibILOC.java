package pp.block6.cc.test;

import org.junit.Test;
import pp.block6.cc.FuncPascalCompiler;
import pp.block6.cc.ParseException;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by antoine on 10/06/15.
 */
public class TestFibILOC {
    private Assembler assembler = Assembler.instance();
//    private final static String BASE_DIR = "./src/pp/block6/cc/sample";
//    private final static String EXT = ".pascal";
//    private final FuncPascalCompiler compiler = FuncPascalCompiler
//            .instance();

    @Test
    public void testFIB() throws IOException, ParseException {
        Program p = assemble("./src/pp/block6/cc/fib");
        int f1 = 0;
        int f2 = 1;
        for (int i = 0; i < 22; i++) {
            int temp = f1 + f2;
            f1 = f2;
            f2 = temp;
            run(new Simulator(p),i+1,f2);
        }
    }

    private void run(Simulator sim, int input, int output) {
        Machine vm = sim.getVM();
        sim.setIn(new ByteArrayInputStream(("" + input).getBytes()));
        sim.run();
        assertEquals(output, vm.getReg("r_result"));
    }

    private Program assemble(String filename) {
        File file = new File(filename + ".iloc");
        try {
            return this.assembler.assemble(file);
        } catch (FormatException | IOException e) {
            fail(e.getMessage());
            return null;
        }
    }
}
