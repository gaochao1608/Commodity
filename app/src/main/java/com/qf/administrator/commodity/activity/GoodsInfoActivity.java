package com.qf.administrator.commodity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.fragment.GoodsInfoFragment;

public class GoodsInfoActivity extends AppCompatActivity {
    private ActionBar mBar;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        FragmentManager manager = getSupportFragmentManager();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        FragmentTransaction ft2 = manager.beginTransaction();
        ft2.add(R.id.fl_goodsinfo, GoodsInfoFragment.newInstance(id));
        ft2.commit();
        mBar = getSupportActionBar();
        mBar.setTitle("详情");
        mBar.setHomeButtonEnabled(true);
        mBar.setDisplayHomeAsUpEnabled(true);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}