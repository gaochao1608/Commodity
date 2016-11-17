package com.qf.administrator.commodity.fragment;


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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qf.administrator.commodity.R;
import com.qf.administrator.commodity.activity.BuyShowActivity;
import com.qf.administrator.commodity.bean.BuyShowBean;
import com.qf.administrator.commodity.myview.MyGridView;
import com.qf.administrator.commodity.utils.OkHttpUtils;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuyshowFragment extends Fragment {
    private RecyclerView rlv;
    private SwipeRefreshLayout sp;
    private MyAdapter adapter;
    private ArrayList<BuyShowBean.ObjectsBean> list = new ArrayList<>();
    private String url = "http://dpapi.mgpyh.com/api/v3/mobileshow/?limit=20&platform=app&offset=";
    private LinearLayoutManager manager;
    private int pager = 0;
    private Context context;

    public BuyshowFragment() {
        // Required empty public constructor
    }

    public static BuyshowFragment newInstance() {
        Bundle args = new Bundle();
        BuyshowFragment fragment = new BuyshowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rlv = (RecyclerView) view.findViewById(R.id.rlv_firstfrag);
        sp = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
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
        OkHttpUtils.getInstances().getByEnqueue(getActivity(), url + pager, BuyShowBean.class,
                new OkHttpUtils.GetTextCallback<BuyShowBean>() {
                    @Override
                    public void getText(BuyShowBean result) {
                        list.addAll(result.getObjects());
                        adapter.notifyDataSetChanged();
                    }
                });

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_buy_show, null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), BuyShowActivity.class);
                    Log.i("tmd", "onClick: "+view.getTag()+list.get((Integer) view.getTag()));
                    intent.putExtra("obj",list.get((Integer) view.getTag()));
                    startActivity(intent);
                }
            });
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyHolder holder, int position) {
            Glide.with(context).load(list.get(position).getUser().getAvatar()).into(holder.ivHead);
            holder.tvName.setText(list.get(position).getUser().getUsername());
            holder.tvMoney.setText("已认证购物金额" + list.get(position).getUser().getTotal_price() + "元");
            holder.tvGoodContent.setText(list.get(position).getContent().getGood());
            holder.tvBadContent.setText(list.get(position).getContent().getBad());
            holder.tvOptionContent.setText(list.get(position).getContent().getOption());
            holder.tvTime.setText(list.get(position).getNaturaltime());
            GridAdapter gridAdapter = new GridAdapter(position);
            holder.gridImage.setAdapter(gridAdapter);
            holder.tvComment.setText(" "+list.get(position).getComment_count());
            holder.itemView.setTag(position);
            holder.btAttention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.btAttention.setText("已关注");
                    Toast.makeText(context, "你已关注", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            public View rootView;
            public ImageView ivHead;
            public TextView tvName;
            public TextView tvMoney;
            public Button btAttention;
            public TextView tvGood;
            public TextView tvGoodContent;
            public TextView tvBad;
            public TextView tvBadContent;
            public TextView tvOption;
            public TextView tvOptionContent;
            public MyGridView gridImage;
            public TextView tvTime;
            public TextView tvUp;
            public TextView tvDown;
            public TextView tvComment;
            public TextView tvCollect;

            public MyHolder(View itemView) {
                super(itemView);
                this.rootView = itemView;
                this.ivHead = (ImageView) rootView.findViewById(R.id.iv_head);
                this.tvName = (TextView) rootView.findViewById(R.id.tv_name);
                this.tvMoney = (TextView) rootView.findViewById(R.id.tv_money);
                this.btAttention = (Button) rootView.findViewById(R.id.bt_attention);
                this.tvGood = (TextView) rootView.findViewById(R.id.tv_good);
                this.tvGoodContent = (TextView) rootView.findViewById(R.id.tv_good_content);
                this.tvBad = (TextView) rootView.findViewById(R.id.tv_bad);
                this.tvBadContent = (TextView) rootView.findViewById(R.id.tv_bad_content);
                this.tvOption = (TextView) rootView.findViewById(R.id.tv_option);
                this.tvOptionContent = (TextView) rootView.findViewById(R.id.tv_option_content);
                this.gridImage = (MyGridView) rootView.findViewById(R.id.grid_image);
                this.tvTime = (TextView) rootView.findViewById(R.id.tv_time);
                this.tvUp = (TextView) rootView.findViewById(R.id.tv_up);
                this.tvDown = (TextView) rootView.findViewById(R.id.tv_down);
                this.tvComment = (TextView) rootView.findViewById(R.id.tv_comment);
                this.tvCollect = (TextView) rootView.findViewById(R.id.tv_collect);
            }
        }


    }

    class GridAdapter extends BaseAdapter {
        private int position;

        public GridAdapter(int position) {
            this.position = position;
        }

        @Override
        public int getCount() {
            return list.get(position).getContent().getImages().size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Holder holder;
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.item_image, null);
                holder = new Holder(view);
                view.setTag(holder);
            } else {
                holder = (Holder) view.getTag();
            }
            Glide.with(context).load(list.get(position).getContent().getImages().get(i).getSmall()).into(holder.image);
            return view;
        }
    }

    public class Holder {
        public View rootView;
        public ImageView image;

        public Holder(View rootView) {
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.item_image);
        }

    }
}
