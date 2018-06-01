package ar.com.redbee.socialmediaaggregator.commons.linq;

/**
 * Created by lvalido on 01/01/1900.
 *
 * @param <TS> the input type parameter
 * @param <TT> the output type parameter
 */
public interface Func<TS,TT> {
    /**
     * Eval tt.
     *
     * @param item the item
     * @return the tt
     */
    TT eval(TS item);
}
