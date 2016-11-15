package com.qf.administrator.commodity.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.administrator.commodity.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;


public class LoginActivity extends AppCompatActivity{

    private UserLoginTask mAuthTask = null;
    private SharedPreferences pref;
    private TextView register;
    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private Button mEmailSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initActionBar();
        ShareSDK.initSDK(this);
        // Set up the login form.
        pref = getSharedPreferences("login", MODE_PRIVATE);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                showShare();
                attemptLogin();
                mEmailSignInButton.setEnabled(false);
            }
        });
    }
    private void initActionBar() {
        ActionBar bar = getSupportActionBar();
        bar.setTitle("登录");
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

    private void attemptLogin() {
        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (email.equals("")) {
            mEmailView.setError("用户名不能为空");
            mEmailSignInButton.setEnabled(true);
            return;
        }
        if (password.equals("") && (password.length() < 4)) {
            mPasswordView.setError("密码不能少于六位");
            mEmailSignInButton.setEnabled(true);
            return;
        }

        mAuthTask = new UserLoginTask(email, password);
        mAuthTask.execute();

    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.qq:
                Platform form1 = ShareSDK.getPlatform(QQ.NAME);
                login(form1);
                break;
            case R.id.wb:
                Platform form2 = ShareSDK.getPlatform(SinaWeibo.NAME);
                login(form2);
                break;
            case R.id.wx:
                Platform form3 = ShareSDK.getPlatform(Wechat.NAME);
                login(form3);
                break;
        }
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            String name = pref.getString("name", "");
            String pass = pref.getString("pass", "");
            if (mEmail.equals(name) && mPassword.equals(pass)) {
                return true;
            }

            // TODO: register the new account here.
            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            if (success) {
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                mPasswordView.setError("用户名或密码错误");
            }
        }
    }



    private void login(Platform form) {

        //回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
        form.setPlatformActionListener(new PlatformActionListener() {

            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                // TODO Auto-generated method stub
                arg2.printStackTrace();
            }

            @Override
            public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                // TODO Auto-generated method stub
                //输出所有授权信息
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name", (String) arg2.get("nickname"));
                editor.putString("pass", (String) arg2.get("city"));
                arg0.getDb().exportData();
                Log.i("tmd", "onComplete: " + arg2.toString() + arg2.get("nickname") + arg2.get("city"));
            }

            @Override
            public void onCancel(Platform arg0, int arg1) {
                // TODO Auto-generated method stub

            }
        });
        //authorize与showUser单独调用一个即可
        //qq.authorize();//单独授权,OnComplete返回的hashmap是空的
        form.showUser(null);//授权并获取用户信息
        //移除授权
        //weibo.removeAccount(true);
    }

}

