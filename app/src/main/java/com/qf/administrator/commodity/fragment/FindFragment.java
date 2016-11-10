package com.qf.administrator.commodity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.administrator.commodity.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {

    private RecyclerView rlv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rlv= (RecyclerView) view.findViewById(R.id.rlv_firstfrag);
        initData();
        rlv.setLayoutManager(new GridLayoutManager(getContext(),2));
        initAdapter();
    }

    private void initAdapter() {

    }

    private void initData() {

    }
}
