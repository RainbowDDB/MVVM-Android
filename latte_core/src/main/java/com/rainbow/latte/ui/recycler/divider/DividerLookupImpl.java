package com.rainbow.latte.ui.recycler.divider;

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration;

/**
 * Latte-Core
 * Created By Rainbow on 2019/4/30.
 */
public class DividerLookupImpl implements DividerItemDecoration.DividerLookup {

    private final int COLOR;
    private final int SIZE;

    DividerLookupImpl(int color, int size) {
        this.COLOR = color;
        this.SIZE = size;
    }

    @Override
    public Divider getVerticalDivider(int position) {
        return new Divider.Builder().size(SIZE).color(COLOR).build();
    }

    @Override
    public Divider getHorizontalDivider(int position) {
        return new Divider.Builder().size(SIZE).color(COLOR).build();
    }
}
