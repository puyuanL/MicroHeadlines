package service.impl;

import dao.NewsTypeDao;
import dao.impl.NewsTypeDaoImpl;
import pojo.NewsType;
import service.NewsTypeService;

import java.util.List;

public class NewsTypeServiceImpl implements NewsTypeService {
    private final NewsTypeDao typeDao = new NewsTypeDaoImpl();
    @Override
    public List<NewsType> findAll() {
        return typeDao.findAll();
    }
}
