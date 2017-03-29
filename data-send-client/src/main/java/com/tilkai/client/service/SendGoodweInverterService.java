package com.tilkai.client.service;

import com.tilkai.common.model.GoodweInverter;

import java.util.List;

/**
 * @author tilkai
 */
public interface SendGoodweInverterService {

    List<GoodweInverter> getGoodweInverterList();

    void sendGoodweInverter(GoodweInverter goodweInverter);
}
