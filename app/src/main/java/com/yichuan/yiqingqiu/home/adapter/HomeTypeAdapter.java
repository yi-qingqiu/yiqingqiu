package com.yichuan.yiqingqiu.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
    String titles[] = {"西塘", "乌镇", "同里", "周庄", "木渎"};
    String images[] = {"http://inspiration.chanyouji.cn/Destination/330/f845c47621c332939b1b8a91182d095e.jpg", "http://inspiration.chanyouji.cn/Destination/329/175c5edb029a6ee02d68e12f273bbfa6.jpg", "http://inspiration.chanyouji.cn/Destination/344/5d5016b1383d742a601644e9b0926a2d.jpg", "http://inspiration.chanyouji.cn/Destination/343/c888257e5d6732968f4a69c82598d2ba.jpg", "http://inspiration.chanyouji.cn/Destination/338/88311f0459567aae615345f63b1afb0a.jpg"};
    String titles_two[] = {"梦里的水乡古镇", "白银 镍 咖啡 大豆", "东方威尼斯", "神州第一水乡", "吴文化的"};



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
        holder.mTvNumber.setText("0" + (position + 1));
        holder.mTvTitle.setText(titles[position]);
        holder.mTvSimple.setText(titles_two[position]);
        Glide.with(context).load(images[position]).asBitmap().into(holder.mIvTown);

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
        @BindView(R.id.iv_town)
        ImageView mIvTown;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
