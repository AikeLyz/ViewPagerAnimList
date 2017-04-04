package com.vpal.lyz;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.vpal.lyz.pagetransform.AccordionPageTransformer;
import com.vpal.lyz.pagetransform.AlphaPageTransformer;
import com.vpal.lyz.pagetransform.CubePageTransformer;
import com.vpal.lyz.pagetransform.DefaultPageTransformer;
import com.vpal.lyz.pagetransform.DepthPageTransformer;
import com.vpal.lyz.pagetransform.FadePageTransformer;
import com.vpal.lyz.pagetransform.FlipPageTransformer;
import com.vpal.lyz.pagetransform.GradientColorPageTransform;
import com.vpal.lyz.pagetransform.InRightDownTransformer;
import com.vpal.lyz.pagetransform.InRightUpTransformer;
import com.vpal.lyz.pagetransform.RotatePageTransformer;
import com.vpal.lyz.pagetransform.SimplerPageTransform;
import com.vpal.lyz.pagetransform.SlowBackgroundTransformer;
import com.vpal.lyz.pagetransform.StackPageTransformer;
import com.vpal.lyz.pagetransform.ZoomCenterPageTransformer;
import com.vpal.lyz.pagetransform.ZoomFadePageTransformer;
import com.vpal.lyz.pagetransform.ZoomOutPageTransformer;
import com.vpal.lyz.pagetransform.ZoomPageTransformer;
import com.vpal.lyz.pagetransform.ZoomStackPageTransformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/4.
 */

