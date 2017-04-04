package com.vpal.lyz.pagetransform;

import android.support.v4.view.ViewCompat;
import android.view.View;


public class DepthPageTransformer extends BasePageTransformer {
    private float mMinScale = 0.75f;

    public DepthPageTransformer() {
    }

    public DepthPageTransformer(float minScale) {
        setMinScale(minScale);
    }

    @Override
    public void handleInvisiblePage(View view, float position) {
        ViewCompat.setAlpha(view, 0);
    }

    @Override
    public void handleLeftPage(View view, float position) {
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);
    }

    @Override
    public void handleRightPage(View view, float position) {
            // Fade the page out.
            view.setAlpha(1 - position);
            // Counteract the default slide transition
            view.setTranslationX(-view.getWidth() * position);
            float scale = mMinScale + (1 - mMinScale) * (1 - position);
            view.setScaleX(scale);
            view.setScaleY(scale);
    }

    public void setMinScale(float minScale) {
        if (minScale >= 0.5f && minScale <= 1.0f) {
            mMinScale = minScale;
        }
    }

}