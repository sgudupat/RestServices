package com.psc.users.dao;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.psc.users.domain.UserInfo;

public class UserInfoDao extends ConnectionDao {	 
	 static final Logger logger = Logger.getLogger(UserInfoDao.class); 
	public void  insertUserinfo(UserInfo userinfo) {		
		String sql = "INSERT INTO user_info  (user_id,firstname, lastname, age,gender) VALUES (:id, :firstname, :lastname,:age,:gender)";		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(userinfo);		 
		System.out.println("namedParameterJdbcTemplate::" + namedParameterJdbcTemplate);
		namedParameterJdbcTemplate.update(sql, parameterSource);
		}
	}

