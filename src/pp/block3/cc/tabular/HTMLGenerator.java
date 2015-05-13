package pp.block3.cc.tabular;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by antoine on 13/05/15.
 */
public class HTMLGenerator extends TexBaseListener {


    public static void main(String[] args) {
        if (args.length > 0) {
            for (String filename : args) {
                System.out.println("Parsing " + filename);
                try {
                    MyListener myListener = new MyListener();

                    ANTLRFileStream chars = new ANTLRFileStream(filename);
                    Lexer lexer = new TexLexer(chars);
                    lexer.removeErrorListeners();
                    lexer.addErrorListener(myListener);

                    TokenStream tokens = new CommonTokenStream(lexer);

                    TexParser parser = new TexParser(tokens);
                    parser.removeErrorListeners();
                    parser.addErrorListener(myListener);

                    ParseTree parseTree = parser.table();

                    if (myListener.getErrors().size() > 0) {
                        for (String error : myListener.getErrors()) {
                            System.err.println(error);
                        }
                    } else {
                        TexBaseListener scopeParser = new MyTexParser(new FileWriter("test.html"));
                        new ParseTreeWalker().walk(scopeParser, parseTree);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Give me a filename!");
        }
    }
}
