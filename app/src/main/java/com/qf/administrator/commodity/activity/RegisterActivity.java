package com.qf.administrator.commodity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.administrator.commodity.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences pref;
    private AutoCompleteTextView mName;
    private EditText mCode;
    private Button mGetCode;
    private EditText mNick;
    private EditText mPass;
    private Button mBtRegister;
    private TextView mFinish;
    private LinearLayout mActivityRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initActionBar();
        pref = getSharedPreferences("login", MODE_PRIVATE);

    }
    private void initActionBar() {
        ActionBar bar = getSupportActionBar();
        bar.setTitle("注册");
        bar.setHomeButtonEnabled(true);
        bar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        mName = (AutoCompleteTextView) findViewById(R.id.name);
        mCode = (EditText) findViewById(R.id.code);
        mGetCode = (Button) findViewById(R.id.get_code);
        mNick = (EditText) findViewById(R.id.nick);
        mPass = (EditText) findViewById(R.id.pass);
        mBtRegister = (Button) findViewById(R.id.bt_register);
        mFinish = (TextView) findViewById(R.id.finish);
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mActivityRegister = (LinearLayout) findViewById(R.id.activity_register);

        mGetCode.setOnClickListener(this);
        mBtRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_code:
                //这里获得验证码
                break;
            case R.id.bt_register:
            if(mName.equals("")){
                Toast.makeText(this, "name不能为空", Toast.LENGTH_SHORT).show();
            }else {
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("name",mName.getText().toString());
                edit.putString("pass",mPass.getText().toString());
                edit.commit();
            }
                Toast.makeText(this, "注册成功，请登录", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String codeString = mCode.getText().toString().trim();
        if (TextUtils.isEmpty(codeString)) {
            Toast.makeText(this, "codeString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String nickString = mNick.getText().toString().trim();
        if (TextUtils.isEmpty(nickString)) {
            Toast.makeText(this, "nickString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String passString = mPass.getText().toString().trim();
        if (TextUtils.isEmpty(passString)) {
            Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
    }
}
