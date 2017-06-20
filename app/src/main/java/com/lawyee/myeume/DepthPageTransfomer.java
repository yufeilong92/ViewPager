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
 * @date: 2017/6/20 16:31
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class DepthPageTransfomer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;
    @Override
    public void transformPage(View view, float position) {
        int pageWith = view.getWidth();
        if (position<-1){
            view.setAlpha(0);
        }else if (position<=0){
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);

        }else if (position<=1){
            view.setAlpha(1-position);
            view.setTranslationX(pageWith*-position);
            float scalefactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scalefactor);
            view.setScaleY(scalefactor);
        }else {
            view.setAlpha(0);
        }
    }
}
