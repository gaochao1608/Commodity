package com.qf.administrator.commodity.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.activity.RecommendGoodsInfoActivity;
import com.qf.administrator.commodity.bean.RecommendListBean;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {
    private SwipeRefreshLayout srfl;
    private RecyclerView rlv;
    private String url_recommend = "http://dpapi.mgpyh.com/api/v3/mobilepost/?limit=20&offset=";
    private List<RecommendListBean.ObjectsBean> mList = new ArrayList<>();
    private MyRecommendAdapter adapter;
    private int lastVisItemPosition;
    private int offset=0;
    private LinearLayoutManager manager;


    public RecommendFragment() {
        // Required empty public constructor
    }

    public static RecommendFragment newInstance() {

        Bundle args = new Bundle();

        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

        initData();

        initAdapter();
        srfl.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
        rlv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisItemPosition + 1 == adapter.getItemCount()) {
                    offset+=20;
                    initData();
                    adapter.notifyDataSetChanged();
                }
                            srfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                            @Override
                            public void onRefresh() {
                                srfl.setRefreshing(true);
                                mList.clear();
                                offset = 0;
                                initData();
                                adapter.notifyDataSetChanged();
                                srfl.setRefreshing(false);
                            }
                        });
                    }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
              lastVisItemPosition=manager.findLastVisibleItemPosition();
            }
        });
    }

    private void initAdapter() {
       manager= new LinearLayoutManager(getContext());
        rlv.setLayoutManager(manager);
        adapter = new MyRecommendAdapter();
        rlv.setAdapter(adapter);
    }

    private void initData() {
        OkHttpUtils.getInstances().getByEnqueue(getActivity(), url_recommend+offset, RecommendListBean.class, new OkHttpUtils.GetTextCallback<RecommendListBean>() {

            @Override
            public void getText(RecommendListBean result) {
                mList.addAll(result.getObjects());
                adapter.notifyDataSetChanged();

            }
        });
    }

    private void initView(View view) {
        srfl = (SwipeRefreshLayout) view.findViewById(R.id.srfl_recommend);
        rlv = (RecyclerView) view.findViewById(R.id.rlv_recommend);

    }

    class MyRecommendAdapter extends RecyclerView.Adapter<MyRecommendAdapter.MyRecHolder> {



        @Override
        public MyRecHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyRecHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_recommend, parent, false));
        }

        @Override
        public void onBindViewHolder(MyRecHolder holder, final int position) {
            holder.txt_recfragment_title.setText(mList.get(position).getTitle());
            holder.txt_recfragment_price.setText(mList.get(position).getCurrency()+mList.get(position).getPrice());
            holder.txt_comment_count.setText(mList.get(position).getComment_count()+"");
            holder.txt_recfragment_time.setText(mList.get(position).getCreated_time());
            Glide.with(getActivity()).load(mList.get(position).getCover_image()).into(holder.img_recfragment);
            final int recid=mList.get(position).getId();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), RecommendGoodsInfoActivity.class);
                    intent.putExtra("recid",recid);
                    intent.putExtra("source_url",mList.get(position).getSource_url());
                    startActivity(intent);

                }
            });


        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class MyRecHolder extends RecyclerView.ViewHolder {
            private ImageView img_recfragment;
            private TextView txt_recfragment_title;
            private TextView txt_recfragment_price;
            private TextView txt_comment_count;
            private TextView txt_recfragment_time;

            public MyRecHolder(View itemView) {
                super(itemView);
                img_recfragment= (ImageView) itemView.findViewById(R.id.img_recfragment);
                txt_recfragment_title= (TextView) itemView.findViewById(R.id.txt_recfragment_title);
                txt_recfragment_price= (TextView) itemView.findViewById(R.id.txt_recfragment_price);
                txt_comment_count= (TextView) itemView.findViewById(R.id.txt_comment_count);
                txt_recfragment_time= (TextView) itemView.findViewById(R.id.txt_recfragment_time);

            }
        }
    }
}
