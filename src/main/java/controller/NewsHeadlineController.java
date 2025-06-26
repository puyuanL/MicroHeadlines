package controller;

import common.Result;
import common.ResultCodeEnum;
import pojo.NewsHeadline;
import service.NewsHeadlineService;
import service.impl.NewsHeadlineServiceImpl;
import util.JwtHelper;
import util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController{
    private final NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();

    /**
     * delete headline news
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     */
    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * update headline news
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     */

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

    }

    /**
     * find headline news by hid
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     */
    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

    }

    /**
     * publish headline news
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String token = req.getHeader("token");

        Result<Object> result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        if(token != null && !JwtHelper.isExpiration(token)) {
            NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
            Long userId = JwtHelper.getUserId(token);
            assert userId != null;
            newsHeadline.setPublisher(userId.intValue());
            if(headlineService.addNewsHeadline(newsHeadline) > 0)
                result = Result.ok(null);
            else
                result = Result.build(null, ResultCodeEnum.PUBLISH_ERROR);
        }
        WebUtil.writeJson(resp, result);
    }
}
