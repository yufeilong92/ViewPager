package com.lawyee.myeume;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication2
 * @Package com.lawyee.myeume
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/6/20 16:22
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;
    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        if (position<-1){
            view.setAlpha(0);
        }else if (position<=1){
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float verMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzmargin = pageWidth * (1 - scaleFactor) / 2;
            if (position<0){
                view.setTranslationX(horzmargin-verMargin/2);
            }else {
                view.setTranslationX(-horzmargin+verMargin/2);
            }
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setAlpha(MIN_ALPHA+(scaleFactor-MIN_SCALE)/(1-MIN_SCALE)*(1-MIN_ALPHA));

        }else {
            view.setAlpha(0);
        }
    }
}
