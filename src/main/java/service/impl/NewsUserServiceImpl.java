package service.impl;

import dao.NewsUserDao;
import dao.impl.NewsUserDaoImpl;
import pojo.NewsUser;
import service.NewsUserService;
import util.MD5Util;

public class NewsUserServiceImpl implements NewsUserService {


    private final NewsUserDao userDao = new NewsUserDaoImpl();

    @Override
    public NewsUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public NewsUser findByUid(Integer userId) {
        return userDao.findByUid(userId);
    }

    @Override
    public Integer registUser(NewsUser registUser) {
        // Change password from 'Plaintext' to 'Ciphertext'
        registUser.setUserPwd(MD5Util.encrypt(registUser.getUserPwd()));
        return userDao.insertUser(registUser);
    }
}
