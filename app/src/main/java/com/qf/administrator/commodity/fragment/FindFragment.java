package com.qf.administrator.commodity.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.activity.GoodsInfoActivity;
import com.qf.administrator.commodity.bean.Firstfragment_goods_bean;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;


public class FindFragment extends Fragment {

    private RecyclerView rlv;
    private SwipeRefreshLayout sp;
    private MyAdapter adapter;
    private ArrayList<Firstfragment_goods_bean.ItemsBean.DataBean> list = new ArrayList<>();
    private String url = "http://api.danpin.com/index.php?controller=home&action=main&category=&page=";
    private static final String TAG = "tmd";
    private GridLayoutManager manager;
    private int pager = 1;

    public static FindFragment newInstance() {

        Bundle args = new Bundle();

        FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();

        initAdapter();
        sp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                Log.i(TAG, "onRefresh: " + list);
                pager = 1;
                initData();
                Log.i(TAG, "onRefresh: " + pager);
                adapter.notifyDataSetChanged();
                sp.setRefreshing(false);
            }
        });

        rlv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public int lastvisitemposition;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                sp.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastvisitemposition + 1 == adapter.getItemCount()) {
                    pager++;
                    initData();
                    adapter.notifyDataSetChanged();
                }
                if (list.size()==0){
                    Toast.makeText(getContext(), "网络无连接", Toast.LENGTH_SHORT).show();
                    sp.setRefreshing(false);
                }


            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastvisitemposition = manager.findLastVisibleItemPosition();
            }
        });
    }

    private void initView(View view) {
        rlv = (RecyclerView) view.findViewById(R.id.rlv_firstfrag);
        sp = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);

    }

    private void initAdapter() {
        manager = new GridLayoutManager(getContext(), 2);
        rlv.setLayoutManager(manager);
        adapter = new MyAdapter();
        rlv.setAdapter(adapter);

    }

    private void initData() {
        Log.i(TAG, "initData: ++++++++++");
        OkHttpUtils.getInstances().getByEnqueue(getActivity(),url+pager,Firstfragment_goods_bean.class,new OkHttpUtils.GetTextCallback<Firstfragment_goods_bean>(){
            @Override
            public void getText(Firstfragment_goods_bean result) {
                for (int i = 0; i < 9; i++) {
                    list.addAll(result.getItems().get(i).getData());
                    Log.i(TAG, "getText: " + list);

                }
                adapter.notifyDataSetChanged();
            }
        });

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {


        @Override
        public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Myholder(LayoutInflater.from(getContext()).inflate(R.layout.frag_find_item, parent, false));
        }

        @Override
        public void onBindViewHolder(Myholder holder, final int position) {
            holder.txt_goodsname.setText(list.get(position).getTitle());
            holder.txt_after_price.setText(list.get(position).getCurrency() + list.get(position).getPrice());
            holder.txt_before_price.setText(list.get(position).getCurrency() + list.get(position).getLabelPrice());
            if (list.get(position).getDiscount()==""){
                holder.txt_discount.setVisibility(View.GONE);
            }else {
            holder.txt_discount.setText(list.get(position).getDiscount());

            }
            holder.txt_cate_name.setText(list.get(position).getCate_name());
            Glide.with(getActivity()).load(list.get(position).getImgUrl()).into(holder.img_firfrag_goods);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), GoodsInfoActivity.class);
                    intent.putExtra("id", list.get(position).getId());
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class Myholder extends RecyclerView.ViewHolder {
            //cate_name是标签类型的名字
            private TextView txt_goodsname, txt_before_price, txt_after_price, txt_discount, txt_cate_name;
            private ImageView img_firfrag_goods;


            public Myholder(View itemView) {
                super(itemView);
                txt_goodsname = (TextView) itemView.findViewById(R.id.txt_firfrag_goodsname);
                txt_before_price = (TextView) itemView.findViewById(R.id.txt_firfrag_before_price);
                txt_after_price = (TextView) itemView.findViewById(R.id.txt_firfrag_after_price);
                txt_discount = (TextView) itemView.findViewById(R.id.txt_firfrag_discount);
                txt_cate_name = (TextView) itemView.findViewById(R.id.txt_firfrag_cate_name);
                img_firfrag_goods = (ImageView) itemView.findViewById(R.id.img_firfrag_goods);
            }
        }
    }
}
