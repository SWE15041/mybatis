package com.lyn.config;

import com.lyn.constant.enums.MyEnumeration;
import com.lyn.utils.EnumUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义类型转换器
 *
 * @author lyn
 */
public class MyEnumTypeHandler<E extends MyEnumeration> extends BaseTypeHandler<E> {
    private Class<E> type;

    public MyEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, ((int) parameter.getCode()));
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int code = resultSet.getInt(columnName);
        return resultSet.wasNull() ? null : codeOf(code);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int code = resultSet.getInt(columnIndex);
        return resultSet.wasNull() ? null : codeOf(code);

    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int code = callableStatement.getInt(columnIndex);
        return callableStatement.wasNull() ? null : codeOf(code);
    }

    private E codeOf(int code) {
        try {
            return EnumUtil.getByCode(type, code);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cannot convert " + code + " to " + type.getSimpleName() + " by code value.", ex);
        }
    }
}
