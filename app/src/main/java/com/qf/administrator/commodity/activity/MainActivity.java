package com.qf.administrator.commodity.activity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.qf.administrator.commodity.myview.CircleImageView;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.fragment.BuyShowFragment;
import com.qf.administrator.commodity.fragment.CategoryFragment;
import com.qf.administrator.commodity.fragment.FindFragment;
import com.qf.administrator.commodity.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

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
    private SharedPreferences pref;
    private CircleImageView mCivHead;
    private TextView mTvClick;
    private TextView mStartTime;
    private TextView mEndTime;
    private Switch mBtSwitch;
    private int i;
    private int i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("login", MODE_PRIVATE);
        JPushInterface.init(this);
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
        list.add(BuyShowFragment.newInstance());
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
        mBtHead = (CircleImageView) findViewById(R.id.civ_head);
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
        mCivHead = (CircleImageView) findViewById(R.id.civ_head);
        mCivHead.setOnClickListener(this);
        mTvClick = (TextView) findViewById(R.id.tv_click);
        if (!pref.getString("name", "").equals("")) {
            mTvClick.setText("您已登录");
        }
        mStartTime = (TextView) findViewById(R.id.start_time);
        mStartTime.setOnClickListener(this);
        mEndTime = (TextView) findViewById(R.id.end_time);
        mEndTime.setOnClickListener(this);
        mBtSwitch = (Switch) findViewById(R.id.bt_switch);
        mBtSwitch.setChecked(true);
        mBtSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    JPushInterface.resumePush(MainActivity.this);
                }else{
                    JPushInterface.stopPush(MainActivity.this);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (pref.getString("name", "").equals("")) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        } else {
            switch (v.getId()) {
                case R.id.civ_head:
                case R.id.iv_head:
                    Toast.makeText(this, "您已登录", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder ab = new AlertDialog.Builder(this);
                    // 2. 设置各种信息
                    ab.setTitle("登录");
                    ab.setMessage("你要重新登陆吗？");
                    ab.setCancelable(false);
                    // 确定按钮
                    ab.setPositiveButton("重新登录", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            SharedPreferences.Editor edit = pref.edit();
                            edit.putString("name", "");
                            edit.putString("pass", "");
                            edit.commit();
                            mTvClick.setText("点击头像登录");
                            Toast.makeText(MainActivity.this, "您已取消登录，请重新登录", Toast.LENGTH_SHORT).show();
                        }
                    });
                    ab.setNegativeButton("取消", null);
                    ab.show();
                    break;
                case R.id.bt_message:
                    Intent message = new Intent(MainActivity.this, EmptyActivity.class);
                    message.putExtra("come", "消息");
                    startActivity(message);
                    break;
                case R.id.bt_order:
                    Intent order = new Intent(MainActivity.this, EmptyActivity.class);
                    order.putExtra("come", "订单");
                    startActivity(order);
                    break;
                case R.id.bt_balance:
                    Intent balance = new Intent(MainActivity.this, EmptyActivity.class);
                    balance.putExtra("come", "余额");
                    startActivity(balance);
                    break;
                case R.id.bt_address:
                    Intent address = new Intent(MainActivity.this, EmptyActivity.class);
                    address.putExtra("come", "地址");
                    startActivity(address);
                    break;
                case R.id.bt_camera:
                    Intent camera = new Intent(MainActivity.this, EmptyActivity.class);
                    camera.putExtra("come", "晒单");
                    startActivity(camera);
                    break;
                case R.id.bt_comment:
                    Intent comment = new Intent(MainActivity.this, EmptyActivity.class);
                    comment.putExtra("come", "评论");
                    startActivity(comment);
                    break;
                case R.id.bt_like:
                    Intent like = new Intent(MainActivity.this, EmptyActivity.class);
                    like.putExtra("come", "收藏");
                    startActivity(like);
                    break;
                case R.id.bt_follow:
                    Intent follow = new Intent(MainActivity.this, EmptyActivity.class);
                    follow.putExtra("come", "关注");
                    startActivity(follow);
                    break;
                case R.id.bt_fans:
                    Intent fans = new Intent(MainActivity.this, EmptyActivity.class);
                    fans.putExtra("come", "粉丝");
                    startActivity(fans);
                    break;
                case R.id.bt_push_time:

                    TimePickerDialog tpd2 = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            MainActivity.this.i1=i;
                            mEndTime.setText(i + ":00--");
                        }
                    }, 8, 0, true);
                    tpd2.setTitle("结束时间");
                    tpd2.show();
                    TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            MainActivity.this.i=i;
                            mStartTime.setText(i + ":00");
                        }
                    }, 8, 0, true);
                    tpd.setTitle("开始时间");
                    tpd.show();
                    Set<Integer> set = new HashSet<>();
                    set.add(0);
                    set.add(6);
                    JPushInterface.setPushTime(this,set,i,i1);
                    break;
                case R.id.bt_context:
//                    Intent intent=new Intent();
//                    intent.setAction(Intent.ACTION_DIAL);
//                    intent.setData(Uri.parse("tel:1320010001"));
//                    startActivity(intent);
                    break;
                case R.id.bt_mark:
                    Intent mark = new Intent(MainActivity.this, EmptyActivity.class);
                    mark.putExtra("come", "评分");
                    startActivity(mark);
                    break;
                case R.id.bt_point:
                    Intent point = new Intent(MainActivity.this, EmptyActivity.class);
                    point.putExtra("come", "积分");
                    startActivity(point);
                    break;
                case R.id.bt_get_point:
                    //跳转
                    startActivity(new Intent(MainActivity.this, PointActivity.class));
                    break;
                case R.id.bt_version:
                    Toast.makeText(this, "已经最新版本了", Toast.LENGTH_SHORT).show();
                    break;
            }
            //隐藏
            mActivityMain.closeDrawers();
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
