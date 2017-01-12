package org.uiplus.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by zhangyuanxin on 2016/12/29.
 */

public class FontView extends TextView {

    final static String DEFAULT_FONT = "fonts/uifont.ttf";

    public FontView(Context context) {
        super(context);
    }

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FontView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        try {
            TypedArray typedArray = this.getContext().obtainStyledAttributes(attrs, R.styleable.FontView);
            String font = typedArray.getString(R.styleable.FontView_font);
            boolean rotate = typedArray.getBoolean(R.styleable.FontView_rotate, false);
            typedArray.recycle();

            if(!this.isInEditMode()) {
                this.setTypeface(TypeFaceFactory.getTypeFace(this.getContext(), null == font || font.isEmpty() ? DEFAULT_FONT : font));

                if (rotate) {
                    this.startAnimation(AnimationUtils.loadAnimation(this.getContext(), R.anim.rotate_left));
                } else {
                    this.clearAnimation();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
