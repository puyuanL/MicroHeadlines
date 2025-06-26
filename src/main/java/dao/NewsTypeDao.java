package dao;

import pojo.NewsType;

import java.util.List;

public interface NewsTypeDao {
    /**
     * find all type of news
     * @return List of NewsType
     */
    List<NewsType> findAll();
}
