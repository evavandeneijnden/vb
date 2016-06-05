package pp.block4.cc.test;

import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class FibTest {

    @Test
    public void test(){
//        run(1);
//        run(2);
//        run(3);
//        run(4);
        run(45);
    }

    public void run(Integer n) {
        Machine vm1 = new Machine();
        vm1.init("n", n);
        vm1.init("x", 1);
        vm1.init("y", 1);
        vm1.init("z", 1);

        Machine vm2 = new Machine();
        vm2.setNum("n", n);

        try {
            Program prog_mod_to_mod = Assembler.instance().assemble(new File("C:/Users/Eva/Documents/vb/block 4/src/pp/block4/cc/iloc/fib_mod_to_mod.iloc"));
            Simulator simulator_mod_to_mod = new Simulator(prog_mod_to_mod, vm1);
            simulator_mod_to_mod.run();
            int result_mod_to_mod = simulator_mod_to_mod.getVM().getReg("r_z");

            Program prog_reg_to_reg = Assembler.instance().assemble(new File("C:/Users/Eva/Documents/vb/block 4/src/pp/block4/cc/iloc/fib_reg_to_reg.iloc"));
            Simulator simulator_reg_to_reg = new Simulator(prog_reg_to_reg, vm2);
            simulator_reg_to_reg.run();
            int result_reg_to_reg = simulator_reg_to_reg.getVM().getReg("r_z");

            assertEquals(result_mod_to_mod, result_reg_to_reg);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
