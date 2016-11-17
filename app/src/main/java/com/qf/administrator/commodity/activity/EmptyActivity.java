package com.qf.administrator.commodity.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qf.administrator.commodity.R;

public class EmptyActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvEmpty;
    private TextView mTitle;
    private Button mAddress;
    private ActionBar mBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        initView();
        mBar = getSupportActionBar();
        mBar.setTitle("单品");
        mBar.setHomeButtonEnabled(true);
        mBar.setDisplayHomeAsUpEnabled(true);
        String come = getIntent().getStringExtra("come");
        mTvEmpty.setText("您暂时没有" + come);
        mTitle.setText(come);
        if (come.equals("地址")) {
            mAddress.setVisibility(View.VISIBLE);
        }

    }

    private void initView() {
        mTvEmpty = (TextView) findViewById(R.id.tv_empty);
        mTitle = (TextView) findViewById(R.id.title);
        mAddress = (Button) findViewById(R.id.address);
        mAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.address:

                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
