package dao;

import pojo.NewsUser;

public interface NewsUserDao {
    /**
     * find user by username
     * @param username String
     * @return NewUser
     */
    NewsUser findByUsername(String username);

    /**
     * find user by userid
     * @param userId Integer
     * @return UserId
     */
    NewsUser findByUid(Integer userId);

    /**
     * Insert new user into DataBase
     * @param registUser NewsUser
     * @return Integer Success or not
     */
    Integer insertUser(NewsUser registUser);
}
