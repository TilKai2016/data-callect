package com.tilkai.client;

import com.tilkai.client.service.SendGoodweInverterService;
import com.tilkai.common.model.GoodweInverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(Client.class);

    @Autowired
    private SendGoodweInverterService sendGoodweInverterService;

    @Scheduled(fixedDelay = delay)
    public void send() {

        List<GoodweInverter> goodweInverters = sendGoodweInverterService.getGoodweInverterList();

        log.info("****** 从数据库里获取了记录 ： ******" + goodweInverters.size());

        for (GoodweInverter goodweInverter : goodweInverters) {
            sendGoodweInverterService.sendGoodweInverter(goodweInverter);
        }
    }
}
