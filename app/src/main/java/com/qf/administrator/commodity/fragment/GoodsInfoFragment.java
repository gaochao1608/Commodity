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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.activity.MoreGoodsActivity;
import com.qf.administrator.commodity.bean.Goods_info_bean;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高超 on 2016/11/12.
 */

public class GoodsInfoFragment extends Fragment implements View.OnClickListener{
    private String url_goodsinfo = "http://api.danpin.com/index.php?controller=home&action=detail&id=";

    private CheckBox cb_zan;
    private CheckBox cb_cai;
    private ImageView img_share;
    private CheckBox cb_like;
    private Button btn_buyonce;

    private TextView txt_goodsinfo_goodsname;
    private TextView txt_goodsinfo_after_price;
    private TextView txt_goodsinfo_before_price;
    private TextView txt_goodsinfo_discount;
    private TextView txt_goodsinfo_more;
    private TextView txt_goodsinfo_user;
    private TextView txt_goodsinfo_zan;
    private TextView txt_comment_user;
    private TextView comment_time;
    private TextView comment;
    private TextView txt_content;
    private ImageView img_goods_img;
    private ImageView img_goods_buy;
    private RecyclerView rlv_more;
    private ScrollView sv;

    private TextView txt_brand_title;
    private ImageView img_scroll;
    private List<Goods_info_bean.DataBean.RelatedItemsBean.ItemsBean> iblist=new ArrayList<>();
    private MyMoreAdapter adapter;
    private static final String TAG = "sos";
    private FragmentManager maanger;

    public static GoodsInfoFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt("id",id);
        GoodsInfoFragment fragment = new GoodsInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_goodsinfo,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         maanger=getActivity().getSupportFragmentManager();
        initView(view);
       int id=  getArguments().getInt("id");
        iniData(id);

