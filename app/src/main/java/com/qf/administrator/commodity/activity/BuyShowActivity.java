package com.qf.administrator.commodity.activity;


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

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.bean.BuyShowBean;
import com.qf.administrator.commodity.bean.CommentBean;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;

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
        initActionBar();
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

    private void initActionBar() {
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
        return super.onCreateOptionsMenu(menu);
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

                break;
            case R.id.bt_all:

                break;
            case R.id.btn_buy_once:
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
