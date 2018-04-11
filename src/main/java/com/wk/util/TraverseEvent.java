package com.wk.util;

/**
 * 遍历接口
 *
 * Created by 锴 on 2018/3/2.
 */
public interface TraverseEvent<T> {
    /**
     * 遍历每一个
     *
     * @param item
     * @return
     */
    boolean visit(T item);
}
