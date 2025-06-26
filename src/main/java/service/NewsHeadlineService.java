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
     * @param newsHeadline
     * @return int
     */
//    int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     *
     * @param hid
     * @return
     */
//    NewsHeadline findByHid(Integer hid);

//    int update(NewsHeadline newsHeadline);


    /**
     *
     * @param hid
     * @return
     */
//    int removeByHid(int hid);
}
