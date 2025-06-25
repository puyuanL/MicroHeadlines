package dao;

import pojo.NewsHeadline;
import pojo.vo.HeadlineDetailVo;
import pojo.vo.HeadlinePageVo;
import pojo.vo.HeadlineQueryVo;

import java.util.List;

public interface NewsHeadlineDao {
    /**
     *
     * @param headlineQueryVo
     * @return
     */
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    /**
     *
     * @param headlineQueryVo
     * @return
     */
    int findPageCount(HeadlineQueryVo headlineQueryVo);

    /**
     *
     * @param hid
     * @return
     */
    int incrPageViews(int hid);

    /**
     *
     * @param hid
     * @return
     */
    HeadlineDetailVo findHealineDetail(int hid);

    int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     *
     * @param hid
     * @return
     */
    NewsHeadline findByHid(Integer hid);

    int update(NewsHeadline newsHeadline);

    int removeByHid(int hid);
}
