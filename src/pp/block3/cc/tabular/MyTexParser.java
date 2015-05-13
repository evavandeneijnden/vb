package pp.block3.cc.tabular;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by antoine on 13/05/15.
 */
public class MyTexParser extends TexBaseListener {

    private FileWriter fw;

    public MyTexParser(FileWriter fw) {
        this.fw = fw;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterTable(@NotNull TexParser.TableContext ctx) {
        write("<!DOCTYPE html>\n<html>\n\t<body>\n");
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitTable(@NotNull TexParser.TableContext ctx) {
        write("\t</body>\n</html>\n");
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBeginTable(@NotNull TexParser.BeginTableContext ctx) {
        write("\t\t<table>\n");
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBeginTable(@NotNull TexParser.BeginTableContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterRow(@NotNull TexParser.RowContext ctx) {
        write("\t\t\t<tr>\n");
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitRow(@NotNull TexParser.RowContext ctx) {
        write("\t\t\t</tr>\n");
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEndTable(@NotNull TexParser.EndTableContext ctx) {
        write("\t\t</table>\n");
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEndTable(@NotNull TexParser.EndTableContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEveryRule(@NotNull ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEveryRule(@NotNull ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitTerminal(@NotNull TerminalNode node) {
        if (node.getSymbol().getType()==TexLexer.ENTRY) {
            write(String.format("\t\t\t\t<td>%s</td>\n",node.toString()));
        }
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitErrorNode(@NotNull ErrorNode node) {
    }

    private void write(String text) {
        try {
            fw.write(text);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Write exception");
        }
    }
}
