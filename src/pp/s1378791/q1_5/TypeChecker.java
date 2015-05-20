package pp.s1378791.q1_5;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by antoine on 20/05/15.
 */
public class TypeChecker extends TypeUseBaseListener {

    MySymbolTable scope;
    List<String> errors;

    public TypeChecker() {
        errors = new LinkedList<>();
    }

    public static void test_file(String filename) {
        try (FileReader fr = new FileReader(filename)) {
            CharStream chars = new ANTLRInputStream(fr);
            Lexer lexer = new TypeUseLexer(chars);
            TokenStream tokens = new CommonTokenStream(lexer);
            TypeUseParser parser = new TypeUseParser(tokens);
            ParseTree parseTree = parser.program();
            TypeChecker typeChecker = new TypeChecker();
            new ParseTreeWalker().walk(typeChecker, parseTree);
            if (typeChecker.getErrors().size()!=0)
                System.out.println(typeChecker.getErrors());
            else
                System.out.println(String.format("No errors occured while parsing '%s'",filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        test_file("./src/pp/s1378791/q1_5/typeuse-1.txt");
        test_file("./src/pp/s1378791/q1_5/typeuse-2.txt");
    }


    public void enterProgram(@NotNull TypeUseParser.ProgramContext ctx) {
        scope = new MySymbolTable();
    }

    @Override
    public void enterSeries(@NotNull TypeUseParser.SeriesContext ctx) {
        scope.openScope();
    }

    @Override
    public void exitSeries(@NotNull TypeUseParser.SeriesContext ctx) {
        scope.closeScope();
    }

    @Override
    public void enterDecl(@NotNull TypeUseParser.DeclContext ctx) {
        if (!scope.add(ctx.ID(0).toString(), ctx.ID(1).toString()))
            errors.add(String.format("Multiple declerations of \"%s\" at line %d character %d", ctx.ID(0).toString(), ctx.ID(0).getSymbol().getLine(), ctx.ID(0).getSymbol().getCharPositionInLine()));
    }

    @Override
    public void enterAssign(@NotNull TypeUseParser.AssignContext ctx) {
        if (!scope.sameType(ctx.ID(0).toString(), ctx.ID(1).toString()))
            errors.add(String.format("Undeclared variable \"%s\" at line %d character %d", ctx.ID().toString(), ctx.ID(0).getSymbol().getLine(), ctx.ID(0).getSymbol().getCharPositionInLine()));
    }

    public List<String> getErrors() {
        return errors;
    }
}
