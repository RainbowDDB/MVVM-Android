package com.rainbow.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rainbow.latte.app.Latte;
import com.rainbow.latte.net.RestClient;
import com.rainbow.latte.ui.recycler.MultipleRecyclerAdapter;
import com.rainbow.latte.ui.recycler.data.DataConverter;

/**
 * Latte-Core
 * Created By Rainbow on 2019/4/30.
 */
public class RefreshHandler
        implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    // private final Context CONTEXT;
    private final SwipeRefreshLayout REFRESH_LAYOUT;
    private final PagingBean BEAN;
    private final RecyclerView RECYCLER_VIEW;
    private final DataConverter CONVERTER;
    private MultipleRecyclerAdapter mAdapter;

    private RefreshHandler(SwipeRefreshLayout refreshLayout,
                           RecyclerView recyclerView,
                           MultipleRecyclerAdapter adapter,
                           DataConverter converter,
                           PagingBean bean) {
        this.REFRESH_LAYOUT = refreshLayout;
        this.RECYCLER_VIEW = recyclerView;
        this.mAdapter = adapter;
        this.CONVERTER = converter;
        this.BEAN = bean;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    public static RefreshHandler create(SwipeRefreshLayout swipeRefreshLayout,
                                        RecyclerView recyclerView,
                                        MultipleRecyclerAdapter adapter,
                                        DataConverter converter) {
        return new RefreshHandler(
                swipeRefreshLayout,
                recyclerView,
                adapter,
                converter,
                new PagingBean());
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(() -> REFRESH_LAYOUT.setRefreshing(false), 2000);
    }

    public void firstPage(String url) {
        BEAN.setDelayed(1000);
        RestClient.builder()
                .url(url)
                .success((response -> {
                    final JsonObject object = new JsonParser().parse(response).getAsJsonObject();
                    BEAN.setTotal(object.get("total").getAsInt())
                            .setPageSize(object.get("page_size").getAsInt());
                    mAdapter.setDataConverter(CONVERTER.setJsonData(response));
                    mAdapter.setOnLoadMoreListener(this, RECYCLER_VIEW);
                    RECYCLER_VIEW.setAdapter(mAdapter);
                    BEAN.addIndex();
                }))
                .build()
                .get();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
