package pp.block2.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class SentenceCopyUsage {
    public static void main(String[] args) {
        parse("all smart undergraduate students love compilers.");
//        parse("all students love love.");
    }

    public static void parse(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new SentenceLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        SentenceCopyParser parser = new SentenceCopyParser(tokens);
        ParseTree tree = parser.sentence();
        System.out.println(tree.toStringTree(parser));
    }
}
