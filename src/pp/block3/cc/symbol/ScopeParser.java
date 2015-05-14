package pp.block3.cc.symbol;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by antoine on 13/05/15.
 */
public class ScopeParser extends DeclUseBaseListener {
    SymbolTable scope;
    List<String> errors;

    public ScopeParser(){
        errors = new LinkedList<>();
    }

    @Override
    public void enterProgram(@NotNull DeclUseParser.ProgramContext ctx) {
        scope = new MySymbolTable();
    }

    @Override
    public void enterSeries(@NotNull DeclUseParser.SeriesContext ctx) {
        scope.openScope();
    }

    @Override
    public void exitSeries(@NotNull DeclUseParser.SeriesContext ctx) {
        scope.closeScope();
    }
    @Override
    public void enterDecl(@NotNull DeclUseParser.DeclContext ctx) {
        if (!scope.add(ctx.ID().toString()))
            errors.add(String.format("Multiple declerations of \"%s\" at line %d character %d",ctx.ID().toString(),ctx.ID().getSymbol().getLine(),ctx.ID().getSymbol().getCharPositionInLine()));
    }

    @Override
    public void enterUse(@NotNull DeclUseParser.UseContext ctx) {
        if (!scope.contains(ctx.ID().toString()))
            errors.add(String.format("Undeclared variable \"%s\" at line %d character %d",ctx.ID().toString(),ctx.ID().getSymbol().getLine(),ctx.ID().getSymbol().getCharPositionInLine()));
    }

    public List<String> getErrors(){
        return errors;
    }

    public static void test_file(String filename){
        try (FileReader fr = new FileReader(filename)) {
            CharStream chars = new ANTLRInputStream(fr);
            Lexer lexer = new DeclUseLexer(chars);
            TokenStream tokens = new CommonTokenStream(lexer);
            DeclUseParser parser = new DeclUseParser(tokens);
            ParseTree parseTree = parser.program();
            new ParseTreeWalker().walk(new ScopeParser(), parseTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test_file("./src/pp/block3/cc/symbol/scopetest.txt");
    }
}


