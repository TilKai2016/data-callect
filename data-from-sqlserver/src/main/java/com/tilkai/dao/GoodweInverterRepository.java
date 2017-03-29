package com.tilkai.dao;

import com.tilkai.common.model.GoodweInverter;
import java.util.List;

/**
 * @author tilkai
 */
public class GoodweInverterRepository extends AbstractJdbcDaoSupport {


    public List<GoodweInverter> getGoodweInverterListByTime(String tableName, String startTime, String endTime) {

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("   * ");
        sql.append(" FROM ");
        sql.append(    tableName );
        sql.append(" WHERE ");
        sql.append("   CreationDate ");
        sql.append(" BETWEEN ");
        sql.append(    startTime );
        sql.append(" AND ");
        sql.append(    endTime );
        sql.append(" ORDER BY ");
        sql.append("   CreationDate ASC ");


        return jdbcTemplate.query(sql.toString(), (rs, rowNum) -> {
            GoodweInverter goodweInverter = new GoodweInverter();

            goodweInverter.setSn(rs.getString("SN"));
            goodweInverter.setState(rs.getString("WorkMode"));

            return goodweInverter;
        });

//        return jdbcTemplate.query(sql.toString(), new RowMapper<GoodweInverter>() {
//
//            public GoodweInverter mapRow(ResultSet rs, int rowNum) throws SQLException {
//                GoodweInverter goodweInverter = new GoodweInverter();
//
//                goodweInverter.setSn(rs.getString("SN"));
//
//                return goodweInverter;
//            }
//        });

    }
}
