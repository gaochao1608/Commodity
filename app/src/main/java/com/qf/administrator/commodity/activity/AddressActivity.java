package com.qf.administrator.commodity.activity;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.administrator.commodity.R;

import java.io.FileNotFoundException;

public class AddressActivity extends AppCompatActivity implements View.OnClickListener {

    private ActionBar mBar;
    private TextView mTvName;
    private EditText mEdName;
    private TextView mTvNum;
    private EditText mEdNum;
    private TextView mTvPhone;
    private EditText mEdPhone;
    private Button mBtAddress;
    private TextView mTvAddress;
    private TextView mTvDeal;
    private EditText mEdDeal;
    private ImageView mFront;
    private ImageView mBack;
    private Button mSubmit;
    private LinearLayout mActivityAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initView();
        mBar = getSupportActionBar();
        mBar.setTitle("编辑地址");
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
        mTvName = (TextView) findViewById(R.id.tv_name);
        mEdName = (EditText) findViewById(R.id.ed_name);
        mTvNum = (TextView) findViewById(R.id.tv_num);
        mEdNum = (EditText) findViewById(R.id.ed_num);
        mTvPhone = (TextView) findViewById(R.id.tv_phone);
        mEdPhone = (EditText) findViewById(R.id.ed_phone);
        mBtAddress = (Button) findViewById(R.id.bt_address);
        mTvAddress = (TextView) findViewById(R.id.tv_address);
        mTvDeal = (TextView) findViewById(R.id.tv_deal);
        mEdDeal = (EditText) findViewById(R.id.ed_deal);
        mFront = (ImageView) findViewById(R.id.front);
        mBack = (ImageView) findViewById(R.id.back);
        mSubmit = (Button) findViewById(R.id.submit);
        mActivityAddress = (LinearLayout) findViewById(R.id.activity_address);

        mFront.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mBtAddress.setOnClickListener(this);
        mSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_address:

                break;
            case R.id.submit:
                Toast.makeText(this, "提交到服务端", Toast.LENGTH_SHORT).show();
                break;
            case R.id.front:
                showDialog(0, 1);
                break;
            case R.id.back:
                showDialog(2, 3);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = null;
        if (resultCode == RESULT_OK && requestCode == 1) {
            Bundle mBundle = data.getExtras();
            bitmap = (Bitmap) mBundle.get("data");
        }
        if (resultCode == RESULT_OK && requestCode == 0) {
            Uri uri = data.getData();
            ContentResolver cr = this.getContentResolver();
            try {
                bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (bitmap != null && requestCode == 0 || requestCode == 1) {
            mFront.setImageBitmap(bitmap);
        }
        if (bitmap != null && requestCode == 2 || requestCode == 3) {
            mFront.setImageBitmap(bitmap);
        }
    }

    public void showDialog(final int m, final int n) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddressActivity.this)
                .setTitle("请选择：")
                .setItems(new String[]{"图库", "相机"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == m) {
                            Intent intent = new Intent();
                            intent.setType("image/*");
                            intent.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(Intent.createChooser(intent, "选择图片"), 0);

                        } else {
                            Intent intent = new Intent();
                            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, n);
                        }
                    }
                });
        builder.show();
    }
}
