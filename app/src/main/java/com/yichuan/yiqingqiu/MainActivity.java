package com.yichuan.yiqingqiu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.yichuan.yiqingqiu.home.HomeFragment;
import com.yichuan.yiqingqiu.mine.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import widget.NoScrollViewPager;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.main_viewpager)
    NoScrollViewPager mMainViewpager;
    @BindView(R.id.tab_img_home)
    ImageView mTabImgHome;
    @BindView(R.id.tab_text_home)
    TextView mTabTextHome;
    @BindView(R.id.rl_home)
    RelativeLayout mRlHome;
    @BindView(R.id.tab_img_plan)
    ImageView mTabImgPlan;
    @BindView(R.id.tab_text_plan)
    TextView mTabTextPlan;
    @BindView(R.id.rl_plan)
    RelativeLayout mRlPlan;
    @BindView(R.id.tab_img_circle)
    ImageView mTabImgCircle;
    @BindView(R.id.tab_text_circle)
    TextView mTabTextCircle;
    @BindView(R.id.rl_circle)
    RelativeLayout mRlCircle;
    @BindView(R.id.tab_img_discover)
    ImageView mTabImgDiscover;
    @BindView(R.id.tab_text_discover)
    TextView mTabTextDiscover;
    @BindView(R.id.rl_discover)
    RelativeLayout mRlDiscover;
    @BindView(R.id.tab_img_mine)
    ImageView mTabImgMine;
    @BindView(R.id.tab_text_mine)
    TextView mTabTextMine;
    @BindView(R.id.rl_mine)
    RelativeLayout mRlMine;
    @BindView(R.id.main_bottom)
    LinearLayout mMainBottom;
    private List<Fragment> mFragment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
        initMainViewPager();
        changeTextViewColor();
        changeSelectedTabState(0);
    }


    //ViewPager初始化设置
    private void initMainViewPager() {
        mFragment.add(new HomeFragment());
        mFragment.add(new TvLiveFragment());
        mFragment.add(new CircleFragment());
        mFragment.add(new PoetryFragment());
        mFragment.add(new MineFragment());
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        };
        mMainViewpager.setAdapter(fragmentPagerAdapter);
        mMainViewpager.setOffscreenPageLimit(5);
        mMainViewpager.addOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageSelected(int position) {
        changeTextViewColor();
        changeSelectedTabState(position);
    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void changeTextViewColor() {
        mTabImgHome.setImageResource(R.drawable.bb_btn_home_unselect);
        mTabImgPlan.setImageResource(R.drawable.bb_btn_label_unselect);
        mTabImgCircle.setImageResource(R.drawable.bb_btn_post_select);
        mTabImgDiscover.setImageResource(R.drawable.bb_btn_message_unselect);
        mTabImgMine.setImageResource(R.drawable.bb_btn_account_unselect);

        mTabTextHome.setTextColor(getResources().getColor(R.color.icon_tv_color));
        mTabTextPlan.setTextColor(getResources().getColor(R.color.icon_tv_color));
        mTabTextCircle.setTextColor(getResources().getColor(R.color.icon_tv_color));
        mTabTextDiscover.setTextColor(getResources().getColor(R.color.icon_tv_color));
        mTabTextMine.setTextColor(getResources().getColor(R.color.icon_tv_color));


    }

    //选中字体颜色,tab图片改变
    private void changeSelectedTabState(int position) {
        switch (position) {
            case 0:

                mTabImgHome.setImageResource(R.drawable.bb_btn_home_select);
                mTabTextHome.setTextColor(getResources().getColor(R.color.black));

                break;
            case 1:
                mTabImgPlan.setImageResource(R.drawable.bb_btn_label_select);
                mTabTextPlan.setTextColor(getResources().getColor(R.color.black));

                break;
            case 2:

                //方式一通过代码的方式定义位移动画

                break;
            case 3:
                mTabImgDiscover.setImageResource(R.drawable.bb_btn_message_select);
                mTabTextDiscover.setTextColor(getResources().getColor(R.color.black));

                break;
            case 4:

                mTabImgMine.setImageResource(R.drawable.bb_btn_account_select);
                mTabTextMine.setTextColor(getResources().getColor(R.color.black));

                break;
        }

    }


    @OnClick({R.id.rl_home, R.id.rl_plan, R.id.rl_circle, R.id.rl_discover, R.id.rl_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_home:
                mMainViewpager.setCurrentItem(0, false);
                break;
            case R.id.rl_plan:
                mMainViewpager.setCurrentItem(1, false);
                break;
            case R.id.rl_circle:
                mMainViewpager.setCurrentItem(2, false);
                break;
            case R.id.rl_discover:
                mMainViewpager.setCurrentItem(3, false);
                break;
            case R.id.rl_mine:
                mMainViewpager.setCurrentItem(4, false);
                break;
        }
    }
}
