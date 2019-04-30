package com.rainbow.latte.ui.banner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.rainbow.latte.ui.img.GlideApp;

/**
 * Latte-Core
 * Created By Rainbow on 2019/4/30.
 */
public class ImageHolder implements Holder<String> {

    private ImageView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new ImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        GlideApp.with(context)
                .load(data)
                .dontAnimate()
                .centerCrop()
                .into(mImageView);
    }
}
