package com.qf.administrator.commodity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.fragment.RecommendGoodsInfoFragment;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class RecommendGoodsInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private int recid;
    private ActionBar mBar;
    private FragmentManager mManager;
    private ImageView img_recfrag_comment;
    private ImageView img_recfrag_share;
    private CheckBox cb_recfrag_like;
    private Button btn_recfrag_gobuy;
    private String source_url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_goods_info);
        initView();
        Intent intent = getIntent();
        recid = intent.getIntExtra("recid", 2);
        source_url=intent.getStringExtra("source_url");
        mBar = getSupportActionBar();
        mBar.setTitle("推荐详情");
        mBar.setHomeButtonEnabled(true);
        mBar.setDisplayHomeAsUpEnabled(true);
        mManager = getSupportFragmentManager();
        mManager.beginTransaction().add(R.id.fl_recommend, RecommendGoodsInfoFragment.newInstance(recid)).commit();

        cb_recfrag_like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_recfrag_like.isChecked()){
                    Toast.makeText(RecommendGoodsInfoActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(RecommendGoodsInfoActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        img_recfrag_comment = (ImageView) findViewById(R.id.img_recfrag_comment);
        img_recfrag_share = (ImageView) findViewById(R.id.img_recfrag_share);
        cb_recfrag_like = (CheckBox) findViewById(R.id.cb_recfrag_like);
        btn_recfrag_gobuy = (Button) findViewById(R.id.btn_recfrag_gobuy);

        img_recfrag_comment.setOnClickListener(this);
        img_recfrag_share.setOnClickListener(this);
        btn_recfrag_gobuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_recfrag_comment:
                //TODO 评论列表的处理

                break;
            case R.id.img_recfrag_share:
                showShare();

                break;
            case R.id.btn_recfrag_gobuy:
                Intent intent =new Intent(RecommendGoodsInfoActivity.this,RecommendBuyGoodsActivity.class);
                intent.putExtra("source_url1",source_url);
                startActivity(intent);

                break;
        }
    }
    public void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");
        // 启动分享GUI
        oks.show(this);
    }
}
