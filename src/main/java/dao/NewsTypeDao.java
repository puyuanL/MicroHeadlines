package dao;

import pojo.NewsType;

import java.util.List;

public interface NewsTypeDao {
    /**
     *
     * @return
     */
    List<NewsType> findAll();
}
