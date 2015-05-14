package pp.block3.cc.antlr.CC5;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block3.cc.antlr.Type;

/**
 * Created by Eva on 13/05/2015.
 */
public class TypeDeterminer extends CC5BaseListener {
    public ParseTreeProperty<Type> vals;
    public void init() {
        vals = new ParseTreeProperty<>();
    }

    @Override
    public void exitStr(@NotNull CC5Parser.StrContext ctx) { vals.put(ctx, Type.STR);}

    @Override
    public void exitBool(@NotNull CC5Parser.BoolContext ctx) {vals.put(ctx, Type.BOOL);}

    @Override
    public void exitNum(@NotNull CC5Parser.NumContext ctx) {vals.put(ctx, Type.NUM);}

    @Override
    public void exitEquals(@NotNull CC5Parser.EqualsContext ctx) {
        if (vals.get(ctx.term(0)) == vals.get(ctx.term(1))){vals.put(ctx, Type.BOOL);}
        else {vals.put(ctx, Type.ERR);}
    }

    @Override
    public void exitHat(@NotNull CC5Parser.HatContext ctx) {
        if (vals.get(ctx.term(0)) == Type.NUM &&vals.get(ctx.term(1)) == Type.NUM){
            vals.put(ctx, Type.NUM);
        }
        else if (vals.get(ctx.term(0)) == Type.STR &&vals.get(ctx.term(1)) == Type.STR){
            vals.put(ctx, Type.STR);
        }
        else {
            vals.put(ctx, Type.ERR);
        }
    }

    @Override
    public void exitPlus(@NotNull CC5Parser.PlusContext ctx) {
        if (vals.get(ctx.term(0)) == vals.get(ctx.term(1))){
            vals.put(ctx, vals.get(ctx.term(0)));
        }
        else {
            vals.put(ctx, Type.ERR);
        }
    }
}
