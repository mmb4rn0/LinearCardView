package com.mmb4rn0.linear;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * Created by mmbarno on 10/25/17.
 * Email: manzur.mehedi@gagagugu.com
 */
@RequiresApi(21)
class LinearCardViewApi21Impl implements LinearCardImpl {
    @Override
    public void initialize(LinearCardViewDelegate cardView, Context context,
                           ColorStateList backgroundColor, float radius, float elevation, float maxElevation) {
        final RoundRectDrawable background = new RoundRectDrawable(backgroundColor, radius);
        cardView.setCardBackground(background);

        View view = cardView.getCardView();
        view.setClipToOutline(true);
        view.setElevation(elevation);
        setMaxElevation(cardView, maxElevation);
    }

    @Override
    public void setRadius(LinearCardViewDelegate cardView, float radius) {
        getCardBackground(cardView).setRadius(radius);
    }

    @Override
    public void initStatic() {
    }

    @Override
    public void setMaxElevation(LinearCardViewDelegate cardView, float maxElevation) {
        getCardBackground(cardView).setPadding(maxElevation,
                cardView.getUseCompatPadding(), cardView.getPreventCornerOverlap());
        updatePadding(cardView);
    }

    @Override
    public float getMaxElevation(LinearCardViewDelegate cardView) {
        return getCardBackground(cardView).getPadding();
    }

    @Override
    public float getMinWidth(LinearCardViewDelegate cardView) {
        return getRadius(cardView) * 2;
    }

    @Override
    public float getMinHeight(LinearCardViewDelegate cardView) {
        return getRadius(cardView) * 2;
    }

    @Override
    public float getRadius(LinearCardViewDelegate cardView) {
        return getCardBackground(cardView).getRadius();
    }

    @Override
    public void setElevation(LinearCardViewDelegate cardView, float elevation) {
        cardView.getCardView().setElevation(elevation);
    }

    @Override
    public float getElevation(LinearCardViewDelegate cardView) {
        return cardView.getCardView().getElevation();
    }

    @Override
    public void updatePadding(LinearCardViewDelegate cardView) {
        if (!cardView.getUseCompatPadding()) {
            cardView.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float elevation = getMaxElevation(cardView);
        final float radius = getRadius(cardView);
        int hPadding = (int) Math.ceil(RoundRectDrawableWithShadow
                .calculateHorizontalPadding(elevation, radius, cardView.getPreventCornerOverlap()));
        int vPadding = (int) Math.ceil(RoundRectDrawableWithShadow
                .calculateVerticalPadding(elevation, radius, cardView.getPreventCornerOverlap()));
        cardView.setShadowPadding(hPadding, vPadding, hPadding, vPadding);
    }

    @Override
    public void onCompatPaddingChanged(LinearCardViewDelegate cardView) {
        setMaxElevation(cardView, getMaxElevation(cardView));
    }

    @Override
    public void onPreventCornerOverlapChanged(LinearCardViewDelegate cardView) {
        setMaxElevation(cardView, getMaxElevation(cardView));
    }

    @Override
    public void setBackgroundColor(LinearCardViewDelegate cardView, @Nullable ColorStateList color) {
        getCardBackground(cardView).setColor(color);
    }

    @Override
    public ColorStateList getBackgroundColor(LinearCardViewDelegate cardView) {
        return getCardBackground(cardView).getColor();
    }

    private RoundRectDrawable getCardBackground(LinearCardViewDelegate cardView) {
        return ((RoundRectDrawable) cardView.getCardBackground());
    }

}
