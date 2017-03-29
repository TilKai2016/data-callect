package com.tilkai.client;

import com.tilkai.client.service.SendGoodweInverterService;
import com.tilkai.common.model.GoodweInverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

import static com.tilkai.client.config.AmqpConfig.delay;

/**
 * @author tilkai
 */
@Component
public class Client {

    @Autowired
    private SendGoodweInverterService sendGoodweInverterService;

    @Scheduled(fixedDelay = delay)
    public void send() {

        List<GoodweInverter> goodweInverters = sendGoodweInverterService.getGoodweInverterList();

        for (GoodweInverter goodweInverter : goodweInverters) {

        }
    }
}
