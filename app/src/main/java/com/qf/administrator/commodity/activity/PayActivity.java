package com.qf.administrator.commodity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;

public class PayActivity extends AppCompatActivity implements View.OnClickListener {
    private ActionBar mBar;
    private RelativeLayout rl_adress;
    private ImageView img_buyinfo;
    private TextView txt_buyinfo_title;
    private TextView txt_buyinfo_num;
    private TextView txt_buyinfo_price;
    private TextView txt_price_all;
    private TextView txt_price_all_bottom;
    private Button btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initView();
        mBar = getSupportActionBar();
        mBar.setTitle("确认订单");
        mBar.setHomeButtonEnabled(true);
        mBar.setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String record_img = intent.getStringExtra("record_img");
        String record_txt_choose = intent.getStringExtra("record_txt_choose");
        String record_txt_price = intent.getStringExtra("record_txt_price");
        String record_txt_all_price=intent.getStringExtra("record_txt_all_price");
        int num = intent.getIntExtra("num", 0);
        Glide.with(this).load(record_img).into(img_buyinfo);
        txt_buyinfo_title.setText(record_txt_choose);
        txt_buyinfo_price.setText(record_txt_price);
        txt_buyinfo_num.setText(num+"");
        txt_price_all.setText(record_txt_all_price);
        txt_price_all_bottom.setText(record_txt_all_price);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        rl_adress = (RelativeLayout) findViewById(R.id.rl_adress);
        img_buyinfo = (ImageView) findViewById(R.id.img_buyinfo);
        txt_buyinfo_title = (TextView) findViewById(R.id.txt_buyinfo_title);
        txt_buyinfo_num = (TextView) findViewById(R.id.txt_buyinfo_num);
        txt_buyinfo_price = (TextView) findViewById(R.id.txt_buyinfo_price);
        txt_price_all = (TextView) findViewById(R.id.txt_price_all);
        txt_price_all_bottom = (TextView) findViewById(R.id.txt_price_all_bottom);
        btn_pay = (Button) findViewById(R.id.btn_pay);

        rl_adress.setOnClickListener(this);
        btn_pay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_adress:
                //TODO 添加收货地址
//                startActivityForResult();

                break;
            case R.id.btn_pay:
                //TODO 支付
                break;
        }
    }
}
