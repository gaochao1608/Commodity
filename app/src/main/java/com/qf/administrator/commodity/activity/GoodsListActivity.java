package com.qf.administrator.commodity.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.bean.GoodsListBean;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;

public class GoodsListActivity extends Activity {

    private RecyclerView rlv;
    private SwipeRefreshLayout sp;
    private String url = "http://api.danpin.com/index.php?controller=list&action=getCategoryData&level=0&id=";
    private MyAdapter adapter;
    private static final String TAG = "tmd";
    private ArrayList<GoodsListBean.ItemsBean> list=new ArrayList<>();
    private GridLayoutManager manager;
    private int pager=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_find);
        String id = getIntent().getStringExtra("id");
        url = url+id+"&page=";
        initView();
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
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastvisitemposition = manager.findLastVisibleItemPosition();
            }
        });
    }

    private void initView() {
        rlv = (RecyclerView) findViewById(R.id.rlv_firstfrag);
        sp = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
    }
    private void initAdapter() {
        manager=new GridLayoutManager(GoodsListActivity.this,2);
        rlv.setLayoutManager(manager);
        adapter=new MyAdapter();
        rlv.setAdapter(adapter);

    }

    private void initData() {
        Log.i(TAG, "initData: ++++++++++");
        OkHttpUtils.getInstances().getByEnqueue(GoodsListActivity.this,url+pager,GoodsListBean.class,
                new OkHttpUtils.GetTextCallback<GoodsListBean>(){
            @Override
            public void getText(GoodsListBean result) {
                for (int i = 0; i < 9; i++) {
                    list.addAll(result.getItems());
                    Log.i(TAG, "getText: "+list);

                }
                adapter.notifyDataSetChanged();
            }
        });

    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{


        @Override
        public MyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyAdapter.MyHolder(LayoutInflater.from(GoodsListActivity.this).inflate(R.layout.frag_find_item,parent,false));
        }

        @Override
        public void onBindViewHolder(MyAdapter.MyHolder holder, final int position) {
            holder.txt_goodsname.setText(list.get(position).getTitle());
            holder.txt_after_price.setText(list.get(position).getCurrency()+list.get(position).getPrice());
            holder.txt_before_price.setText(list.get(position).getCurrency()+list.get(position).getLabelPrice());
            holder.txt_discount.setText(list.get(position).getDiscount());
            holder.txt_cate_name.setText(list.get(position).getCate_name());
            Glide.with(GoodsListActivity.this).load(list.get(position).getImgUrl()).into(holder.img_firfrag_goods);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(GoodsListActivity.this,GoodsInfoActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            //cate_name是标签类型的名字
            private TextView txt_goodsname,txt_before_price,txt_after_price,txt_discount,txt_cate_name;
            private ImageView img_firfrag_goods;


            public MyHolder(View itemView) {
                super(itemView);
                txt_goodsname= (TextView) itemView.findViewById(R.id.txt_firfrag_goodsname);
                txt_before_price= (TextView) itemView.findViewById(R.id.txt_firfrag_before_price);
                txt_after_price= (TextView) itemView.findViewById(R.id.txt_firfrag_after_price);
                txt_discount= (TextView) itemView.findViewById(R.id.txt_firfrag_discount);
                txt_cate_name= (TextView) itemView.findViewById(R.id.txt_firfrag_cate_name);
                img_firfrag_goods= (ImageView) itemView.findViewById(R.id.img_firfrag_goods);
            }
        }
    }
}
