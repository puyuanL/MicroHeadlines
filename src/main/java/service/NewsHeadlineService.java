package service;

import pojo.NewsHeadline;
import pojo.vo.HeadlineDetailVo;
import pojo.vo.HeadlineQueryVo;

import java.util.Map;

public interface NewsHeadlineService {
    /**
     * find all news data, base on headlineQuery's keywords
     * @param headlineQueryVo HeadlineQueryVo
     * @return map of all news data
     */
     Map<String, Object> findPage(HeadlineQueryVo headlineQueryVo);

    /**
     * find news detail, base on hid
     * @param hid id of news
     * @return all data of news
     */
    HeadlineDetailVo findHeadlineDetail(int hid);

    /**
     * add one piece of news to database
     * @param newsHeadline NewsHeadline
     * @return SQL State Code
     */
    int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     * find news data by hid
     * @param hid news id
     * @return NewsHeadline
     */
    NewsHeadline findByHid(Integer hid);

    /**
     * update news data
     * @param newsHeadline NewsHeadline
     * @return SQL State Code
     */
    int update(NewsHeadline newsHeadline);


    /**
     * remove news data
     * @param hid news id
     * @return SQL State Code
     */
    int removeByHid(int hid);
}
