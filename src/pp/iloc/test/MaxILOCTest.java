package pp.iloc.test;

import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by antoine on 27/05/15.
 */
public class MaxILOCTest {

    private final static String BASE_DIR = "./src/pp/block4/cc/iloc/";
    private final static boolean SHOW = true;

    @Test
    public void MaxTest() {
        Program p = parse("max");
        Machine m = new Machine();
        System.out.println(m.init("a", 1, 2, 3, 4, 5, 6));
        m.setNum("alength", 6);
        Simulator sim = new Simulator(p, m);
        sim.run();
        System.out.println(m);
    }

    Program parse(String filename) {
        File file = new File(filename + ".iloc");
        if (!file.exists()) {
            file = new File(BASE_DIR + filename + ".iloc");
        }
        try {
            Program result = Assembler.instance().assemble(file);
            String print = result.prettyPrint();
            if (SHOW) {
                System.out.println("Program " + file + ":");
                System.out.print(print);
            }
            Program other = Assembler.instance().assemble(print);
            assertEquals(result, other);
            return result;
        } catch (FormatException | IOException e) {
            fail(e.getMessage());
            return null;
        }
    }

    private HashSet<Integer> ints(Integer... vals) {
        return new HashSet<>(Arrays.asList(vals));
    }
}
