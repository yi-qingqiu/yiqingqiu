package com.yichuan.yiqingqiu.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yichuan.yiqingqiu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 易川
 * @time 2017/6/15  10:30
 * @desc ${TODO}
 */

public class HomeTypeAdapter extends RecyclerView.Adapter<HomeTypeAdapter.ViewHolder> {
    Context context;
    int colors[] = {R.color.green, R.color.lightblue, R.color.yellow, R.color.red, R.color.gray};
    String titles[] = {"基础知识", "投资品介绍", "重大行情", "基本面分析", "技术面分析"};
    String titles_two[] = {"投资的基础知识及盈利套路", "白银 镍 咖啡 大豆", "如何选好时机入场", "靠全球政治经济把握行情", "依据历史数据科学分析"};


    public HomeTypeAdapter(Context context) {
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.type_item, parent, false));
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mLlLayout.setBackgroundColor(context.getResources().getColor(colors[position]));
        holder.mTvNumber.setText("0"+(position+1));
        holder.mTvTitle.setText(titles[position]);
        holder.mTvSimple.setText(titles_two[position]);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_number)
        TextView mTvNumber;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_simple)
        TextView mTvSimple;
        @BindView(R.id.ll_layout)
        LinearLayout mLlLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
