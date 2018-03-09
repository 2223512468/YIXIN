package com.yixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class LeftSlidingMenuFragment extends Fragment implements OnClickListener {
    private View yixinBtnLayout;
    private View circleBtnLayout;
    private View settingBtnLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_left_fragment, container,
                false);
        yixinBtnLayout = view.findViewById(R.id.yixinBtnLayout);
        yixinBtnLayout.setOnClickListener(this);
        circleBtnLayout = view.findViewById(R.id.circleBtnLayout);
        circleBtnLayout.setOnClickListener(this);
        settingBtnLayout = view.findViewById(R.id.settingBtnLayout);
        settingBtnLayout.setOnClickListener(this);

        System.out.println();
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment newContent = null;
        switch (v.getId()) {
            case R.id.yixinBtnLayout:
                newContent = new Fragment_yixin();
                yixinBtnLayout.setSelected(true);
                circleBtnLayout.setSelected(false);
                settingBtnLayout.setSelected(false);

                break;
            case R.id.circleBtnLayout:
                newContent = new Fragment_friend();
                yixinBtnLayout.setSelected(false);
                circleBtnLayout.setSelected(true);
                settingBtnLayout.setSelected(false);
                break;
            case R.id.settingBtnLayout:
                newContent = new Fragment_setting();
                yixinBtnLayout.setSelected(false);
                circleBtnLayout.setSelected(false);
                settingBtnLayout.setSelected(true);
                break;
            default:
                break;
        }

        if (newContent != null)
            switchFragment(newContent);

    }


    private void switchFragment(Fragment fragment) {
        if (getActivity() == null)
            return;

        MainActivity ra = (MainActivity) getActivity();
        ra.switchContent(fragment);

    }
}
