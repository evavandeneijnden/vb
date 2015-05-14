package pp.block3.cc.tabular;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by antoine on 13/05/15.
 */
public class HTMLGenerator extends TexBaseListener {

    // voorbeeld argumenten:
    // "./src/pp/block3/cc/tabular/tabular-1.tex" "./src/pp/block3/cc/tabular/tabular-2.tex"
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
                        System.err.println(String.format("The file '%s' was not converted!",filename));
                    } else {
                        TexBaseListener scopeParser = new MyTexParser(new FileWriter(Paths.get(filename).getFileName().toString() + ".html"));
                        new ParseTreeWalker().walk(scopeParser, parseTree);
                        System.out.println(String.format("The file '%s' is converted.",filename));
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
