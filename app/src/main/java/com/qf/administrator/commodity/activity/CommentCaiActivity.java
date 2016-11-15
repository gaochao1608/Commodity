package com.qf.administrator.commodity.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qf.administrator.commodity.R;

public class CommentCaiActivity extends AppCompatActivity implements View.OnClickListener {
    private ActionBar mBar;
    private EditText et_comment;
    private Button btn_sendmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_cai);
        initView();
        mBar = getSupportActionBar();
        mBar.setTitle("评论");
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
        et_comment = (EditText) findViewById(R.id.et_comment_cai);
        btn_sendmessage = (Button) findViewById(R.id.btn_sendmessage_cai);

        btn_sendmessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sendmessage_cai:
                submit();

                break;
        }
    }

    private void submit() {
        // validate
        String comment = et_comment.getText().toString().trim();
        if (TextUtils.isEmpty(comment)) {
            Toast.makeText(this, "你刚刚踩了这个商品，晒晒理由吧!", Toast.LENGTH_SHORT).show();
            return;
        }else {
            //TODO  将输入框得到的内容加入到数据库中
        }



    }
}
