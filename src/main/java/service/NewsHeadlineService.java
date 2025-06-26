package service;

import pojo.NewsHeadline;
import pojo.vo.HeadlineDetailVo;
import pojo.vo.HeadlineQueryVo;

import java.util.Map;

public interface NewsHeadlineService {
    /**
     *
     * @param headlineQueryVo
     * @return
     */
     Map<String, Object> findPage(HeadlineQueryVo headlineQueryVo);

    /**
     *
     * @param hid
     * @return
     */
//    HeadlineDetailVo findHeadlineDetail(int hid);

    /**
     *
     * @param newsHeadline
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
