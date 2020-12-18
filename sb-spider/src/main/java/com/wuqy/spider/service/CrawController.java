package com.wuqy.spider.service;

import com.wuqy.common.entity.content.JinhongHistory;
import com.wuqy.common.entity.content.JinhongHistoryExample;
import com.wuqy.persist.mapper.content.JinhongHistoryMapper;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class CrawController {

    private String seed = "http://www.snet.tv/homePage.action";
    private String seed2 = "http://www.snet.tv/snet_page/xg_sy.jsp";

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Autowired
    private JinhongHistoryMapper historyMapper;

//    @Scheduled(initialDelay = 10000, fixedDelay = 3600000)
    public void initCrawlerTask() throws Exception {
        List<JinhongHistory> historyUrl = historyMapper.selectByExample(new JinhongHistoryExample());
        if(CollectionUtils.isNotEmpty(historyUrl)) {
            countDownLatch.countDown();
            return;
        }
        //爬虫状态存储文件夹，可以从这里边读取数据，以边恢复之前的爬取状态
        String crawlStorageFolder = "/data/weblog/java/jinhong-admanager.security.snet.tv/crawl";
        //爬虫数量，也就是线程数，一般不超过CPU线程数
        int numberOfCrawlers = Runtime.getRuntime().availableProcessors()*2;
        //爬虫配置
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        //要爬取的起始地址，例如：http://www.ics.uci.edu/~lopes/);
        controller.addSeed(seed);
        controller.addSeed(seed2);
        //启动
        controller.start(MyCrawler.class, numberOfCrawlers);
    }
}
