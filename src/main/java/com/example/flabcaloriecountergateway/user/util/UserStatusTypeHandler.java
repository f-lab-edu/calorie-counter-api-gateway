package com.example.flabcaloriecountergateway.user.util;

import com.example.flabcaloriecountergateway.user.domain.UserStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserStatusTypeHandler extends BaseTypeHandler<UserStatus> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, UserStatus parameter, JdbcType jdbcType)
		throws SQLException {
		ps.setString(i, parameter.getStatusMessage());
	}

	@Override
	public UserStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return UserStatus.findByMessage(rs.getString(columnName));
	}

	@Override
	public UserStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return UserStatus.findByMessage(rs.getString(columnIndex));
	}

	@Override
	public UserStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return UserStatus.findByMessage(cs.getString(columnIndex));
	}

}

