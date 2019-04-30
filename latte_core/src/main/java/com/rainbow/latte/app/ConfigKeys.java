package com.rainbow.latte.app;

/**
 * Latte-Core
 * 使用枚举类作为全局静态不变的数据
 * Created By Rainbow on 2019/4/30.
 */
public enum ConfigKeys {
    API_HOST,                // 网络请求域名
    APPLICATION_CONTEXT,     // 全局上下文
    CONFIG_READY,            // 初始化是否完成
    ICON,                    // 自定义初始化项目
    INTERCEPTORS,            // 拦截器
    HANDLER,                 // 全局唯一Handler
    DEBUG,                   // debug状态
    JAVASCRIPT_INTERFACE     // WebView对接
}
