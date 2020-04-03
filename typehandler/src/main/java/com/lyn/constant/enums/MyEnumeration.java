package com.lyn.constant.enums;

/**
 * 基础枚举 用于定义常用的接口
 */
public interface MyEnumeration<K, V> {
    /**
     * 获取枚举的code
     *
     * @return 泛型
     */
    K getCode();


    /**
     * 获取枚举的Value
     *
     * @return 泛型
     */
    V getValue();

}
