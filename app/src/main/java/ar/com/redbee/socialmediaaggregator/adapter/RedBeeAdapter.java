package ar.com.redbee.socialmediaaggregator.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvalido on 17/03/2018.
 */

public abstract class RedBeeAdapter<TEntity,THolder extends RecyclerView.ViewHolder>  extends RecyclerView.Adapter<THolder>
        implements
        RedBeeItemClickListener<TEntity>,
        RedBeeItemLongClickListener<TEntity>,
        RedBeeItemChangeSelectedListener<TEntity>,
        RedBeeItemOptionListener<TEntity>
{

    private final List<TEntity> selectedItems;
    private final Context context;
    protected List<TEntity> items;
    private RedBeeItemClickListener<TEntity> entityItemClickListener;
    private RedBeeItemChangeSelectedListener<TEntity> entityItemChangeSelectedListener;
    private RedBeeItemOptionListener entityItemOptionListener;

    protected List<TEntity> getItems() {
        return items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<TEntity> getSelectedItems() {
        return selectedItems;
    }

    public RedBeeAdapter(List<TEntity> items, Context context) {
        this.items = items;
        this.context = context;
        this.selectedItems = new ArrayList<>();
    }

    public void refresh(List<TEntity> items) {
        this.items.clear();
        this.items.addAll(items);
        this.notifyDataSetChanged();
    }

    public void clearSelected() {
        this.selectedItems.clear();
        this.onSelectionChange(this.selectedItems);
    }

    public void setOnItemChangeSelectedListener(RedBeeItemChangeSelectedListener<TEntity> listener) {
        this.entityItemChangeSelectedListener = listener;
    }

    public void onSetItemOptionListener(RedBeeItemOptionListener<TEntity> assetItemOptionListener) {
        this.entityItemOptionListener = assetItemOptionListener;
    }

    @Override
    public void onOptionClickListener(View v, TEntity entity, String actionName) {
        if (this.entityItemOptionListener != null){
            entityItemOptionListener.onOptionClickListener(v, entity, actionName);
        }
    }

    @Override
    public void onLongClickListener(View v, TEntity entity) {
        if (this.selectedItems.contains(entity)){
            this.selectedItems.remove(entity);
        }else {
            this.selectedItems.add(entity);
        }
        this.onSelectionChange(this.selectedItems);
    }


    @Override
    public void onSelectionChange(List<TEntity> entity) {
        if (entityItemChangeSelectedListener != null){
            entityItemChangeSelectedListener.onSelectionChange(this.selectedItems);
        }
    }

    @Override
    public void onClickListener(View v, TEntity entity) {
        if (entityItemClickListener != null){
            entityItemClickListener.onClickListener(v,entity);
        }
    }
}
