package com.vpal.lyz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/4.
 */

public class FragmentDemo extends Fragment {

    @BindView(R.id.iv_fragment_bg)
    ImageView ivFragmentBg;
    Unbinder unbinder;



    public FragmentDemo() {

    }

    int drawable = -1;
    public FragmentDemo(int drawable) {
        this.drawable = drawable;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_default, container, false);
        unbinder = ButterKnife.bind(this, view);

        if (drawable != -1) {
            ivFragmentBg.setBackgroundResource(drawable);
        }
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
