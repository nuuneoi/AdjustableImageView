package com.inthecheesefactory.thecheeselibrary.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;

/**
 * Created by nuuneoi on 2/17/15 AD.
 */
public class AdjustableImageButton extends ImageButton {

    boolean mAdjustViewBounds;

    public AdjustableImageButton(Context context) {
        super(context);
    }

    public AdjustableImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdjustableImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        mAdjustViewBounds = adjustViewBounds;
        super.setAdjustViewBounds(adjustViewBounds);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable mDrawable = getDrawable();
        if (mDrawable == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        if (mAdjustViewBounds) {
            int mDrawableWidth = mDrawable.getIntrinsicWidth();
            int mDrawableHeight = mDrawable.getIntrinsicHeight();
            int heightSize = MeasureSpec.getSize(heightMeasureSpec);
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int heightMode = MeasureSpec.getMode(heightMeasureSpec);
            int widthMode = MeasureSpec.getMode(widthMeasureSpec);

            if (heightMode == MeasureSpec.EXACTLY && widthMode != MeasureSpec.EXACTLY) {
                // Fixed Height & Adjustable Width
                int height = heightSize;
                int width = height * mDrawableWidth / mDrawableHeight;
                if (isInScrollingContainer())
                    setMeasuredDimension(width, height);
                else
                    setMeasuredDimension(Math.min(width, widthSize), Math.min(height, heightSize));
            } else if (widthMode == MeasureSpec.EXACTLY && heightMode != MeasureSpec.EXACTLY) {
                // Fixed Width & Adjustable Height
                int width = widthSize;
                int height = width * mDrawableHeight / mDrawableWidth;
                if (isInScrollingContainer())
                    setMeasuredDimension(width, height);
                else
                    setMeasuredDimension(Math.min(width, widthSize), Math.min(height, heightSize));
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private boolean isInScrollingContainer() {
        ViewParent p = getParent();
        while (p != null && p instanceof ViewGroup) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
            p = p.getParent();
        }
        return false;
    }
}
