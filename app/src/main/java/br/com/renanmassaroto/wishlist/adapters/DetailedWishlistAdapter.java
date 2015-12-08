package br.com.renanmassaroto.wishlist.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.renanmassaroto.wishlist.fragments.datasets.DetailedWishlistEntry;
import br.com.renanmassaroto.wishlist.R;
import br.com.renanmassaroto.wishlist.models.Category;
import br.com.renanmassaroto.wishlist.views.HorizontalBarView;

/**
 * Created by renan on 02/12/15.
 */
public class DetailedWishlistAdapter extends RecyclerView.Adapter<DetailedWishlistAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DetailedWishlistEntry> detailedWishlistEntries;
    private BigDecimal funds;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public HorizontalBarView mHorizontalBarView;

        public ViewHolder(View view) {
            super(view);

            mTextView = (TextView) view.findViewById(R.id.text_1);
            mHorizontalBarView = (HorizontalBarView) view.findViewById(R.id.horizontal_bar_1);
        }
    }

    public DetailedWishlistAdapter(Context context, ArrayList<DetailedWishlistEntry> entries, BigDecimal funds) {
        this.detailedWishlistEntries = entries;
        this.context = context;
        this.funds = funds;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_1, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DetailedWishlistEntry entry = detailedWishlistEntries.get(position);

        holder.mHorizontalBarView.setMaxProgress(entry.getValue().floatValue());
        holder.mHorizontalBarView.setProgress(funds.floatValue());

        holder.mHorizontalBarView.setBarBackgroundColor(
                Color.parseColor(entry.getCategory().getLighterColor())
        );
        holder.mHorizontalBarView.setBarForegroundColor(
                Color.parseColor(entry.getCategory().getPrimaryColor())
        );

        holder.mTextView.setText(entry.getCategory().getName());
    }

    @Override
    public int getItemCount() {
        return detailedWishlistEntries.size();
    }
}
