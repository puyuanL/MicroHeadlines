package service.impl;

import dao.NewsHeadlineDao;
import dao.impl.NewsHeadlineDaoImpl;
import pojo.NewsHeadline;
import pojo.vo.HeadlineDetailVo;
import pojo.vo.HeadlinePageVo;
import pojo.vo.HeadlineQueryVo;
import service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsHeadlineServiceImpl implements NewsHeadlineService {
    private final NewsHeadlineDao newsHeadlineDao;

    public NewsHeadlineServiceImpl() {
        newsHeadlineDao = new NewsHeadlineDaoImpl();
    }

    /**
     * Find headline page list according to query
     * @param headlineQueryVo HeadlineQueryVo
     * @return newsHeadlineMap Map<String, Object>
     **/
    public Map<String, Object> findPage(HeadlineQueryVo headlineQueryVo) {
        List<HeadlinePageVo> pageData = newsHeadlineDao.findPageList(headlineQueryVo);

        Map<String, Object> newsHeadlineMap = new HashMap<>();
        newsHeadlineMap.put("pageData", pageData);
        newsHeadlineMap.put("pageNum", headlineQueryVo.getPageNum());
        int pageSize = headlineQueryVo.getPageSize();
        newsHeadlineMap.put("pageSize", headlineQueryVo.getPageSize());
        int totalSize = newsHeadlineDao.findPageCount(headlineQueryVo);
        int totalPage = totalSize % pageSize == 0? totalSize / pageSize: totalSize / pageSize + 1;
        newsHeadlineMap.put("totalPage", totalPage);
        newsHeadlineMap.put("totalSize", totalSize);
        return newsHeadlineMap;
    }

    /**
     * find news detail, base on hid
     * @param hid id of news
     * @return all data of news
     */
    public HeadlineDetailVo findHeadlineDetail(int hid) {
        newsHeadlineDao.increasePageViews(hid);
        return newsHeadlineDao.findHeadlineDetail(hid);
    }

    /**
     * add one piece of news to database
     * @param newsHeadline NewsHeadline
     * @return SQL Insert State Code
     */
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        return newsHeadlineDao.addNewsHeadline(newsHeadline);
    }

    /**
     * find news data by hid
     * @param hid news id
     * @return NewsHeadline
     */
    public NewsHeadline findByHid(Integer hid) {
        return newsHeadlineDao.findByHid(hid);
    }

    /**
     * update news data
     * @param newsHeadline NewsHeadline
     */
    public int update(NewsHeadline newsHeadline) {
        return newsHeadlineDao.update(newsHeadline);
    }

    /**
     * remove news data
     * @param hid news id
     * @return SQL State Code
     */
    public int removeByHid(int hid) {
        return newsHeadlineDao.removeByHid(hid);
    }
}
