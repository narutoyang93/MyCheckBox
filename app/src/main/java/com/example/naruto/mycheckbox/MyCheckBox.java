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
 * @Purpose
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
        if (drawableWidth > 0 || drawableHeight > 0) {
            for (Drawable drawable : getCompoundDrawables()) {
                if (drawable != null) {

                }
            }
        }
    }

    /**
     * 缩放Bitmap
     *
     * @param bm
     * @param newWidth
     * @param newHeight
     * @return
     */
    public Bitmap resetBitmapSize(Bitmap bm, int newWidth, int newHeight) {
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = newWidth == 0 ? 1 : (float) newWidth / width;
        float scaleHeight = newHeight == 0 ? 1 : (float) newHeight / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
    }
}
