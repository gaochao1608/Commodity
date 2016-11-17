package com.qf.administrator.commodity.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.bean.BuyShowBean;
import com.qf.administrator.commodity.bean.CommentBean;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class BuyShowActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvHead;
    private TextView mTvName;
    private TextView mTvMoney;
    private Button mBtAttention;
    private TextView mTvPer;
    private ViewPager mCommentPager;
    private TextView mTvGood;
    private TextView mTvGoodContent;
    private TextView mTvBad;
    private TextView mTvBadContent;
    private TextView mTvOption;
    private TextView mTvOptionContent;
    private RecyclerView mRecycleComment;
    private Button mBtAll;
    private TextView mTvUp;
    private TextView mTvDown;
    private TextView mTvComment;
    private TextView mTvCollect;
    private Button mBtnBuyOnce;
    private RelativeLayout mActivityBuyShow;
    private BuyShowBean.ObjectsBean obj;

    private ArrayList<ImageView> imageList = new ArrayList<>();
    private MyPagerAdapter pagerAdapter;
    private String url = "http://dpapi.mgpyh.com/api/v3/mobilecomment/?device=Android&post_id=option&post_type=show&offset=0";
    private ArrayList<CommentBean.ObjectsBean> commentList = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_show);
        initToolBar();
        initView();
        initData();
        initPagerData();
        initPagerAdapter();
        initRecycleData();
        initRecycleAdapter();
    }

    private void initRecycleData() {
        url = url.replace("option", obj.getId() + "");
        Log.i("tmd", "initRecycleData: "+url);
        OkHttpUtils.getInstances().getByEnqueue(BuyShowActivity.this, url, CommentBean.class,
                new OkHttpUtils.GetTextCallback<CommentBean>() {
                    @Override
                    public void getText(CommentBean result) {
                        if(result!=null){
                            commentList.addAll(result.getObjects());
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    private void initToolBar() {
        ActionBar bar = getSupportActionBar();
        bar.setTitle("晒单详情");
        bar.setHomeButtonEnabled(true);
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(0, 8, 20, "");
        item.setIcon(R.drawable.ic_details_share);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                showShare();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    public void showShare() {
        ShareSDK.initSDK(this);
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
        oks.show(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initPagerData() {
        for (int i = 0; i < obj.getContent().getImages().size(); i++) {
            ImageView image = new ImageView(BuyShowActivity.this);
            Glide.with(BuyShowActivity.this).load(obj.getContent().getImages().get(i).getBig()).into(image);
            imageList.add(image);
        }
        Log.i("tmd", "initPagerDater: " + imageList.size());
    }

    private void initRecycleAdapter() {
        mRecycleComment.setLayoutManager(new LinearLayoutManager(BuyShowActivity.this));
        adapter = new MyAdapter();
        mRecycleComment.setAdapter(adapter);
    }

    private void initPagerAdapter() {
        pagerAdapter = new MyPagerAdapter();
        mCommentPager.setAdapter(pagerAdapter);
    }

    private void initData() {
        obj = (BuyShowBean.ObjectsBean) getIntent().getSerializableExtra("obj");
        Log.i("tmd", "onCreate: " + obj);
        if (obj != null) {
            Glide.with(BuyShowActivity.this).load(obj.getUser().getAvatar()).into(mIvHead);
            mTvName.setText(obj.getUser().getUsername());
            mTvMoney.setText("已认证购物金额" + obj.getUser().getTotal_price() + "元");
            mTvGoodContent.setText(obj.getContent().getGood());
            mTvBadContent.setText(obj.getContent().getBad());
            mTvOptionContent.setText(obj.getContent().getOption());
            mTvComment.setText(obj.getComment_count() + "");
        }
    }

    private void initView() {
        mIvHead = (ImageView) findViewById(R.id.iv_head);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mTvMoney = (TextView) findViewById(R.id.tv_money);
        mBtAttention = (Button) findViewById(R.id.bt_attention);

        mBtAttention.setOnClickListener(this);
        mTvPer = (TextView) findViewById(R.id.tv_per);
        mTvPer.setOnClickListener(this);
        mCommentPager = (ViewPager) findViewById(R.id.comment_pager);
        mCommentPager.setOnClickListener(this);
        mTvGood = (TextView) findViewById(R.id.tv_good);
        mTvGood.setOnClickListener(this);
        mTvGoodContent = (TextView) findViewById(R.id.tv_good_content);
        mTvGoodContent.setOnClickListener(this);
        mTvBad = (TextView) findViewById(R.id.tv_bad);
        mTvBad.setOnClickListener(this);
        mTvBadContent = (TextView) findViewById(R.id.tv_bad_content);
        mTvBadContent.setOnClickListener(this);
        mTvOption = (TextView) findViewById(R.id.tv_option);
        mTvOption.setOnClickListener(this);
        mTvOptionContent = (TextView) findViewById(R.id.tv_option_content);
        mTvOptionContent.setOnClickListener(this);
        mRecycleComment = (RecyclerView) findViewById(R.id.recycle_comment);
        mRecycleComment.setOnClickListener(this);
        mBtAll = (Button) findViewById(R.id.bt_all);
        mBtAll.setOnClickListener(this);
        mTvUp = (TextView) findViewById(R.id.tv_up);
        mTvUp.setOnClickListener(this);
        mTvDown = (TextView) findViewById(R.id.tv_down);
        mTvDown.setOnClickListener(this);
        mTvComment = (TextView) findViewById(R.id.tv_comment);
        mTvComment.setOnClickListener(this);
        mTvCollect = (TextView) findViewById(R.id.tv_collect);
        mTvCollect.setOnClickListener(this);
        mBtnBuyOnce = (Button) findViewById(R.id.btn_buy_once);
        mBtnBuyOnce.setOnClickListener(this);
        mActivityBuyShow = (RelativeLayout) findViewById(R.id.activity_buy_show);
        mActivityBuyShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_attention:
                Toast.makeText(this, "关注成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_up:
                Toast.makeText(this, "你已经赞过了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_down:
                Toast.makeText(this, "你已经....", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_comment:
                startActivity(new Intent(BuyShowActivity.this, CommentActivity.class));
                break;
            case R.id.tv_collect:
                Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_buy_once:
                Intent intent =new Intent(BuyShowActivity.this,RecommendBuyGoodsActivity.class);
                intent.putExtra("source_url1",obj.getSource_url());
                startActivity(intent);
                break;
        }
    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageList.get(position));
            return imageList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageList.get(position));
            super.destroyItem(container, position, object);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(BuyShowActivity.this).inflate(R.layout.item_comment, null));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            Glide.with(BuyShowActivity.this).load(commentList.get(position).getAvatar()).into(holder.ivHead);
            holder.tvName.setText(commentList.get(position).getUsername());
            holder.tvMoney.setText("已认证购物金额"+commentList.get(position).getTotal_price()+"元");
            holder.tvComm.setText(commentList.get(position).getComment());


        }

        @Override
        public int getItemCount() {
            return commentList.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            public View rootView;
            public ImageView ivHead;
            public TextView tvName;
            public TextView tvMoney;
            public TextView tvComm;

            public MyHolder(View itemView) {
                super(itemView);
                this.rootView = itemView;
                this.ivHead = (ImageView) rootView.findViewById(R.id.iv_head);
                this.tvName = (TextView) rootView.findViewById(R.id.tv_name);
                this.tvMoney = (TextView) rootView.findViewById(R.id.tv_money);
                this.tvComm = (TextView) rootView.findViewById(R.id.tv_comm);
            }
        }
    }
}
