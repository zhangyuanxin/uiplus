package org.uiplus.views;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by zhangyuanxin on 2016/12/29.
 */

public class TypeFaceFactory {
    static Typeface typeface;

    public static Typeface getTypeFace(Context context, String resource) {
        if (null != typeface) {
            return typeface;
        }

        typeface = Typeface.createFromAsset(context.getAssets(), resource);

        return typeface;
    }

}
