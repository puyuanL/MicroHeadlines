package controller;

import common.Result;
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
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();


    /**
     * 删除头条业务接口 实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 更新头条的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 修改头条回显业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 发布头条的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
