package com.tilkai.service;

import com.tilkai.common.model.GoodweInverter;
import com.tilkai.dao.GoodweInverterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tilkai
 */
@Service
public class GoodweInverterServiceImpl implements GoodweInverterService {

    @Autowired
    private GoodweInverterRepository goodweInverterRepository;

    @Override
    public List<GoodweInverter> getGoodweInverterListByTime(String tableName, String startTime, String endTime) {

        return goodweInverterRepository.getGoodweInverterListByTime(tableName, startTime, endTime);
    }
}
