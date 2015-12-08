package br.com.renanmassaroto.wishlist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.renanmassaroto.wishlist.R;
import br.com.renanmassaroto.wishlist.adapters.DetailedWishlistAdapter;
import br.com.renanmassaroto.wishlist.fragments.datasets.DetailedWishlistEntry;
import br.com.renanmassaroto.wishlist.models.Category;

/**
 * Created by renan on 02/12/15.
 */
public class DetailedWishlistCardFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private DetailedWishlistAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed_wishlist_card, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_detailed_wishlist_card_recycler_view);

        // This setting to improve performance because changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<DetailedWishlistEntry> detailedWishlistEntriesArrayList = new ArrayList<>();
        detailedWishlistEntriesArrayList.add(
                new DetailedWishlistEntry(
                        new Category("Categoria 1", "#9c27b0", "#ce93d8"),
                        new BigDecimal("100")
                )
        );

        detailedWishlistEntriesArrayList.add(
                new DetailedWishlistEntry(
                        new Category("Categoria 2", "#4caf50", "#a5d6a7"),
                        new BigDecimal("375")
                )
        );

        mAdapter = new DetailedWishlistAdapter(getActivity(), detailedWishlistEntriesArrayList, new BigDecimal("155"));
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }
}
