package dao.impl;

import dao.BaseDao;
import dao.NewsHeadlineDao;
import pojo.NewsHeadline;
import pojo.vo.HeadlineDetailVo;
import pojo.vo.HeadlinePageVo;
import pojo.vo.HeadlineQueryVo;

import java.util.ArrayList;
import java.util.List;

public class NewsHeadlineDaoImpl extends BaseDao implements NewsHeadlineDao {

    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo) {
        String keyWords = headlineQueryVo.getKeyWords();
        Integer newsType = headlineQueryVo.getType();
        String sql = """
                SELECT
                    hid,
                    title,
                    type,
                    page_views AS pageViews,
                    TIMESTAMPDIFF(HOUR,create_time,NOW()) AS pastHours,
                    publisher
                FROM news_headline
                WHERE is_deleted=0""";
        StringBuilder sqlBuffer = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        if(keyWords != null && !keyWords.isEmpty()) {
            sqlBuffer.append(" AND title LIKE ?");
            params.add("%" + keyWords + "%");
        }
        if(newsType != 0) {
            sqlBuffer.append(" AND type = ?");
            params.add(newsType);
        }
        sqlBuffer.append(" ORDER BY pastHours ASC, pageViews DESC");
        int pageNum = headlineQueryVo.getPageNum();
        int pageSize = headlineQueryVo.getPageSize();
        sqlBuffer.append(" LIMIT ?,?");
        params.add((pageNum - 1) * pageSize);
        params.add(pageSize);

        return baseQuery(HeadlinePageVo.class, sqlBuffer.toString(), params.toArray());
    }

    @Override
    public int findPageCount(HeadlineQueryVo headlineQueryVo) {
        String keyWords = headlineQueryVo.getKeyWords();
        Integer newsType = headlineQueryVo.getType();
        String sql = """
                SELECT COUNT(1) FROM news_headline WHERE is_deleted=0""";
        StringBuilder sqlBuffer = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        if(keyWords != null && !keyWords.isEmpty()) {
            sqlBuffer.append(" AND title LIKE ?");
            params.add("%" + keyWords + "%");
        }
        if(newsType != 0) {
            sqlBuffer.append(" AND type = ?");
            params.add(newsType);
        }

        Long totalSize = baseQueryObject(Long.class, sqlBuffer.toString(), params.toArray());
        return totalSize.intValue();
    }

    @Override
    public void increasePageViews(int hid) {
        String sql = """
                UPDATE news_headline SET page_views = page_views + 1
                WHERE hid = ?""";
        baseUpdate(sql, hid);
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(int hid) {
        String sql = """
                SELECT
                    hid,
                    title,
                    article,
                    type,
                    tname AS typeName,
                    page_views AS pageViews,
                    TIMESTAMPDIFF(HOUR,create_time,NOW()) AS pastHours,
                    publisher,
                    nick_name AS author
                FROM news_headline nh JOIN news_type nt
                    ON nt.tid=nh.type JOIN news_user nu
                    ON nh.publisher=nu.uid
                WHERE is_deleted=0 AND hid=?""";

        List<HeadlineDetailVo> headlineDetailVoList = baseQuery(HeadlineDetailVo.class, sql, hid);
        if(headlineDetailVoList != null && !headlineDetailVoList.isEmpty()) {
            return headlineDetailVoList.get(0);
        }
        return null;
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        String sql = """
                INSERT news_headline(title,article,type,publisher,page_views,create_time,update_time,is_deleted)
                VALUES(?,?,?,?,0,NOW(),NOW(),0)""";
        List<Object> params = new ArrayList<>();
        params.add(newsHeadline.getTitle());
        params.add(newsHeadline.getArticle());
        params.add(newsHeadline.getType());
        params.add(newsHeadline.getPublisher());
        return baseUpdate(sql, params.toArray());
    }

    @Override
    public NewsHeadline findByHid(Integer hid) {
        String sql = """
                SELECT hid,title,article,type
                FROM news_headline WHERE hid=?""";
        List<NewsHeadline> headlineList = baseQuery(NewsHeadline.class, sql, hid);
        if(headlineList != null && !headlineList.isEmpty()) {
            return headlineList.get(0);
        }
        return null;
    }


    @Override
    public int update(NewsHeadline newsHeadline) {
        String sql = """
                UPDATE news_headline SET
                    title = ?,
                    article = ?,
                    type = ?
                WHERE hid = ?
                """;
        List<Object> params = new ArrayList<>();
        params.add(newsHeadline.getTitle());
        params.add(newsHeadline.getArticle());
        params.add(newsHeadline.getType());
        params.add(newsHeadline.getHid());
        return baseUpdate(sql, params.toArray());
    }

    @Override
    public int removeByHid(int hid) {
        String sql = """
                UPDATE news_headline
                SET is_deleted=1
                WHERE hid=?""";
        return baseUpdate(sql, hid);
    }
}
