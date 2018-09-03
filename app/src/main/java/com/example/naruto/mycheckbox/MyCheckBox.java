package com.example.naruto.mycheckbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * @Purpose 支持设置drawable尺寸
 * @Author Naruto Yang
 * @CreateDate 2018/8/22 0022
 * @Note
 */
public class MyCheckBox extends android.support.v7.widget.AppCompatCheckBox {
    private Context context;
    private int drawableWidth;
    private int drawableHeight;

    public MyCheckBox(Context context) {
        super(context);
        this.context = context;
    }

    public MyCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public MyCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        /**
         * 通过这个方法，将attrs.xml中定义的declare-styleable的所有属性的值存储到TypedArray中
         */
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyCheckBox);
        //从TypedArray中取出对应的值来为要设置的属性赋值
        drawableWidth = ta.getDimensionPixelSize(R.styleable.MyCheckBox_drawableWidth, 0);
        drawableHeight = ta.getDimensionPixelSize(R.styleable.MyCheckBox_drawableHeight, 0);
        Rect rect = new Rect(0, 0, drawableWidth, drawableHeight);
        if (drawableWidth > 0 || drawableHeight > 0) {
            Drawable[] drawables = getCompoundDrawables();
            int count = drawables.length;
            for (int i = 0; i < count; i++) {
                Drawable drawable=drawables[i];
                if (drawable != null) {
                    drawable.setBounds(rect);
                }
            }
            setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
        }
    }
}
