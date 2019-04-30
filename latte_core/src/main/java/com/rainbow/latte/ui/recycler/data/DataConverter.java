package com.rainbow.latte.ui.recycler.data;

import java.util.ArrayList;

/**
 * Latte-Core
 * 数据转换器，convert()实现Json的转换
 * Created By Rainbow on 2019/4/30.
 */
public abstract class DataConverter {

    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    protected String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()) {
            throw new NullPointerException("DATA IS NULL");
        }
        return mJsonData;
    }

    public DataConverter setJsonData(String json) {
        this.mJsonData = json;
        return this;
    }
}