        initAdapter();
    }

    private void initAdapter() {
        rlv_more.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter=new MyMoreAdapter();
        rlv_more.setAdapter(adapter);
    }
    private void iniData(int id) {
        Log.i("tmddd", "iniData: "+url_goodsinfo + id);
        OkHttpUtils.getInstances().getByEnqueue(getActivity(), url_goodsinfo + id, Goods_info_bean.class, new OkHttpUtils.GetTextCallback<Goods_info_bean>() {

            @Override
            public void getText(final Goods_info_bean result) {
                Log.i(TAG, "getText: "+result);
                iblist.addAll(result.getData().getRelated_items().getItems());
                txt_goodsinfo_goodsname.setText(result.getData().getTitle());
                txt_goodsinfo_after_price.setText(result.getData().getPrice());
                txt_goodsinfo_before_price.setText(result.getData().getOprice());
                txt_goodsinfo_discount.setText(result.getData().getDiscount());
                txt_goodsinfo_user.setText(result.getData().getAction().getUp_down_last().getNick_name());
                txt_goodsinfo_zan.setText(result.getData().getAction().getUp_down().getUp());
                txt_comment_user.setText(result.getData().getComments().get(0).getNick_name());
                txt_brand_title.setText(result.getData().getBrand_content());
                comment_time.setText(result.getData().getComments().get(0).getComment_date());
                comment.setText(result.getData().getComments().get(0).getComment_text());
                txt_content.setText(result.getData().getBrand_content());
                Glide.with(getActivity()).load(result.getData().getShare().getImg()).into(img_goods_img);
                Glide.with(getActivity()).load(result.getData().getShare().getImg()).into(img_scroll);
                Glide.with(getActivity()).load(result.getData().getBuy_flow_pic()).into(img_goods_buy);
                Log.i(TAG, "getText: "+iblist);
                adapter.notifyDataSetChanged();
                txt_goodsinfo_more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(getContext(), MoreGoodsActivity.class);
                        intent.putExtra("brand_id",result.getData().getBrand_id());
                        intent.putExtra("brand_name",result.getData().getBrand_name());
                        startActivity(intent);
                    }
                });





            }
        });
    }
    private void initView(View v) {
        cb_zan = (CheckBox) v.findViewById(R.id.cb_zan);
        cb_cai = (CheckBox) v.findViewById(R.id.cb_cai);
        img_share = (ImageView) v.findViewById(R.id.img_share);
        cb_like = (CheckBox) v.findViewById(R.id.cb_like);
        btn_buyonce = (Button) v.findViewById(R.id.btn_buyonce);
        txt_goodsinfo_goodsname = (TextView) v.findViewById(R.id.txt_goodsinfo_goodsname);
        txt_goodsinfo_after_price = (TextView)v.findViewById(R.id.txt_goodsinfo_after_price);
        txt_goodsinfo_before_price = (TextView) v.findViewById(R.id.txt_goodsinfo_before_price);
        txt_goodsinfo_discount = (TextView) v.findViewById(R.id.txt_goodsinfo_discount);
        txt_goodsinfo_more = (TextView) v.findViewById(R.id.txt_goodsinfo_more);
        txt_goodsinfo_user = (TextView) v.findViewById(R.id.txt_goodsinfo_user);
        txt_goodsinfo_zan = (TextView) v.findViewById(R.id.txt_goodsinfo_zan);
        txt_comment_user = (TextView) v.findViewById(R.id.txt_comment_user);
        comment_time = (TextView) v.findViewById(R.id.comment_time);
        comment = (TextView)v.findViewById(R.id.comment);
        txt_content = (TextView) v.findViewById(R.id.txt_content);
        img_goods_img = (ImageView) v.findViewById(R.id.img_goods_img);
        img_goods_buy = (ImageView) v.findViewById(R.id.img_goods_buy);
        rlv_more = (RecyclerView) v.findViewById(R.id.rlv_more);
        txt_brand_title = (TextView) v.findViewById(R.id.txt_brand_title);
        img_scroll = (ImageView) v.findViewById(R.id.img_scroll);
        sv = (ScrollView) v.findViewById(R.id.sv);

        img_share.setOnClickListener(this);
        btn_buyonce.setOnClickListener(this);
        txt_goodsinfo_more.setOnClickListener(this);
        txt_brand_title.setOnClickListener(this);
        img_scroll.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_share:

                break;
            case R.id.btn_buyonce:

                break;
            case R.id.txt_goodsinfo_more:

                break;
        }
    }
    class MyMoreAdapter extends RecyclerView.Adapter<MyMoreAdapter.MyMoreHolder>{

        @Override
        public MyMoreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyMoreHolder(LayoutInflater.from(getContext()).inflate(R.layout.frag_find_item,parent,false));
        }

        @Override
        public void onBindViewHolder(MyMoreHolder holder, final int position) {
            holder.txt_goodsname.setText(iblist.get(position).getTitle());
            holder.txt_after_price.setText(iblist.get(position).getCurrency()+iblist.get(position).getPrice());
            holder.txt_before_price.setText(iblist.get(position).getCurrency()+iblist.get(position).getLabelPrice());
            holder.txt_discount.setText(iblist.get(position).getDiscount());
            holder.txt_cate_name.setText(iblist.get(position).getCate_name());
            holder.txt_comefrom.setVisibility(View.GONE);
            holder.txt_biaoqian.setVisibility(View.GONE);
            Glide.with(getActivity()).load(iblist.get(position).getImgUrl()).into(holder.img_firfrag_goods);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemid=iblist.get(position).getId();
                    maanger.beginTransaction().replace(R.id.fl_goodsinfo, GoodsInfoFragment.newInstance(itemid)).commit();



                }
            });

        }


        @Override
        public int getItemCount() {
            return iblist.size();
        }

        class MyMoreHolder extends RecyclerView.ViewHolder{
            private TextView txt_goodsname,txt_before_price,txt_after_price,txt_discount,txt_cate_name,txt_comefrom,txt_biaoqian;
            private ImageView img_firfrag_goods;

            public MyMoreHolder(View itemView) {
                super(itemView);
                txt_goodsname= (TextView) itemView.findViewById(R.id.txt_firfrag_goodsname);
                txt_before_price= (TextView) itemView.findViewById(R.id.txt_firfrag_before_price);
                txt_after_price= (TextView) itemView.findViewById(R.id.txt_firfrag_after_price);
                txt_discount= (TextView) itemView.findViewById(R.id.txt_firfrag_discount);
                txt_cate_name= (TextView) itemView.findViewById(R.id.txt_firfrag_cate_name);
                img_firfrag_goods= (ImageView) itemView.findViewById(R.id.img_firfrag_goods);
                txt_comefrom = (TextView) itemView.findViewById(R.id.txt_comefrom);
                txt_biaoqian = (TextView) itemView.findViewById(R.id.txt_baioqian);
            }
        }
    }
}
