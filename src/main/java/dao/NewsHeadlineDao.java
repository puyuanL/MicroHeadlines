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
     * increase news view number, after page visualize
     * @param hid headline news id
     */
     void increasePageViews(int hid);

    /**
     * find news detail, base on hid
     * @param hid id of news
     * @return all data of news
     */
     HeadlineDetailVo findHeadlineDetail(int hid);

    /**
     * find news detail, base on hid
     * @param newsHeadline NewsHeadline
     * @return SQL Insert State Code
     */
     int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     * find news by hid
     * @param hid news id
     * @return NewsHeadline all information
     */
    NewsHeadline findByHid(Integer hid);

    /**
     * update news by news info (hid)
     * @param newsHeadline NewsHeadline
     * @return SQL Insert State Code
     */
    int update(NewsHeadline newsHeadline);

    /**
     * remove news by hid
     * @param hid int
     * @return SQL Insert State Code
     */
    int removeByHid(int hid);
}
