package com.tilkai.client.service;

import com.tilkai.common.model.GoodweInverter;

import java.util.List;

/**
 * @author tilkai
 */
public interface GoodweInverterService {

    List<GoodweInverter> getGoodweInverterListByTime(String tableName, String startTime, String endTime);
}
