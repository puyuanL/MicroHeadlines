package dao.impl;

import dao.BaseDao;
import dao.NewsUserDao;
import pojo.NewsUser;
import util.JDBCUtil;

import java.util.List;

public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {
    @Override
    public NewsUser findByUsername(String username) {
        String sql = """
                select
                    uid,
                    username,
                    user_pwd AS userPwd,
                    nick_name AS nickName
                from news_user
                where username = ?
                """;
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, username);
        return newsUserList != null && !newsUserList.isEmpty() ? newsUserList.get(0) : null;
    }

    @Override
    public NewsUser findByUid(Integer userId) {
        String sql = """
                select
                    uid,
                    username,
                    user_pwd AS userPwd,
                    nick_name AS nickName
                from news_user
                where uid = ?
                """;
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, userId);
        return newsUserList != null && !newsUserList.isEmpty() ? newsUserList.get(0) : null;
    }

    @Override
    public Integer insertUser(NewsUser registUser) {
        String sql = """
                insert into news_user(username,user_pwd,nick_name)
                values(?,?,?);
                """;
        String username = registUser.getUsername();
        String userPwd = registUser.getUserPwd();
        String nickName = registUser.getNickName();
        return baseUpdate(sql, username, userPwd, nickName);
    }
}
