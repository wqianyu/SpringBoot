package com.wuqy.spider.service;

import com.wuqy.spider.service.util.SpringUtils;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.regex.Pattern;

public class MyCrawler extends WebCrawler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final String WEB_SITE = "http://www.snet.tv/";

    //定义抓取规则，这里过滤了css、js等等非html的后缀
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp4|zip|gz))$");

    //shouldVisit，应当被获取的url
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && href.startsWith(WEB_SITE);
    }

    //当获取到匹配的URL时，进行处理，我们可以在这里写我们的处理逻辑
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        if(url.indexOf("login") == -1) {
            logger.info("crawler URL: " + url);
            JinhongHistoryUrlService.HISTORY_URL.add(url);
            if (page.getParseData() instanceof HtmlParseData) {
                HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                String text = htmlParseData.getText();
                String html = htmlParseData.getHtml();
                Set<WebURL> links = htmlParseData.getOutgoingUrls();
//                System.out.println("Text length: " + text.length());
//                System.out.println("Html length: " + html.length());
                logger.info("crawler Number of outgoing links: " + links.size());
            }
        }
    }

    @Override
    public Object getMyLocalData() {
        return super.getMyLocalData();
    }

    @Override
    public void onBeforeExit() {
        super.onBeforeExit();
        logger.info("crawler finish");
        SpringUtils.getBean(JinhongHistoryUrlService.class).saveHistoryUrl();
        logger.info("crawler saveFinish");
    }
}
