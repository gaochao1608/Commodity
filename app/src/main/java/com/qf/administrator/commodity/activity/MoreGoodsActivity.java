package com.qf.administrator.commodity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.MenuItem;

import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.fragment.MoreGoodsFragment;

public class MoreGoodsActivity extends FragmentActivity {

    private android.app.ActionBar mBar;
    private FragmentManager mManager;
    private FragmentTabHost fth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_goods);
        mManager = getSupportFragmentManager();
        fth= (FragmentTabHost) findViewById(android.R.id.tabhost);
        fth.setup(this,getSupportFragmentManager(),R.id.fl_moregoods);
        Intent intent = getIntent();
        String brand_id = intent.getStringExtra("brand_id");
        String brand_name = intent.getStringExtra("brand_name");
        mBar = getActionBar();
        mBar.setTitle(brand_name);
        mBar.setHomeButtonEnabled(true);
        mBar.setDisplayHomeAsUpEnabled(true);
//        mManager.beginTransaction().add(R.id.fl_moregoods, MoreGoodsFragment.newInstance(brand_id)).commit();
        //TODO  导航栏的实现
        Bundle bundle =new Bundle();
        bundle.putString("brand_id",brand_id);
        fth.addTab(fth.newTabSpec("about").setIndicator("相关"), MoreGoodsFragment.class,null);
        fth.addTab(fth.newTabSpec("discount").setIndicator("折扣"), MoreGoodsFragment.class,null);
        fth.addTab(fth.newTabSpec("price").setIndicator("价格"), MoreGoodsFragment.class,null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

