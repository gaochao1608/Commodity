package com.qf.administrator.commodity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

import com.qf.administrator.commodity.R;

public class RecommendBuyGoodsActivity extends AppCompatActivity {
    private ActionBar mBar;
    private String sourceurl;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_buy_goods);
        Intent intent =getIntent();
        sourceurl=intent.getStringExtra("source_url1");
        mBar = getSupportActionBar();
        mBar.setTitle("单品");
        mBar.setHomeButtonEnabled(true);
        mBar.setDisplayHomeAsUpEnabled(true);
        mWebView= (WebView) findViewById(R.id.wv_buygoods);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.loadUrl(sourceurl);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mWebView.canGoBack()){
            mWebView.goBack();
        }else {
            finish();
        }
    }
}
