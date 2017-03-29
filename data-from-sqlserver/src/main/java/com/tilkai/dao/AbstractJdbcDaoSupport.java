package com.tilkai.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author tilkai
 */
public abstract class AbstractJdbcDaoSupport {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
