package com.rainbow.latte.ui.launcher;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.rainbow.latte.ui.img.GlideApp;

/**
 * Latte-Core
 * Created By Rainbow on 2019/4/30.
 */
public class LauncherHolder implements Holder<Integer> {

    private ImageView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new ImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        GlideApp.with(context).asDrawable().load(data).into(mImageView);
    }
}
