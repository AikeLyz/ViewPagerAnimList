package com.vpal.lyz.pagetransform;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by lyz on 2017/4/4.
 * 背景渐变色
 */

public class GradientColorPageTransform implements ViewPager.PageTransformer {

    ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();

    @Override
    public void transformPage(View page, float position) {
        int colorNow = (Integer) mArgbEvaluator.evaluate(position, 0XFF007500,0XFF3C3C3C);
        page.setBackgroundColor(colorNow);
    }
}
