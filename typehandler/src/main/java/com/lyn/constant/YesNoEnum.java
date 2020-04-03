package com.lyn.constant;

import com.lyn.constant.enums.MyEnumeration;

/**
 * org.apache.ibatis.type.AutoEnumTypeHandler: 用来转换枚举的字面值
 * org.apache.ibatis.type.EnumOrdinalTypeHandler: 用来转换枚举的索引值
 */
public enum YesNoEnum implements MyEnumeration<Integer, String> {
    /**
     *
     */
    NO(0, "否"), YES(1, "是");
    private Integer code;
    private String value;

    YesNoEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
