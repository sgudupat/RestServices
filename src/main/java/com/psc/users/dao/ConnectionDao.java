package com.psc.users.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class ConnectionDao {
	
	   public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	    private SimpleJdbcTemplate simpleJdbcTemplate;
	    protected JdbcTemplate jdbcTemplate;

	    @Autowired
	    @Qualifier("dataSource")
	    public void setDataSource(DataSource dataSource) {
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	    public final NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
	        return namedParameterJdbcTemplate;
	    }

	    final public SimpleJdbcTemplate getSimpleJdbcTemplate() {
	        return this.simpleJdbcTemplate;
	    }

	    public final JdbcTemplate getJdbcTemplate() {
	        return jdbcTemplate;
	    }
}
