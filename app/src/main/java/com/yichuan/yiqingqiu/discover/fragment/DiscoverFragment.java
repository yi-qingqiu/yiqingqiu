package com.yichuan.yiqingqiu.discover.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.Orientation;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import com.yichuan.yiqingqiu.R;
import com.yichuan.yiqingqiu.home.adapter.HomeTypeAdapter;

import base.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 易川
 * @time 2017/6/19  9:03
 * @desc ${TODO}
 */

public class DiscoverFragment extends BaseFragment {

    @BindView(R.id.item_picker)
    DiscreteScrollView mItemPicker;
    Unbinder unbinder;
    InfiniteScrollAdapter infiniteAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
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
}
