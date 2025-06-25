package service;

import pojo.NewsUser;

public interface NewsUserService {
    /**
     * Find user's account by userName
     * @param username user account name
     * @return return 'NewsUser', return null if Object can't find
     */
    NewsUser findByUsername(String username);

    /**
     * Find user's account by userId
     * @param userId user account
     * @return return 'NewsUser', return null if Object can't find
     */
    NewsUser findByUid(Integer userId);

    /**
     * Save information into Database.
     * @param registUser NewUser
     * @return Integer.  Success: return int (>0);  Fail: return int 0
     */
    Integer registUser(NewsUser registUser);
}
