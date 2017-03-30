package com.tilkai.client.dao;

import com.tilkai.client.Utils.DateUtil;
import com.tilkai.common.model.GoodweInverter;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

/**
 * 逆变器Repo
 * @author tilkai
 */
@Repository
public class GoodweInverterRepository extends AbstractJdbcDaoSupport {


    /**
     * 查询逆变器数据表，将查询结果存放到List<GoodweInverter>中
     * @param tableName 表名称
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return List<GoodweInverter>
     *
     * lambda表达式的原始内容
     * return jdbcTemplate.query(sql.toString(), new RowMapper<GoodweInverter>() {
     *      public GoodweInverter mapRow(ResultSet rs, int rowNum) throws SQLException {
     *          GoodweInverter goodweInverter = new GoodweInverter();
     *          goodweInverter.setSn(rs.getString("SN"));
     *          return goodweInverter;
     *      }
     * });
     */
    public List<GoodweInverter> getGoodweInverterListByTime(String tableName, String startTime, String endTime) {

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("   t1.* ");
        sql.append(" FROM ");
        sql.append(    tableName + " t1, ");
        sql.append("  (SELECT ");
        sql.append("     InventerSN, ");
        sql.append("     MAX(CreationDate) CreationDate ");
        sql.append("   FROM ");
        sql.append(      tableName );
        sql.append("   WHERE ");
        sql.append("     CreationDate ");
        sql.append("   BETWEEN ");
        sql.append(      " '" + startTime + "' " );
        sql.append("   AND ");
        sql.append(      " '" + endTime + "' " );
        sql.append("   GROUP BY ");
        sql.append("     InventerSN) t2 ");
        sql.append(" WHERE ");
        sql.append("   t1.InventerSN = t2.InventerSN ");
        sql.append(" AND ");
        sql.append("   t1.CreationDate = t2.CreationDate ");
        sql.append(" ORDER BY ");
        sql.append("   t1.CreationDate ");


        return jdbcTemplate.query(sql.toString(), (rs, rowNum) -> {
            GoodweInverter goodweInverter = new GoodweInverter();

            goodweInverter.setSn(rs.getString("InventerSN")); // InventerSN -> sn SN码
            goodweInverter.setState(rs.getString("WorkMode")); // WorkMode -> state 工作状态
            try {
                goodweInverter.setRecordTime(DateUtil.dateStr2Calendar(rs.getString("CreationDate"), "yyyy-MM-dd HH:mm:ss")); // CreationDate -> recordTime 记录时间
            } catch (ParseException e) {
                e.printStackTrace();
            }
            goodweInverter.setPv1Current(rs.getBigDecimal("Ipv1")); // Ipv1 -> Pv1Current 第一路电流
            goodweInverter.setPv2Current(rs.getBigDecimal("Ipv2")); // Ipv1 -> Pv1Current 第二路电流
            goodweInverter.setPv1Voltage(rs.getBigDecimal("Vpv1")); // Vpv1 -> Pv1Voltage 第一路电压
            goodweInverter.setPv2Voltage(rs.getBigDecimal("Vpv2")); // Vpv2 -> Pv2Voltage 第二路电压
            goodweInverter.setPowerOutputTotal(rs.getBigDecimal("Pac")); // Pac -> PowerOutputTotal 交流输出功率
            goodweInverter.setTemperature(rs.getBigDecimal("Tempperature")); // Tempperature -> temperature 温度
            goodweInverter.setEnergyOutputDay(rs.getBigDecimal("EDay")); // EDay -> EnergyOutputDay 日发电量
//            goodweInverter.setEnergyOutputTotal(rs.getBigDecimal("")); // -> EnergyOutputTotal 总发电量(未找到)
//            goodweInverter.setHourTotal(rs.getBigDecimal("")); // -> HourTotal 总发电小时数
            goodweInverter.setVoltagePhaseA(rs.getBigDecimal("Vac1")); // Vac1 -> VoltagePhaseA A相电压
            goodweInverter.setVoltagePhaseB(rs.getBigDecimal("Vac2")); // Vac2 -> VoltagePhaseB B相电压
            goodweInverter.setVoltagePhaseC(rs.getBigDecimal("Vac3")); // Vac3 -> VoltagePhaseC C相电压
            goodweInverter.setCurrentPhaseA(rs.getBigDecimal("Iac1")); // Iac1 -> CurrentPhaseA A相电流
            goodweInverter.setCurrentPhaseB(rs.getBigDecimal("Iac2")); // Iac2 -> CurrentPhaseB B相电流
            goodweInverter.setCurrentPhaseC(rs.getBigDecimal("Iac3")); // Iac3 -> CurrentPhaseC C相电流
            goodweInverter.setFrequency(rs.getBigDecimal("Fac1")); // Fac1 -> Frequency 并网频率
            goodweInverter.setCode1(rs.getLong("ErrorMessage")); // ErrorMessage -> Code1 逆变器状态1
            goodweInverter.setCode2(rs.getLong("WarningCode")); // WarningCode -> Code2 逆变器状态2

            return goodweInverter;
        });

    }
}
