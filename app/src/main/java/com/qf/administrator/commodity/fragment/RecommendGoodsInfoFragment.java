package com.qf.administrator.commodity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.bean.RecommendGoodsInfoBean;
import com.qf.administrator.commodity.utils.OkHttpUtils;

/**
 * Created by 高超 on 2016/11/15.
 */

public class RecommendGoodsInfoFragment extends Fragment {
    private WebView mWebView;
    private ImageView imageView;
    private String url="http://dpapi.mgpyh.com/api/v3/mobilepost/";

    public static RecommendGoodsInfoFragment newInstance(int recid) {

        Bundle args = new Bundle();
        args.putInt("recid",recid);
        RecommendGoodsInfoFragment fragment = new RecommendGoodsInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recommend_goodsinfo,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mWebView= (WebView) view.findViewById(R.id.wb_recfragment);
        imageView= (ImageView) view.findViewById(R.id.img_recfragment_goodsinfo);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        initData();

    }
    private void initData() {
        int recid =getArguments().getInt("recid");
        OkHttpUtils.getInstances().getByEnqueue(getActivity(), url + recid, RecommendGoodsInfoBean.class, new OkHttpUtils.GetTextCallback<RecommendGoodsInfoBean>() {

            @Override
            public void getText(RecommendGoodsInfoBean result) {
                mWebView.loadDataWithBaseURL(null,result.getContent(),"text/html","utf-8",null);
                Glide.with(getActivity()).load(result.getCover_image()).into(imageView);
            }
        });

    }
}
