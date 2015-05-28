package pp.iloc.test;

/**
 * Created by Eva on 28/05/2015.
 */

// 46th is largest fibonacci number without overflow
import org.junit.Test;
import org.junit.Test.*;
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

public class FibTest {
    private final static String BASE_DIR = "./src/pp/block4/cc/iloc/";
    private final static boolean SHOW = true;

    @Test
    public void modToModTest() {
        Program p = parse("fib_mod_to_mod");
        Machine m = new Machine();
        m.init("n", 3);
        m.init("x", 1);
        int y = m.init("y",1);
        Simulator sim = new Simulator(p, m);
        sim.run();
        System.out.println(m);

        assertEquals(3, m.load(y));
    }

    @Test
    public void regtoRegTest() {
        Program p = parse("fib_reg_to_reg");
        Machine m = new Machine();
        m.setNum("n", 55);
        Simulator sim = new Simulator(p, m);
        sim.run();
        System.out.println(m);

//        assertEquals(3, m.getReg("r_z"));
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
