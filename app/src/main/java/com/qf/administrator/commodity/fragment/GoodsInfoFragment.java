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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.activity.CommentActivity;
import com.qf.administrator.commodity.activity.CommentCaiActivity;
import com.qf.administrator.commodity.activity.MoreGoodsActivity;
import com.qf.administrator.commodity.bean.Goods_info_bean;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by 高超 on 2016/11/12.
 */

public class GoodsInfoFragment extends Fragment implements View.OnClickListener {
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
    private TextView txt_comment_user,txt_pingjia;
    private TextView comment_time;
    private TextView comment;
    private TextView txt_content;
    private ImageView img_goods_img,img_user_icon;
    private ImageView img_goods_buy;
    private RecyclerView rlv_more;
    private ScrollView sv;
    private View line;

    private TextView txt_brand_title;
    private ImageView img_scroll;
    private List<Goods_info_bean.DataBean.RelatedItemsBean.ItemsBean> iblist = new ArrayList<>();
    private MyMoreAdapter adapter;
    private static final String TAG = "sos";
    private FragmentManager maanger;
    private Boolean flag = true;

    public static GoodsInfoFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt("id", id);
        GoodsInfoFragment fragment = new GoodsInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_goodsinfo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        maanger = getActivity().getSupportFragmentManager();
        initView(view);
        int id = getArguments().getInt("id");
        iniData(id);

