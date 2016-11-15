package com.qf.administrator.commodity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.qf.administrator.commodity.bean.MoreGoodsBean;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高超 on 2016/11/14.
 */

public class MoreGoodsFragment extends Fragment {
    private String brand_url = "http://api.danpin.com/index.php?controller=home&action=brandgoods&brand_id=";
    private String brand_after_url = "&page=1&order=";
    private String brand_last_url ="&sort=";
    private RecyclerView rlv;
    private List<MoreGoodsBean.ItemsBean> itemlist=new ArrayList<>();
    private MyMoreGridAdapter adapter;
    private FragmentManager mManager;


    public static MoreGoodsFragment newInstance(String s,String order,String sort) {
        Bundle args = new Bundle();
        args.putString("brand_id",s);
        args.putString("order",order);
        args.putString("sort",sort);
        MoreGoodsFragment fragment = new MoreGoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_moregoods,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mManager=getActivity().getSupportFragmentManager();
        initView(view);
        initData();
        initAdapter();
    }

    private void initAdapter() {
        rlv.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter=new MyMoreGridAdapter();
        rlv.setAdapter(adapter);


    }

    private void initData() {
        String s =getArguments().getString("brand_id");
        String order =getArguments().getString("order");
        String sort =getArguments().getString("sort");
        Log.i("sss", "initData: "+order);
        OkHttpUtils.getInstances().getByEnqueue(getActivity(), brand_url + s + brand_after_url+order+brand_last_url+sort, MoreGoodsBean.class, new OkHttpUtils.GetTextCallback<MoreGoodsBean>() {

            @Override
            public void getText(MoreGoodsBean result) {
                if (result.getItems()!=null){
                    Log.i("sss", "getText: "+result.getItems());
                itemlist.addAll(result.getItems());
                adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getActivity(), "没有更多啦！~！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void initView(View view) {
        rlv= (RecyclerView) view.findViewById(R.id.rlv_moregoods);
    }

    class MyMoreGridAdapter extends RecyclerView.Adapter<MyMoreGridAdapter.MyMoregoodsholder>{

        @Override
        public MyMoregoodsholder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyMoregoodsholder(LayoutInflater.from(getContext()).inflate(R.layout.frag_find_item,parent,false));
        }

        @Override
        public void onBindViewHolder(MyMoregoodsholder holder, final int position) {
            holder.txt_goodsname.setText(itemlist.get(position).getTitle());
            holder.txt_after_price.setText(itemlist.get(position).getCurrency()+itemlist.get(position).getPrice());
            holder.txt_discount.setText(itemlist.get(position).getDiscount());
            holder.txt_discount.setVisibility(View.GONE);
            holder.txt_comefrom.setVisibility(View.GONE);
            holder.txt_biaoqian.setVisibility(View.GONE);
            Glide.with(getActivity()).load(itemlist.get(position).getImgUrl()).into(holder.img_firfrag_goods);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), GoodsInfoActivity.class);
                    intent.putExtra("id",itemlist.get(position).getId());
                    startActivity(intent);
//                    mManager.beginTransaction().replace(R.id.fl_goodsinfo,GoodsInfoFragment.newInstance().commit();
                }
            });


        }

        @Override
        public int getItemCount() {
            return itemlist.size();
        }

        class MyMoregoodsholder extends RecyclerView.ViewHolder{
            private TextView txt_goodsname,  txt_after_price, txt_discount,txt_comefrom,txt_biaoqian;
            private ImageView img_firfrag_goods;

            public MyMoregoodsholder(View itemView) {
                super(itemView);
                txt_goodsname = (TextView) itemView.findViewById(R.id.txt_firfrag_goodsname);
                txt_after_price = (TextView) itemView.findViewById(R.id.txt_firfrag_after_price);
                txt_discount = (TextView) itemView.findViewById(R.id.txt_firfrag_discount);
                img_firfrag_goods = (ImageView) itemView.findViewById(R.id.img_firfrag_goods);
                txt_comefrom = (TextView) itemView.findViewById(R.id.txt_comefrom);
                txt_biaoqian = (TextView) itemView.findViewById(R.id.txt_baioqian);
            }
        }
    }

}
