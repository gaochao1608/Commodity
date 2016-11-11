package com.qf.administrator.commodity.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.activity.GoodsListActivity;
import com.qf.administrator.commodity.bean.CategoryAll;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private String url = "http://api.danpin.com/index.php?controller=config&action=global";
    private RecyclerView rcv;
    private Context context;
    private MyAdapter adapter;
    private ArrayList<CategoryAll.DataBean.CategoryBean> list = new ArrayList<>();
    private MyGridAdapter gridAdapter;

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance() {

        Bundle args = new Bundle();

        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv = (RecyclerView) view.findViewById(R.id.rcv);
        initData();
        initAdapter();
    }

    private void initAdapter() {
        rcv.setLayoutManager(new LinearLayoutManager(context));
        adapter = new MyAdapter();
        rcv.setAdapter(adapter);
    }

    private void initData() {
        OkHttpUtils.getInstances().getByEnqueue(getActivity(), url, CategoryAll.class,
                new OkHttpUtils.GetTextCallback<CategoryAll>() {
                    @Override
                    public void getText(CategoryAll result) {
                        list.addAll(result.getData().getCategory());
                        adapter.notifyDataSetChanged();
                    }
                });

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(context).inflate(R.layout.item_category, null));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.cateText.setText(list.get(position).getCate_name());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.height = getResources().getDisplayMetrics().heightPixels / 5;
            holder.cateBig.setLayoutParams(params);
            Glide.with(context).load(list.get(position).getPic_large()).into(holder.cateBig);
//            for (int i = 0; i < list.get(position).getSub().size(); i++) {
//                TextView tv = new TextView(context);
//                tv.setText(list.get(position).getSub().get(i).getCate_name());
//                holder.cateGrid.addView(tv);
//            }
            gridAdapter = new MyGridAdapter(position);
            holder.cateGrid.setAdapter(gridAdapter);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            public ImageView cateBig;
            public TextView cateText;
            public GridView cateGrid;

            public MyHolder(View itemView) {
                super(itemView);
                this.cateBig = (ImageView) itemView.findViewById(R.id.cate_big);
                this.cateText = (TextView) itemView.findViewById(R.id.cate_text);
                this.cateGrid = (GridView) itemView.findViewById(R.id.cate_grid);
            }
        }
    }

    class MyGridAdapter extends BaseAdapter {
        private int position;

        public MyGridAdapter(int position) {
            this.position = position;
        }

        @Override
        public int getCount() {
            return list.get(position).getSub().size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            Holder holder;
            if(view == null){
                view = LayoutInflater.from(context).inflate(R.layout.item_text, null);
                holder = new Holder(view);
                view.setTag(holder);
            }else{
                holder = (Holder) view.getTag();
            }
            holder.itemText.setText(list.get(position).getSub().get(i).getCate_name());
            holder.itemText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), GoodsListActivity.class);
                    intent.putExtra("id",list.get(position).getSub().get(i).getCate_id());
                    startActivity(intent);
                }
            });

            return view;
        }

        public class Holder {
            public View rootView;
            public TextView itemText;

            public Holder(View rootView) {
                this.rootView = rootView;
                this.itemText = (TextView) rootView.findViewById(R.id.item_text);
            }

        }
    }
}
