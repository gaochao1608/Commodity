package com.qf.administrator.commodity.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.fragment.SearchListFragment;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {

    private ImageView mIvBar;
    private EditText mSvBar;
    private TextView mSearchBar;
    private LinearLayout mLlBar;
    private TabLayout mTabTab;
    private FrameLayout mTabFragment;
    private RelativeLayout mActivitySearch;
    private ArrayList<Fragment> list = new ArrayList<>();
    private FragmentManager manager;
    private boolean upPrice;
    private View viewPrice;
    private String k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        manager = getSupportFragmentManager();
        initView();
        initTab();
        initFragment();

        mSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mSvBar.getText().toString().equals("")){
                    k = mSvBar.getText().toString();
                    list.clear();
                    initFragment();
                }else {
                    Toast.makeText(SearchActivity.this, "输入搜索", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mTabTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //当标签被选中后运行此方法
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //将该标签对应的Fragment通过add或者show方法显示到屏幕上
                int index = Integer.parseInt(tab.getTag().toString());
                if (list.get(index).isAdded()) {
                    manager.beginTransaction().show(list.get(index)).commit();
                } else {
                    if(index == 2){
                        upPrice = true;
                        manager.beginTransaction().add(R.id.tab_fragment,list.get(3)).commit();
                        manager.beginTransaction().hide(list.get(3)).commit();
                    }
                    manager.beginTransaction().add(R.id.tab_fragment,list.get(index)).commit();
                }

            }
            //当标签被取消选中时运行此方法
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //将改标签对应的Fragment通过hide方法隐藏显示
                int index = Integer.parseInt(tab.getTag().toString());
                if(index == 2){
                    manager.beginTransaction().hide(list.get(3)).commit();
                }
                manager.beginTransaction().hide(list.get(index)).commit();
            }
            //当标签被重复选中时运行此方法
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int index = Integer.parseInt(tab.getTag().toString());
                ImageView iv = (ImageView) viewPrice.findViewById(R.id.iv_price);
                if(index ==2&& upPrice){
                    iv.setImageResource(android.R.drawable.arrow_up_float);
                    manager.beginTransaction().hide(list.get(2)).commit();
                    manager.beginTransaction().show(list.get(3)).commit();
                    upPrice = false;
                }else {
                    iv.setImageResource(android.R.drawable.arrow_down_float);
                    manager.beginTransaction().hide(list.get(3)).commit();
                    manager.beginTransaction().show(list.get(2)).commit();
                    upPrice = true;
                }
            }
        });
    }

    private void initTab() {
        viewPrice = LayoutInflater.from(SearchActivity.this).inflate(R.layout.item_price, null);

        mTabTab.addTab(mTabTab.newTab().setText("相关").setTag(0));
        mTabTab.addTab(mTabTab.newTab().setText("折扣").setTag(1));
        mTabTab.addTab(mTabTab.newTab().setCustomView(viewPrice).setTag(2));
    }

    private void initFragment() {

        list.add(SearchListFragment.newInstance(k,"","-1"));
        list.add(SearchListFragment.newInstance(k,"discount","-1"));
        list.add(SearchListFragment.newInstance(k,"price","0"));
        list.add(SearchListFragment.newInstance(k,"price","1"));
        manager.beginTransaction().replace(R.id.tab_fragment,list.get(0)).commit();

    }

    private void initView() {
        mIvBar = (ImageView) findViewById(R.id.iv_bar);
        mIvBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mSvBar = (EditText) findViewById(R.id.sv_bar);
        mSearchBar = (TextView) findViewById(R.id.search_bar);
        mLlBar = (LinearLayout) findViewById(R.id.ll_bar);
        mTabTab = (TabLayout) findViewById(R.id.tab_tab);
        mTabFragment = (FrameLayout) findViewById(R.id.tab_fragment);
        mActivitySearch = (RelativeLayout) findViewById(R.id.activity_search);
    }
}
