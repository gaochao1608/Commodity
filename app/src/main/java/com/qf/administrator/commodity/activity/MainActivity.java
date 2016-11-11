package com.qf.administrator.commodity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.qf.administrator.commodity.CircleImageView;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.fragment.BuyshowFragment;
import com.qf.administrator.commodity.fragment.CategoryFragment;
import com.qf.administrator.commodity.fragment.FindFragment;
import com.qf.administrator.commodity.fragment.RecommendFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private String[] title = {"找单品", "编辑推", "买家秀", "全品类"};
    private CircleImageView mIvHead;
    private ImageView mIvFind;
    private RelativeLayout mRlHead;
    private ImageView mBigMap;
    private CircleImageView mBtHead;
    private Button mBtHome;
    private Button mBtMessage;
    private Button mBtOrder;
    private Button mBtBalance;
    private Button mBtAddress;
    private LinearLayout mLlFirst;
    private Button mBtCamera;
    private Button mBtComment;
    private Button mBtLike;
    private Button mBtFollow;
    private Button mBtFans;
    private LinearLayout mLlSecond;
    private Button mBtPush;
    private Button mBtPushTime;
    private Button mBtContext;
    private Button mBtMark;
    private Button mBtPoint;
    private Button mBtGetPoint;
    private Button mBtVersion;
    private DrawerLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        adapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setTabTextColors(getResources().getColor(R.color.white), getResources().getColor(R.color.dackwhite));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initData() {
        list.add(FindFragment.newInstance());
        list.add(RecommendFragment.newInstance());
        list.add(BuyshowFragment.newInstance());
        list.add(CategoryFragment.newInstance());
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mIvHead = (CircleImageView) findViewById(R.id.iv_head);
        mIvHead.setOnClickListener(this);
        mIvHead.setOnClickListener(this);
        mIvFind = (ImageView) findViewById(R.id.iv_find);
        mIvFind.setOnClickListener(this);
        mRlHead = (RelativeLayout) findViewById(R.id.rl_head);
        mRlHead.setOnClickListener(this);
        mBigMap = (ImageView) findViewById(R.id.big_map);
        mBigMap.setOnClickListener(this);
        mBtHead = (CircleImageView) findViewById(R.id.bt_head);
        mBtHead.setOnClickListener(this);
        mBtHome = (Button) findViewById(R.id.bt_home);
        mBtHome.setOnClickListener(this);
        mBtMessage = (Button) findViewById(R.id.bt_message);
        mBtMessage.setOnClickListener(this);
        mBtOrder = (Button) findViewById(R.id.bt_order);
        mBtOrder.setOnClickListener(this);
        mBtBalance = (Button) findViewById(R.id.bt_balance);
        mBtBalance.setOnClickListener(this);
        mBtAddress = (Button) findViewById(R.id.bt_address);
        mBtAddress.setOnClickListener(this);
        mLlFirst = (LinearLayout) findViewById(R.id.ll_first);
        mLlFirst.setOnClickListener(this);
        mBtCamera = (Button) findViewById(R.id.bt_camera);
        mBtCamera.setOnClickListener(this);
        mBtComment = (Button) findViewById(R.id.bt_comment);
        mBtComment.setOnClickListener(this);
        mBtLike = (Button) findViewById(R.id.bt_like);
        mBtLike.setOnClickListener(this);
        mBtFollow = (Button) findViewById(R.id.bt_follow);
        mBtFollow.setOnClickListener(this);
        mBtFans = (Button) findViewById(R.id.bt_fans);
        mBtFans.setOnClickListener(this);
        mLlSecond = (LinearLayout) findViewById(R.id.ll_second);
        mLlSecond.setOnClickListener(this);
        mBtPush = (Button) findViewById(R.id.bt_push);
        mBtPush.setOnClickListener(this);
        mBtPushTime = (Button) findViewById(R.id.bt_push_time);
        mBtPushTime.setOnClickListener(this);
        mBtContext = (Button) findViewById(R.id.bt_context);
        mBtContext.setOnClickListener(this);
        mBtMark = (Button) findViewById(R.id.bt_mark);
        mBtMark.setOnClickListener(this);
        mBtPoint = (Button) findViewById(R.id.bt_point);
        mBtPoint.setOnClickListener(this);
        mBtGetPoint = (Button) findViewById(R.id.bt_get_point);
        mBtGetPoint.setOnClickListener(this);
        mBtVersion = (Button) findViewById(R.id.bt_version);
        mBtVersion.setOnClickListener(this);
        mActivityMain = (DrawerLayout) findViewById(R.id.activity_main);
        mActivityMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_head:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_home:
                //隐藏侧滑
                break;
            case R.id.bt_message:
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_order:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_balance:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_address:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_camera:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_comment:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_like:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_follow:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_fans:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_push:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_push_time:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_context:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_mark:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_point:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_get_point:
                //跳转
                startActivity(new Intent(MainActivity.this,PointActivity.class));
                break;
            case R.id.bt_version:
                Toast.makeText(this, "已经最新版本了", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    class MyAdapter extends FragmentStatePagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
