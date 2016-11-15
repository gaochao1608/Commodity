package com.qf.administrator.commodity.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.fragment.MoreGoodsFragment;

import java.util.ArrayList;
import java.util.List;

public class MoreGoodsActivity extends AppCompatActivity {

    private ActionBar mBar;
    private FragmentManager mManager;
    private List<Fragment> mFragments = new ArrayList<>();
    private String brand_id;
    private TabLayout tb;
    private Boolean isdown=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_goods);
        mManager = getSupportFragmentManager();
        tb= (TabLayout) findViewById(R.id.tb_moregoods);
        Intent intent = getIntent();
         brand_id = intent.getStringExtra("brand_id");
        String brand_name = intent.getStringExtra("brand_name");
        mBar = getSupportActionBar();
        mBar.setTitle(brand_name);
        mBar.setHomeButtonEnabled(true);
        mBar.setDisplayHomeAsUpEnabled(true);
//        mManager.beginTransaction().add(R.id.fl_moregoods, MoreGoodsFragment.newInstance(brand_id)).commit();
        initFragments();
        //TODO  导航栏的实现
        final View view= LayoutInflater.from(this).inflate(R.layout.view_cus_tablayout,null);
        tb.addTab(tb.newTab().setText("相关").setTag(0));
        tb.addTab(tb.newTab().setText("折扣").setTag(1));
        tb.addTab(tb.newTab().setCustomView(view).setTag(2));
        tb.setTabMode(TabLayout.MODE_FIXED);
        tb.setTabGravity(TabLayout.GRAVITY_FILL);
        tb.setSelectedTabIndicatorColor(Color.BLACK);
        tb.setTabTextColors(Color.GRAY,Color.BLACK);
        mManager.beginTransaction().add(R.id.fl_moregoods,mFragments.get(0)).commit();
        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int index =Integer.parseInt(tab.getTag().toString());
                if (mFragments.get(index).isAdded()){
                    mManager.beginTransaction().show(mFragments.get(index)).commit();
                }else {
                    if (index==2){
                        mManager.beginTransaction().add(R.id.fl_moregoods,mFragments.get(3)).commit();
                        mManager.beginTransaction().hide(mFragments.get(3)).commit();
                    }
                    mManager.beginTransaction().add(R.id.fl_moregoods,mFragments.get(index)).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int index =Integer.parseInt(tab.getTag().toString());
                if (index==2){

                mManager.beginTransaction().hide(mFragments.get(3)).commit();
                }
                mManager.beginTransaction().hide(mFragments.get(index)).commit();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int index =Integer.parseInt(tab.getTag().toString());
                ImageView img = (ImageView) view.findViewById(R.id.img_tablayout_price);
                if (isdown&&index==2){
                    img.setImageResource(android.R.drawable.arrow_down_float);
                    mManager.beginTransaction().show(mFragments.get(3)).commit();
                    mManager.beginTransaction().hide(mFragments.get(2)).commit();
                    isdown=false;
                }else {
                    img.setImageResource(android.R.drawable.arrow_up_float);
                    mManager.beginTransaction().hide(mFragments.get(3)).commit();
                    mManager.beginTransaction().show(mFragments.get(2)).commit();
                    isdown=true;
                }



            }
        });

    }

    private void initFragments() {

        mFragments.add(MoreGoodsFragment.newInstance(brand_id,"discount","asc"));
        mFragments.add(MoreGoodsFragment.newInstance(brand_id,"discount","asc"));
        mFragments.add(MoreGoodsFragment.newInstance(brand_id,"price","asc"));
        mFragments.add(MoreGoodsFragment.newInstance(brand_id,"price","desc"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

