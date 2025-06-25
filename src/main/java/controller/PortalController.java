package controller;

import common.Result;
import pojo.NewsType;
import pojo.vo.HeadlineDetailVo;
import pojo.vo.HeadlineQueryVo;
import service.NewsHeadlineService;
import service.NewsTypeService;
import service.impl.NewsHeadlineServiceImpl;
import service.impl.NewsTypeServiceImpl;
import util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门户 控制器
 * 那些不需要登录,不需要做增删改的门户页的请求都放在这里
 * */
@WebServlet("/portal/*")
public class PortalController extends BaseController{
    private final NewsTypeService typeService = new NewsTypeServiceImpl();
    private final NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();


    /**
     * 查询头条详情的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 分页查询头条信息的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 查询所有头条类型的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询所有的新闻类型,装入Result响应给客户端
        List<NewsType> newsTypeList= typeService.findAll();
        WebUtil.writeJson(resp,Result.ok(newsTypeList));
    }
}
