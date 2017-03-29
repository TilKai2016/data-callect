package com.tilkai.client.service;

import com.tilkai.common.model.GoodweInverter;
import com.tilkai.service.GoodweInverterService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static com.tilkai.client.config.AmqpConfig.delay;

/**
 * @author tilkai
 */
@Service
public class SendGoodweInverterServiceImpl implements SendGoodweInverterService {

    @Autowired
    private GoodweInverterService goodweInverterService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<GoodweInverter> getGoodweInverterList() {

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        StringBuffer tableName = new StringBuffer();

        tableName.append("TInventerData");
        tableName.append(monthFormat.format(calendar.getTime()));

        String endTime = timeFormat.format(calendar.getTime());

        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - delay);

        String startTime = timeFormat.format(calendar);

        return goodweInverterService.getGoodweInverterListByTime(tableName.toString(), startTime, endTime);

    }

    @Override
    public void sendGoodweInverter(GoodweInverter goodweInverter) {
        if (goodweInverter != null) {
            this.rabbitTemplate.convertAndSend("hpvm.data", goodweInverter);
        }
    }
}
