package com.mmb4rn0.linear;

import android.content.Context;
import android.content.res.ColorStateList;

import androidx.annotation.Nullable;

/**
 * Created by mmbarno on 10/25/17.
 * Email: manzur.mehedi@gagagugu.com
 */

public interface LinearCardImpl {
    void initialize(LinearCardViewDelegate cardView, Context context, ColorStateList backgroundColor,
                    float radius, float elevation, float maxElevation);

    void setRadius(LinearCardViewDelegate cardView, float radius);

    float getRadius(LinearCardViewDelegate cardView);

    void setElevation(LinearCardViewDelegate cardView, float elevation);

    float getElevation(LinearCardViewDelegate cardView);

    void initStatic();

    void setMaxElevation(LinearCardViewDelegate cardView, float maxElevation);

    float getMaxElevation(LinearCardViewDelegate cardView);

    float getMinWidth(LinearCardViewDelegate cardView);

    float getMinHeight(LinearCardViewDelegate cardView);

    void updatePadding(LinearCardViewDelegate cardView);

    void onCompatPaddingChanged(LinearCardViewDelegate cardView);

    void onPreventCornerOverlapChanged(LinearCardViewDelegate cardView);

    void setBackgroundColor(LinearCardViewDelegate cardView, @Nullable ColorStateList color);

    ColorStateList getBackgroundColor(LinearCardViewDelegate cardView);

}
