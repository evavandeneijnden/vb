package pp.block4.cc.test;

import org.junit.Test;
import pp.block4.cc.iloc.CalcCompiler;
import pp.iloc.Simulator;
import pp.iloc.model.Program;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class CalcCompilerTest {
	private final CalcCompiler compiler = new CalcCompiler();
	@Test
	public void test() {
        System.out.println(0b0000000);
		test(-11, "1+-3*4");
		test(-8, "(1+-3)*4");
		test(11, "--1+2*3+4");
		test(-110, "(((1+2)*(3+4)+1)*-5)");
	}

	private void test(int outcome, String expr) {
		assertEquals(outcome, run(expr));
	}

	private int run(String expr) {
		Program prog = this.compiler.compile(expr);
		Simulator sim = new Simulator(prog);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		sim.setOut(out);
		sim.run();
        System.out.println("one test done");

        try (Scanner scan = new Scanner(out.toString())) {
			return Integer.parseInt(scan.findInLine("[\\d-]+"));
		}
    }
}
