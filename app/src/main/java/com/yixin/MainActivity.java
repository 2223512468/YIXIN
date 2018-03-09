package com.yixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements OnClickListener {
    protected SlidingMenu mSlidingMenu;
    private ImageButton ivTitleBtnLeft;
    private Fragment mContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSlidingMenu();
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        ivTitleBtnLeft = (ImageButton) this.findViewById(R.id.ivTitleBtnLeft);
        ivTitleBtnLeft.setOnClickListener(this);

    }

    private void initSlidingMenu() {
        mContent = new Fragment_yixin();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, mContent)
                .commit();

        setBehindContentView(R.layout.main_left_layout);
        FragmentTransaction mFragementTransaction = getSupportFragmentManager()
                .beginTransaction();
        Fragment mFrag = new LeftSlidingMenuFragment();
        mFragementTransaction.replace(R.id.main_left_fragment, mFrag);
        mFragementTransaction.commit();
        // customize the SlidingMenu
        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setMode(SlidingMenu.LEFT);// 设置是左滑还是右滑，还是左右都可以滑，我这里只做了左滑
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);// 设置菜单宽度
        mSlidingMenu.setFadeDegree(0.35f);// 设置淡入淡出的比例
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//设置手势模式
        mSlidingMenu.setShadowDrawable(R.drawable.shadow);// 设置左菜单阴影图片
        mSlidingMenu.setFadeEnabled(true);// 设置滑动时菜单的是否淡入淡出
        mSlidingMenu.setBehindScrollScale(0.333f);// 设置滑动时拖拽效果

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivTitleBtnLeft:
                mSlidingMenu.showMenu(true);
                break;
            default:
                break;
        }

    }

    /**
     * 左侧菜单点击切换首页的内容
     */
    public void switchContent(Fragment fragment) {
        mContent = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        getSlidingMenu().showContent();
    }


}