public class MainActivity extends FragmentActivity {


    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.iv_bottom_1)
    ImageView ivBottom1;
    @BindView(R.id.iv_bottom_11)
    ImageView ivBottom11;
    @BindView(R.id.tv_bottom_1)
    TextView tvBottom1;
    @BindView(R.id.iv_bottom_2)
    ImageView ivBottom2;
    @BindView(R.id.iv_bottom_22)
    ImageView ivBottom22;
    @BindView(R.id.tv_bottom_2)
    TextView tvBottom2;
    @BindView(R.id.iv_bottom_3)
    ImageView ivBottom3;
    @BindView(R.id.iv_bottom_33)
    ImageView ivBottom33;
    @BindView(R.id.tv_bottom_3)
    TextView tvBottom3;
    @BindView(R.id.iv_bottom_4)
    ImageView ivBottom4;
    @BindView(R.id.iv_bottom_44)
    ImageView ivBottom44;
    @BindView(R.id.tv_bottom_4)
    TextView tvBottom4;
    @BindView(R.id.rl_bottom_1)
    RelativeLayout rlBottom1;
    @BindView(R.id.rl_bottom_2)
    RelativeLayout rlBottom2;
    @BindView(R.id.rl_bottom_3)
    RelativeLayout rlBottom3;
    @BindView(R.id.rl_bottom_4)
    RelativeLayout rlBottom4;

    private ArrayList<Fragment> fragments;
    private ArgbEvaluator mArgbEvaluator;
    private String[] pagetransforms;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        InitView();
    }

    private void InitView() {
        fragments = new ArrayList<Fragment>();
        mArgbEvaluator = new ArgbEvaluator();
        pagetransforms = getResources().getStringArray(R.array.pagetransform);

        SelectPageTransform();
        FragmentDemo fragment = new FragmentDemo(R.mipmap.one);
        FragmentDemo fragment1 = new FragmentDemo(R.mipmap.two);
        FragmentDemo fragment2 = new FragmentDemo(R.mipmap.three);
        FragmentDemo fragment3 = new FragmentDemo(R.mipmap.four);
        fragments.add(fragment);
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        SetBottomAnim(positionOffset, tvBottom1, tvBottom2, ivBottom1, ivBottom11, ivBottom2, ivBottom22);
                        break;
                    case 1:
                        SetBottomAnim(positionOffset, tvBottom2, tvBottom3, ivBottom2, ivBottom22, ivBottom3, ivBottom33);
                        break;
                    case 2:
                        SetBottomAnim(positionOffset, tvBottom3, tvBottom4, ivBottom3, ivBottom33, ivBottom4, ivBottom44);
                        break;

                }
            }

            @Override
            public void onPageSelected(int position) {
                SetBottom(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void SetBottomAnim(float positionOffset, TextView tv1, TextView tv2, ImageView iv1, ImageView iv11, ImageView iv2, ImageView iv22) {
        int colorBefore = (Integer) mArgbEvaluator.evaluate(positionOffset, 0XFF007500, 0XFF3C3C3C);
        int colorNow = (Integer) mArgbEvaluator.evaluate(positionOffset, 0XFF3C3C3C, 0XFF007500);
        tv1.setTextColor(colorBefore);
        tv2.setTextColor(colorNow);

        ViewCompat.setAlpha(iv11, positionOffset);
        ViewCompat.setAlpha(iv1, 1.0f - positionOffset);
        ViewCompat.setAlpha(iv22, 1.0f - positionOffset);
        ViewCompat.setAlpha(iv2, positionOffset);
    }

    private void SetBottom(int i) {
        tvBottom1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.textcolorDefault));
        tvBottom2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.textcolorDefault));
        tvBottom3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.textcolorDefault));
        tvBottom4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.textcolorDefault));

        ivBottom1.setAlpha(0f);
        ivBottom2.setAlpha(0f);
        ivBottom3.setAlpha(0f);
        ivBottom4.setAlpha(0f);
        ivBottom11.setAlpha(1f);
        ivBottom22.setAlpha(1f);
        ivBottom33.setAlpha(1f);
        ivBottom44.setAlpha(1f);

        switch (i) {
            case 0:
                tvBottom1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.textcolorSelect));
                ivBottom1.setAlpha(1f);
                ivBottom11.setAlpha(0f);
                break;
            case 1:
                tvBottom2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.textcolorSelect));
                ivBottom2.setAlpha(1f);
                ivBottom22.setAlpha(0f);
                break;
            case 2:
                tvBottom3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.textcolorSelect));
                ivBottom3.setAlpha(1f);
                ivBottom33.setAlpha(0f);
                break;
            case 3:
                tvBottom4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.textcolorSelect));
                ivBottom4.setAlpha(1f);
                ivBottom44.setAlpha(0f);
                break;
        }

    }

    @OnClick({R.id.rl_bottom_1, R.id.rl_bottom_2, R.id.rl_bottom_3, R.id.rl_bottom_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_bottom_1:
                SetBottom(0);
                break;
            case R.id.rl_bottom_2:
                SetBottom(1);
                break;
            case R.id.rl_bottom_3:
                SetBottom(2);
                break;
            case R.id.rl_bottom_4:
                SetBottom(3);
                break;
        }
    }

    private void SelectPageTransform() {
        ArrayAdapter<String> _Adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, pagetransforms);
        spinner.setAdapter(_Adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    viewPager.setPageTransformer(true ,new AccordionPageTransformer());
                } else if (position == 1) {
                    viewPager.setPageTransformer(true ,new AlphaPageTransformer());
                } else if (position == 2) {
                    viewPager.setPageTransformer(true ,new CubePageTransformer());
                } else if (position == 3) {
                    viewPager.setPageTransformer(true ,new DefaultPageTransformer());
                } else if (position == 4) {
                    viewPager.setPageTransformer(true ,new DepthPageTransformer());
                } else if (position == 5) {
                    viewPager.setPageTransformer(true ,new FadePageTransformer());
                } else if (position == 6) {
                    viewPager.setPageTransformer(true ,new FlipPageTransformer());
                } else if (position == 7) {
                    viewPager.setPageTransformer(true ,new InRightDownTransformer());
                } else if (position == 8) {
                    viewPager.setPageTransformer(true ,new InRightUpTransformer());
                } else if (position == 9) {
                    viewPager.setPageTransformer(true ,new RotatePageTransformer());
                } else if (position == 10) {
                    viewPager.setPageTransformer(true ,new SimplerPageTransform());
                } else if (position == 11) {
                    viewPager.setPageTransformer(true ,new SlowBackgroundTransformer());
                } else if (position == 12) {
                    viewPager.setPageTransformer(true ,new StackPageTransformer());
                } else if (position == 13) {
                    viewPager.setPageTransformer(true ,new ZoomCenterPageTransformer());
                } else if (position == 14) {
                    viewPager.setPageTransformer(true ,new ZoomFadePageTransformer());
                } else if (position == 15) {
                    viewPager.setPageTransformer(true ,new ZoomOutPageTransformer());
                } else if (position == 16) {
                    viewPager.setPageTransformer(true ,new ZoomPageTransformer());
                } else if (position == 17) {
                    viewPager.setPageTransformer(true ,new ZoomStackPageTransformer());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}
