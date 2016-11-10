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
    private MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder>{


        @Override
        public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(Myholder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class Myholder extends RecyclerView.ViewHolder{

            public Myholder(View itemView) {
                super(itemView);
            }
        }
    }
}
