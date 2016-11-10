package com.qf.administrator.commodity.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.fragment.BuyshowFragment;
import com.qf.administrator.commodity.fragment.CategoryFragment;
import com.qf.administrator.commodity.fragment.FindFragment;
import com.qf.administrator.commodity.fragment.RecommendFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private String[] title = {"找单品","编辑推","买家秀","全品类"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        adapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setTabTextColors(getResources().getColor(R.color.white), getResources().getColor(R.color.dackwhite));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initData() {
        list.add(FindFragment.newInstance());
        list.add(RecommendFragment.newInstance());
        list.add(BuyshowFragment.newInstance());
        list.add(CategoryFragment.newInstance());
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
    }
    class MyAdapter extends FragmentStatePagerAdapter{


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
