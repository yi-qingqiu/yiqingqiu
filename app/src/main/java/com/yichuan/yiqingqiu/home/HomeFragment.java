package com.yichuan.yiqingqiu.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.Orientation;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import com.yichuan.yiqingqiu.R;
import com.yichuan.yiqingqiu.home.adapter.HomeTypeAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import base.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;

/**
 * @author 易川
 * @time 2017/6/14  15:39
 * @desc ${TODO}
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.vp_home)
    Banner mVpBanner;
    Unbinder unbinder;
    List<String> images = new ArrayList<>();
    @BindView(R.id.item_picker)
    DiscreteScrollView mItemPicker;
    InfiniteScrollAdapter infiniteAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {

      //查询轮播图
      String bql = "select * from HomeAdBean";
        new BmobQuery<HomeAdBean>().doSQLQuery(bql, new SQLQueryListener<HomeAdBean>() {
            @Override
            public void done(BmobQueryResult<HomeAdBean> bmobQueryResult, BmobException e) {
                Log.d("tag", "开始");
                if (e == null) {
                    List<HomeAdBean> results = bmobQueryResult.getResults();
                    if (results != null && results.size() > 0) {
                        for (int i = 0; i < results.size(); i++) {
                            images.add(results.get(i).getImage_url());
                            Log.d("tag", "开始");
                        }
                       setBinder(images);

                    }

                }
            }
        });

        mItemPicker.setOrientation(Orientation.HORIZONTAL);
        //页面切换的监听
        mItemPicker.addOnItemChangedListener(new DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder>() {
            @Override
            public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {

            }
        });

        infiniteAdapter = InfiniteScrollAdapter.wrap(new HomeTypeAdapter(getContext()));
        mItemPicker.setAdapter(infiniteAdapter);
        // mItemPicker.setItemTransitionTimeMillis(1000);
        mItemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());
    }

    @Override
    public void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    /**
     * 轮播图配置
     *
     * @param images
     */
    private void setBinder(List<String> images) {
        //设置banner样式
        mVpBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mVpBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mVpBanner.setImages(images);
        //设置banner动画效果
        mVpBanner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        // mVpHome.setBannerTitles(null);
        //设置自动轮播，默认为true
        mVpBanner.isAutoPlay(true);
        //设置轮播时间
        mVpBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mVpBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mVpBanner.start();

    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            //Glide 加载图片简单用法
            //  Glide.with(context).load(path).into(imageView);
            Glide.with(context).load(path)
                    .placeholder(R.drawable.ic_default_color)//占位图片
                    .error(R.drawable.ic_default_color)//默认图片
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//
                   // .centerCrop()
                    .crossFade()
                    .fitCenter()
                    .override(600, 300)
                    .into(imageView);

        }
    }

}
