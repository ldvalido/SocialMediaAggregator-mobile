package ar.com.redbee.socialmediaaggregator.adapter;

import android.support.v7.widget.RecyclerView;

import com.karumi.dividers.Direction;
import com.karumi.dividers.Position;
import com.karumi.dividers.selector.Selector;

import java.util.EnumSet;
import java.util.List;

/**
 * Created by lvalido on 17/03/2018.
 */

public class RedBeeCriteriaSelector<TEntity,THolder extends RecyclerView.ViewHolder> implements Selector {
    /**
     * The Number columns.
     */
    Integer numberColumns;
    /**
     * The Items.
     */
    List<TEntity> items;
    /**
     * The Adapter.
     */
    RedBeeAdapter<TEntity,THolder> adapter;

    public RedBeeCriteriaSelector(List<TEntity> items, RedBeeAdapter<TEntity,THolder> adapter, Integer numberColumns) {
        this.numberColumns = numberColumns;
        this.adapter = adapter;
        this.items = items;
    }
    @Override
    public boolean isPositionSelected(Position position) {
        boolean returnValue = false;

        Integer calculatedIndex = position.getRow() * numberColumns + position.getColumn();
        if (calculatedIndex < items.size()){
            TEntity selectedItem = items.get(calculatedIndex);
            returnValue =  adapter.getSelectedItems().contains(selectedItem);
        }
        return returnValue;
    }

    @Override
    public EnumSet<Direction> getDirectionsByPosition(Position position) {
        return EnumSet.allOf(Direction.class);
    }
}
