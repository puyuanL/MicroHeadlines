package controller;

import common.Result;
import common.ResultCodeEnum;
import pojo.NewsUser;
import service.NewsUserService;
import service.impl.NewsUserServiceImpl;
import util.JwtHelper;
import util.MD5Util;
import util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/user/*")
public class NewsUserController extends BaseController{


    private final NewsUserService userService = new NewsUserServiceImpl();

    /**
     * login in. Send userName and userPwd to server
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        /*  {
                "username":"zhangsan", //用户名
                "userPwd":"123456"     //明文密码
            }
        */
        NewsUser paramUser = WebUtil.readJson(req, NewsUser.class);

        // 调用服务层方法 实现登录
        NewsUser loginUser = userService.findByUsername(paramUser.getUsername());
        Result<Map<?, ?>> result = null;

        if(null != loginUser){
            if (MD5Util.encrypt(paramUser.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd())) {
                Map<String, String> data = new HashMap<>();
                data.put("token", JwtHelper.createToken(loginUser.getUid().longValue()));
                result = Result.ok(data);
            } else {
                result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        } else {
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);

        }
        // 向客户端响应登录验证信息
        WebUtil.writeJson(resp, result);
    }

    /**
     * accept token and query all information of the user
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     * */
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String token = req.getHeader("token");
        Result<Map<String, NewsUser>> result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        if(null != token) {
            if(!JwtHelper.isExpiration(token)){
                Integer uid = Objects.requireNonNull(JwtHelper.getUserId(token)).intValue();
                NewsUser newsUser = userService.findByUid(uid);
                Map<String, NewsUser> data = new HashMap<>();
                data.put("loginUser", newsUser);
                result = Result.ok(data);
            }
        }
        WebUtil.writeJson(resp, result);
    }

    /**
     * Send username to server, check if username is occupied
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     * */
    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String username = req.getParameter("username");
        NewsUser newsUser = userService.findByUsername(username);
        Result<?> result;
        if(null != newsUser) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        else {
            result = Result.build(null, ResultCodeEnum.SUCCESS);
        }
        WebUtil.writeJson(resp, result);
    }

    /**
     * Send username to server, check if username is occupied.
     * If not do register movement
     *
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     * */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        NewsUser newsUser = WebUtil.readJson(req, NewsUser.class);
        NewsUser usedUser = userService.findByUsername(newsUser.getUsername());
        Result<?> result;
        if(null != usedUser) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        else {
            Integer registCode = userService.registUser(newsUser);
            result = Result.build(null, ResultCodeEnum.SUCCESS);
        }
        WebUtil.writeJson(resp, result);
    }
}
