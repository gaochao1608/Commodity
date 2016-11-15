package com.qf.administrator.commodity.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.bean.SearchBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchListFragment extends Fragment {

    private String url = "http://api.danpin.com/index.php?controller=search&action=query&k=&sort=&d=&page=";
    private ArrayList<SearchBean.DataBean.ItemsBean> list = new ArrayList<>();
    private RecyclerView rlv;
    private MyAdapter adapter;
    private Context context;
    private SwipeRefreshLayout sp;
    private int pager;
    private LinearLayoutManager manager;


    public SearchListFragment() {
        // Required empty public constructor
    }

    public static SearchListFragment newInstance(String k, String sort, String d) {

        Bundle args = new Bundle();
        args.putString("k", k);
        args.putString("sort", sort);
        args.putString("d", d);
        SearchListFragment fragment = new SearchListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rlv = (RecyclerView) view.findViewById(R.id.recycle_sort);
        sp = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        try {
            String k = URLEncoder.encode(getArguments().getString("k","牛仔裤"), "utf-8");
            url = url.replaceAll("k=","k="+k).replaceAll("sort=","sort="+getArguments().getString("sort"))
                    .replace("d=","d="+getArguments().getString("d"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.i("tmdd", "initData: "+url);
        initData();
        initAdapter();
        sp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                pager = 1;
                initData();
                adapter.notifyDataSetChanged();
                sp.setRefreshing(false);
            }
        });

        rlv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public int lastvisitemposition;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                sp.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastvisitemposition + 1 == adapter.getItemCount()) {
                    pager++;
                    initData();
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastvisitemposition = manager.findLastVisibleItemPosition();
            }
        });
    }

    private void initAdapter() {
        manager = new LinearLayoutManager(context);
        rlv.setLayoutManager(manager);
        adapter = new MyAdapter();
        rlv.setAdapter(adapter);
    }

    private void initData() {

//        OkHttpUtils.getInstances().getByEnqueue(getActivity(), url, SearchBean.class,
//                new OkHttpUtils.GetTextCallback<SearchBean>() {
//                    @Override
//                    public void getText(SearchBean result) {
//                        list.addAll(result.getData().getItems());
//                        adapter.notifyDataSetChanged();
//                    }
//                });
        OkHttpClient client= new OkHttpClient();
        Request get = new Request.Builder()
                .url(url+pager)
                .build();
        Call call = client.newCall(get);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                try {
                    JSONObject obj = new JSONObject(json);
                    JSONObject data = obj.getJSONObject("data");
                    JSONArray items = data.getJSONArray("items");
                    for (int i = 0; i < items.length()-1; i++) {
                        SearchBean.DataBean.ItemsBean itemsBean = new SearchBean.DataBean.ItemsBean();
                        JSONObject itemsObject = items.getJSONObject(i);
                        itemsBean.setId(itemsObject.getInt("id"));
                        itemsBean.setImgUrl(itemsObject.getString("imgUrl"));
                        itemsBean.setPrice(itemsObject.getInt("price"));
                        itemsBean.setLabelprice(itemsObject.getInt("labelprice"));
                        itemsBean.setDiscount(itemsObject.getString("discount"));
                        itemsBean.setTitle(itemsObject.getString("title"));
                        list.add(itemsBean);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(context).inflate(R.layout.item_search, null));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, final int position) {
            Glide.with(context).load(list.get(position).getImgUrl()).into(holder.ivSearch);
            holder.tvSearch.setText(list.get(position).getTitle());
            holder.tvAfterPrice.setText("￥"+list.get(position).getPrice());
            holder.tvBeforePrice.setText("￥"+list.get(position).getLabelprice());
            holder.tvDiscount.setText(list.get(position).getDiscount());
            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(getActivity(),GoodsInfoActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            public View rootView;
            public ImageView ivSearch;
            public TextView tvSearch;
            public TextView tvAfterPrice;
            public TextView tvBeforePrice;
            public TextView tvDiscount;
            public MyHolder(View itemView) {
                super(itemView);
                this.rootView = itemView;
                this.ivSearch = (ImageView) rootView.findViewById(R.id.iv_search);
                this.tvSearch = (TextView) rootView.findViewById(R.id.tv_search);
                this.tvAfterPrice = (TextView) rootView.findViewById(R.id.tv_after_price);
                this.tvBeforePrice = (TextView) rootView.findViewById(R.id.tv_before_price);
                this.tvDiscount = (TextView) rootView.findViewById(R.id.tv_discount);
            }
        }

    }
}
