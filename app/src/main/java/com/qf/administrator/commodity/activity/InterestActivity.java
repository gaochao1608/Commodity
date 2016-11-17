package com.qf.administrator.commodity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.bean.CategoryAll;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;

public class InterestActivity extends Activity implements View.OnClickListener {

    private Button mBtConform;
    private String url = "http://api.danpin.com/index.php?controller=config&action=global";
    private RecyclerView rcv;
    private MyAdapter adapter;
    private ArrayList<CategoryAll.DataBean.CategoryBean> list = new ArrayList<>();
    private ArrayList<Integer> po = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        initView();
        initData();
        initAdapter();
    }

    private void initData() {
        OkHttpUtils.getInstances().getByEnqueue(InterestActivity.this, url, CategoryAll.class,
                new OkHttpUtils.GetTextCallback<CategoryAll>() {
                    @Override
                    public void getText(CategoryAll result) {
                        list.addAll(result.getData().getCategory());
                        adapter.notifyDataSetChanged();
                    }
                });

    }

    private void initAdapter() {
        rcv.setLayoutManager(new GridLayoutManager(this,3));
        adapter = new MyAdapter();
        rcv.setAdapter(adapter);
    }

    private void initView() {
        mBtConform = (Button) findViewById(R.id.bt_conform);
        rcv = (RecyclerView) findViewById(R.id.recycle_interest);

        mBtConform.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_conform:
                finish();
                break;
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(InterestActivity.this).inflate(R.layout.item_interest, null));
        }

        @Override
        public void onBindViewHolder(final MyHolder holder, final int position) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.width = getResources().getDisplayMetrics().widthPixels/3;
            params.height = getResources().getDisplayMetrics().widthPixels/3;
            holder.ivInterest.setLayoutParams(params);
            Glide.with(InterestActivity.this).load(list.get(position).getPic_small()).into(holder.ivInterest);
            holder.tvInterest.setText(list.get(position).getCate_name());
            if(po.contains(position)){
                holder.cbInterest.setChecked(true);
            }else {
                holder.cbInterest.setChecked(false);
            }
            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(holder.cbInterest.isChecked()){
                        holder.cbInterest.setChecked(false);
                        holder.cbInterest.setVisibility(View.GONE);
                        po.remove(Integer.valueOf(position));
                    }else{
                        if(po.size()==5){
                            Toast.makeText(InterestActivity.this, "最多五个", Toast.LENGTH_SHORT).show();
                        }else {
                            holder.cbInterest.setChecked(true);
                            holder.cbInterest.setVisibility(View.VISIBLE);
                            po.add(position);
                        }
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            public View rootView;
            public ImageView ivInterest;
            public TextView tvInterest;
            public CheckBox cbInterest;
            public MyHolder(View itemView) {
                super(itemView);
                this.rootView = itemView;
                this.ivInterest = (ImageView) rootView.findViewById(R.id.iv_interest);
                this.tvInterest = (TextView) rootView.findViewById(R.id.tv_interest);
                this.cbInterest = (CheckBox) rootView.findViewById(R.id.cb_interest);

            }
        }
    }

}