        initAdapter();
        //TODO 点赞等操作
        cb_zan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_zan.isChecked()) {
                    cb_cai.setChecked(false);
                    startActivity(new Intent(getActivity(), CommentActivity.class));

                }
            }
        });
        cb_cai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_cai.isChecked()) {
                    cb_zan.setChecked(false);
                    startActivity(new Intent(getActivity(), CommentCaiActivity.class));
                }
            }
        });
        cb_like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_like.isChecked()){
                    Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getActivity(), "取消收藏", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initAdapter() {
        rlv_more.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new MyMoreAdapter();
        rlv_more.setAdapter(adapter);
    }

    private void iniData(final int id) {
        OkHttpUtils.getInstances().getByEnqueue(getActivity(), url_goodsinfo + id, Goods_info_bean.class, new OkHttpUtils.GetTextCallback<Goods_info_bean>() {

            @Override
            public void getText(final Goods_info_bean result) {
                Log.i(TAG, "getText: " + result);
                iblist.addAll(result.getData().getRelated_items().getItems());
                txt_goodsinfo_goodsname.setText(result.getData().getTitle());
                if (result.getData().getOprice()==""){
                    line.setVisibility(View.GONE);
                }else {
                txt_goodsinfo_before_price.setText(result.getData().getOprice());
                }
                txt_goodsinfo_after_price.setText(result.getData().getPrice());
                if (result.getData().getDiscount()==""){
                    txt_goodsinfo_discount.setVisibility(View.GONE);
                }else {

                txt_goodsinfo_discount.setText(result.getData().getDiscount());
                }
                txt_goodsinfo_user.setText(result.getData().getAction().getUp_down_last().getNick_name());
                if (result.getData().getComments().size()!= 0) {
                    txt_comment_user.setText(result.getData().getComments().get(0).getNick_name());
                    comment_time.setText(result.getData().getComments().get(0).getComment_date());
                    comment.setText(result.getData().getComments().get(0).getComment_text());
                    Glide.with(getActivity()).load(result.getData().getComments().get(0).getFace_image()).into(img_user_icon);
                } else {

                    txt_pingjia.setVisibility(View.VISIBLE);

                }

                txt_goodsinfo_zan.setText(result.getData().getAction().getUp_down().getUp());
                txt_brand_title.setText(result.getData().getBrand_content());

                txt_content.setText(result.getData().getBrand_content());
                Glide.with(getActivity()).load(result.getData().getShare().getImg()).into(img_goods_img);
                Glide.with(getActivity()).load(result.getData().getShare().getImg()).into(img_scroll);
                Glide.with(getActivity()).load(result.getData().getBuy_flow_pic()).into(img_goods_buy);
                Log.i(TAG, "getText: " + iblist);
                adapter.notifyDataSetChanged();
                txt_goodsinfo_more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), MoreGoodsActivity.class);
                        intent.putExtra("brand_id", result.getData().getBrand_id());
                        intent.putExtra("brand_name", result.getData().getBrand_name());
                        startActivity(intent);
                    }
                });
                img_share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showShare();
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
        txt_goodsinfo_after_price = (TextView) v.findViewById(R.id.txt_goodsinfo_after_price);
        txt_goodsinfo_before_price = (TextView) v.findViewById(R.id.txt_goodsinfo_before_price);
        txt_goodsinfo_discount = (TextView) v.findViewById(R.id.txt_goodsinfo_discount);
        txt_goodsinfo_more = (TextView) v.findViewById(R.id.txt_goodsinfo_more);
        txt_goodsinfo_user = (TextView) v.findViewById(R.id.txt_goodsinfo_user);
        txt_goodsinfo_zan = (TextView) v.findViewById(R.id.txt_goodsinfo_zan);
        txt_comment_user = (TextView) v.findViewById(R.id.txt_comment_user);
        comment_time = (TextView) v.findViewById(R.id.comment_time);
        comment = (TextView) v.findViewById(R.id.comment);
        txt_content = (TextView) v.findViewById(R.id.txt_content);
        img_goods_img = (ImageView) v.findViewById(R.id.img_goods_img);
        img_goods_buy = (ImageView) v.findViewById(R.id.img_goods_buy);
        rlv_more = (RecyclerView) v.findViewById(R.id.rlv_more);
        txt_brand_title = (TextView) v.findViewById(R.id.txt_brand_title);
        img_scroll = (ImageView) v.findViewById(R.id.img_scroll);
        sv = (ScrollView) v.findViewById(R.id.sv);
        img_user_icon= (ImageView) v.findViewById(R.id.img_user_icon);
        txt_pingjia= (TextView) v.findViewById(R.id.txt_pingjia);
        line=v.findViewById(R.id.view_line);

        img_share.setOnClickListener(this);
        btn_buyonce.setOnClickListener(this);
        txt_goodsinfo_more.setOnClickListener(this);
        txt_brand_title.setOnClickListener(this);
        img_scroll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_buyonce:

                break;

        }
    }

    class MyMoreAdapter extends RecyclerView.Adapter<MyMoreAdapter.MyMoreHolder> {

        @Override
        public MyMoreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyMoreHolder(LayoutInflater.from(getContext()).inflate(R.layout.frag_find_item, parent, false));
        }

        @Override
        public void onBindViewHolder(MyMoreHolder holder, final int position) {
            holder.txt_goodsname.setText(iblist.get(position).getTitle());
            holder.txt_after_price.setText(iblist.get(position).getCurrency() + iblist.get(position).getPrice());
            holder.txt_before_price.setText(iblist.get(position).getCurrency() + iblist.get(position).getLabelPrice());
            holder.txt_discount.setVisibility(View.GONE);
            holder.txt_cate_name.setText(iblist.get(position).getCate_name());
            holder.txt_comefrom.setVisibility(View.GONE);
            holder.txt_biaoqian.setVisibility(View.GONE);
            Glide.with(getActivity()).load(iblist.get(position).getImgUrl()).into(holder.img_firfrag_goods);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemid = iblist.get(position).getId();
                    maanger.beginTransaction().replace(R.id.fl_goodsinfo, GoodsInfoFragment.newInstance(itemid)).commit();


                }
            });

        }


        @Override
        public int getItemCount() {
            return iblist.size();
        }

        class MyMoreHolder extends RecyclerView.ViewHolder {
            private TextView txt_goodsname, txt_before_price, txt_after_price, txt_discount, txt_cate_name, txt_comefrom, txt_biaoqian;
            private ImageView img_firfrag_goods;

            public MyMoreHolder(View itemView) {
                super(itemView);
                txt_goodsname = (TextView) itemView.findViewById(R.id.txt_firfrag_goodsname);
                txt_before_price = (TextView) itemView.findViewById(R.id.txt_firfrag_before_price);
                txt_after_price = (TextView) itemView.findViewById(R.id.txt_firfrag_after_price);
                txt_discount = (TextView) itemView.findViewById(R.id.txt_firfrag_discount);
                txt_cate_name = (TextView) itemView.findViewById(R.id.txt_firfrag_cate_name);
                img_firfrag_goods = (ImageView) itemView.findViewById(R.id.img_firfrag_goods);
                txt_comefrom = (TextView) itemView.findViewById(R.id.txt_comefrom);
                txt_biaoqian = (TextView) itemView.findViewById(R.id.txt_baioqian);
            }
        }
    }

    public void showShare() {
        ShareSDK.initSDK(getContext());
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");
        // 启动分享GUI
        oks.show(getContext());
    }
}
