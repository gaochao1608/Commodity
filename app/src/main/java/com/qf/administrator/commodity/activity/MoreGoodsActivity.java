package com.qf.administrator.commodity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.qf.administrator.commodity.R;

public class MoreGoodsActivity extends AppCompatActivity {
    private String brand_url = "http://api.danpin.com/index.php?controller=home&action=brandgoods&brand_id=";
    private String brand_after_url = "&page=1&order=discount&sort=asc";
    private ActionBar mBar;
    private TabLayout tab_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_goods);
        initView();
        Intent intent = getIntent();
        String brand_id = intent.getStringExtra("brand_id");
        String brand_name = intent.getStringExtra("brand_name");
        mBar = getSupportActionBar();
        mBar.setTitle(brand_name);
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

    private void initView() {
        tab_more = (TabLayout) findViewById(R.id.tab_more);
    }
}
