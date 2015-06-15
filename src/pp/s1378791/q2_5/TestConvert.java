package pp.s1378791.q2_5;

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
 * Created by antoine on 15/06/15.
 */
public class TestConvert {
    private Assembler assembler = Assembler.instance();
    private final static String FILE = "./src/pp/s1378791/q2_5/convert.iloc";
    private final FuncPascalCompiler compiler = FuncPascalCompiler
            .instance();

    @Test
    public void testConvertILOC() throws IOException, ParseException {
        Program p = assemble(FILE);
        run(new Simulator(p), "4\n7", Convert.convert(4, 7));
        run(new Simulator(p), "9\n4", Convert.convert(9, 4));
        run(new Simulator(p), "56\n16", Convert.convert(56, 16));
    }

    private void run(Simulator sim, String input, int output) {
        Machine vm = sim.getVM();
        sim.setIn(new ByteArrayInputStream(("" + input).getBytes()));
        sim.run();
        assertEquals(output, vm.getReg("r_result"));
    }

    private Program assemble(String filename) {
        File file = new File(filename);
        try {
            return this.assembler.assemble(file);
        } catch (FormatException | IOException e) {
            fail(e.getMessage());
            return null;
        }
    }
}

