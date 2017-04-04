# Viewpager动效+仿微信底部导航栏

----------

## 目录

* [功能介绍](#功能介绍)
* [效果图与示例 apk](#效果图与示例-apk)
* [使用](#使用)

## 功能介绍

- [x] 实现底部导航栏随滑动字体逐渐变色以及图片的渐变动效
- [x] 实现viewpager滑动过程中的各种动效


## 效果图与示例 apk

![](https://raw.githubusercontent.com/AikeLyz/ViewPagerAnimList/master/gif/ViewPager动效1.gif)

![](https://raw.githubusercontent.com/AikeLyz/ViewPagerAnimList/master/gif/ViewPager动效2.gif)


![](https://raw.githubusercontent.com/AikeLyz/ViewPagerAnimList/master/gif/ViewPager动效3.gif)


![](https://raw.githubusercontent.com/AikeLyz/ViewPagerAnimList/master/gif/ViewPager动效4.gif)


![](https://raw.githubusercontent.com/AikeLyz/ViewPagerAnimList/master/gif/ViewPager动效5.gif)

### 示例 apk下载 ###
- [https://github.com/AikeLyz/ViewPagerAnimList/blob/master/app-debug.apk?raw=true](https://github.com/AikeLyz/ViewPagerAnimList/blob/master/app-debug.apk?raw=true "下载apk")  


## 使用

	//可修改渐变的颜色值， 现在的色值是模仿微信的灰和绿
	int colorBefore = (Integer) mArgbEvaluator.evaluate(positionOffset, 0XFF007500, 0XFF3C3C3C); 
	int colorNow = (Integer) mArgbEvaluator.evaluate(positionOffset, 0XFF3C3C3C, 0XFF007500);


----------


	 viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
						// 此方法是根据positionOffset滑动百分比来进行改变底部导航栏的字色和图标渐变的
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


----------
	
	//此处是给viewPager加入动画的方法，在项目pagetransform包中，有各种类似ZoomPageTransformer的方法
	 viewPager.setPageTransformer(true ,new ZoomPageTransformer());


### 博客地址： ###


- [http://blog.csdn.net/u014728843/article/details/69192831](http://blog.csdn.net/u014728843/article/details/69192831 "博客地址")

### 交流账号 ###


- QQ:911288373
- 邮箱:[911288373@qq.com](911288373@qq.com "QQ邮箱")
