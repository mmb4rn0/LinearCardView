package com.mmb4rn0.linear;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.annotation.RequiresApi;

/**
 * Created by mmbarno on 10/25/17.
 * Email: manzur.mehedi@gagagugu.com
 */
@RequiresApi(17)
class LinearCardViewApi17Impl extends LinearCardViewBaseImpl {
    @Override
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper() {
            @Override
            public void drawRoundRect(Canvas canvas, RectF bounds, float cornerRadius,
                                      Paint paint) {
                canvas.drawRoundRect(bounds, cornerRadius, cornerRadius, paint);
            }
        };
    }
}
