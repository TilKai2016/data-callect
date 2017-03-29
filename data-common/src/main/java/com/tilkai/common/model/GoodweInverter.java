package com.tilkai.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * @author tilkai
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodweInverter {

    public GoodweInverter() {
    }

    /**
     * 逆变器sn
     */
    protected String sn;

    /**
     * 状态
     */
    protected String state;

    /**
     * 记录时间
     */
    protected Calendar recordTime;

    /**
     * PV1电流
     */
    protected BigDecimal pv1Current;

    /**
     * PV1电压
     */
    protected BigDecimal pv1Voltage;

    /**
     * PV2电流
     */
    protected BigDecimal pv2Current;

    /**
     * PV2电压
     */
    protected BigDecimal pv2Voltage;

    /**
     * 交流输出功率
     */
    protected BigDecimal powerOutputTotal;

    /**
     * 温度
     */
    protected BigDecimal temperature;

    /**
     * 日发电量
     */
    protected BigDecimal energyOutputDay;

    /**
     * 总发电量
     */
    protected BigDecimal energyOutputTotal;

    /**
     * 总发电小时数
     */
    protected BigDecimal hourTotal;

    /**
     * A相电压
     */
    protected BigDecimal voltagePhaseA;

    /**
     * B相电压
     */
    protected BigDecimal voltagePhaseB;

    /**
     * C相电压
     */
    protected BigDecimal voltagePhaseC;

    /**
     * A相电流
     */
    protected BigDecimal currentPhaseA;

    /**
     * B相电流
     */
    protected BigDecimal currentPhaseB;

    /**
     * C相电流
     */
    protected BigDecimal currentPhaseC;

    /**
     * 电网频率
     */
    protected BigDecimal frequency;

    /**
     * 逆变器状态1
     */
    protected Long code1;

    /**
     * 逆变器状态2
     */
    protected Long code2;

    @ApiModelProperty(example = "1483863230000", value = "记录时间", required = true)
    public Calendar getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Calendar recordTime) {
        this.recordTime = recordTime;
    }

    @ApiModelProperty(example = "1.25", value = "PV1电流")
    public BigDecimal getPv1Current() {
        return pv1Current;
    }

    public void setPv1Current(BigDecimal pv1Current) {
        this.pv1Current = pv1Current;
    }

    @ApiModelProperty(example = "4.25", value = "PV1电压")
    public BigDecimal getPv1Voltage() {
        return pv1Voltage;
    }

    public void setPv1Voltage(BigDecimal pv1Voltage) {
        this.pv1Voltage = pv1Voltage;
    }

    @ApiModelProperty(example = "1.25", value = "PV2电流")
    public BigDecimal getPv2Current() {
        return pv2Current;
    }

    public void setPv2Current(BigDecimal pv2Current) {
        this.pv2Current = pv2Current;
    }

    @ApiModelProperty(example = "4.25", value = "PV2电压")
    public BigDecimal getPv2Voltage() {
        return pv2Voltage;
    }

    public void setPv2Voltage(BigDecimal pv2Voltage) {
        this.pv2Voltage = pv2Voltage;
    }

    @ApiModelProperty(example = "5.23", value = "交流输出功率")
    public BigDecimal getPowerOutputTotal() {
        return powerOutputTotal;
    }

    public void setPowerOutputTotal(BigDecimal powerOutputTotal) {
        this.powerOutputTotal = powerOutputTotal;
    }

    @ApiModelProperty(example = "23.5", value = "温度")
    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    @ApiModelProperty(example = "123.5", value = "日发电量")
    public BigDecimal getEnergyOutputDay() {
        return energyOutputDay;
    }

    public void setEnergyOutputDay(BigDecimal energyOutputDay) {
        this.energyOutputDay = energyOutputDay;
    }

    @ApiModelProperty(example = "1236.3", value = "总发电量")
    public BigDecimal getEnergyOutputTotal() {
        return energyOutputTotal;
    }

    public void setEnergyOutputTotal(BigDecimal energyOutputTotal) {
        this.energyOutputTotal = energyOutputTotal;
    }

    @ApiModelProperty(example = "220", value = "A相电压")
    public BigDecimal getVoltagePhaseA() {
        return voltagePhaseA;
    }

    public void setVoltagePhaseA(BigDecimal voltagePhaseA) {
        this.voltagePhaseA = voltagePhaseA;
    }

    @ApiModelProperty(example = "220", value = "B相电压")
    public BigDecimal getVoltagePhaseB() {
        return voltagePhaseB;
    }

    public void setVoltagePhaseB(BigDecimal voltageLineBc) {
        this.voltagePhaseB = voltageLineBc;
    }

    @ApiModelProperty(example = "220", value = "C相电压")
    public BigDecimal getVoltagePhaseC() {
        return voltagePhaseC;
    }

    public void setVoltagePhaseC(BigDecimal voltageLineCa) {
        this.voltagePhaseC = voltageLineCa;
    }

    @ApiModelProperty(example = "3.25", value = "A相电流")
    public BigDecimal getCurrentPhaseA() {
        return currentPhaseA;
    }

    public void setCurrentPhaseA(BigDecimal currentPhaseA) {
        this.currentPhaseA = currentPhaseA;
    }

    @ApiModelProperty(example = "3.25", value = "B相电流")
    public BigDecimal getCurrentPhaseB() {
        return currentPhaseB;
    }

    public void setCurrentPhaseB(BigDecimal currentPhaseB) {
        this.currentPhaseB = currentPhaseB;
    }

    @ApiModelProperty(example = "3.25", value = "C相电流")
    public BigDecimal getCurrentPhaseC() {
        return currentPhaseC;
    }

    public void setCurrentPhaseC(BigDecimal currentPhaseC) {
        this.currentPhaseC = currentPhaseC;
    }

    @ApiModelProperty(example = "3.6", value = "电网频率")
    public BigDecimal getFrequency() {
        return frequency;
    }

    public void setFrequency(BigDecimal frequency) {
        this.frequency = frequency;
    }

    @ApiModelProperty(example = "0", value = "逆变器内部状态1")
    public Long getCode1() {
        return code1;
    }

    public void setCode1(Long code1) {
        this.code1 = code1;
    }

    @ApiModelProperty(example = "0", value = "逆变器内部状态2")
    public Long getCode2() {
        return code2;
    }

    public void setCode2(Long code2) {
        this.code2 = code2;
    }

    @ApiModelProperty(example = "Normal", value = "逆变器状态", required = true)
    public String getState() {
        return state;
    }

    public void setStateCode(int code) {
        switch (code) {
            case 0:
                state = "Wait";
            case 1:
                state = "Normal";
            case 2:
                state = "Fault";
            case 3:
                state = "PermanentFault";
        }
    }

    public void setState(String state) {
        this.state = state;
    }

    @ApiModelProperty(example = "100", value = "总发电小时数", required = false)
    public BigDecimal getHourTotal() {
        return hourTotal;
    }

    public void setHourTotal(BigDecimal hourTotal) {
        this.hourTotal = hourTotal;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
