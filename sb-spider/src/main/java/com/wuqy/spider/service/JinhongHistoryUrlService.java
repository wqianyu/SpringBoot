package com.wuqy.spider.service;

import com.wuqy.common.entity.content.JinhongHistory;
import com.wuqy.common.entity.content.JinhongHistoryExample;
import com.wuqy.persist.mapper.content.JinhongHistoryMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.wuqy.spider.service.CrawController.countDownLatch;


@Service
public class JinhongHistoryUrlService {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static List<String> HISTORY_URL = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    private JinhongHistoryMapper jinhongHistoryMapper;

    public void saveHistoryUrl() {
        if(1 == atomicInteger.incrementAndGet()) {
            List<JinhongHistory> historyUrl = jinhongHistoryMapper.selectByExample(new JinhongHistoryExample());
            if(CollectionUtils.isEmpty(historyUrl)) {
                List<JinhongHistory> insertList = HISTORY_URL.stream().map(url -> JinhongHistory.builder().url(url).build()).collect(Collectors.toList());
                jinhongHistoryMapper.insertListSelective(insertList.get(0), insertList);
                HISTORY_URL.clear();
                countDownLatch.countDown();
            }
        }
    }
}
