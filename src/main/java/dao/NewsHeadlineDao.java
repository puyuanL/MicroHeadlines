package dao;

import pojo.NewsHeadline;
import pojo.vo.HeadlineDetailVo;
import pojo.vo.HeadlinePageVo;
import pojo.vo.HeadlineQueryVo;

import java.util.List;

public interface NewsHeadlineDao {
    /**
     * Find data on current page
     * @param headlineQueryVo HeadlineQueryVo
     * @return All query data
     */
     List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    /**
     * find data match the Query
     * @param headlineQueryVo HeadlineQueryVo
     * @return number of data
     */
     int findPageCount(HeadlineQueryVo headlineQueryVo);

    /**
     *
     * @param hid
     * @return
     */
     int increasePageViews(int hid);

    /**
     * find news detail, base on hid
     * @param hid id of news
     * @return all data of news
     */
     HeadlineDetailVo findHeadlineDetail(int hid);

//    int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     *
     * @param hid
     * @return
     */
//    NewsHeadline findByHid(Integer hid);

//    int update(NewsHeadline newsHeadline);

//    int removeByHid(int hid);
}
