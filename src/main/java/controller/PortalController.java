package controller;

import common.Result;
import pojo.NewsHeadline;
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
 * Portal Controller
 * Request for portal pages that do not require login and do not need to be added, deleted or modified
 * */
@WebServlet("/portal/*")
public class PortalController extends BaseController{
    private final NewsTypeService typeService = new NewsTypeServiceImpl();
    private final NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();


    /**
     * The interface implementation for querying the details of Headlines
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

    }

    /**
     * The interface implementation for pagination query of headline information
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);
        Map<String, Object> pageInfo = headlineService.findPage(headlineQueryVo);
        Map<String, Object> pageInfoMap = new HashMap<>();
        pageInfoMap.put("pageInfo", pageInfo);
        WebUtil.writeJson(resp, Result.ok(pageInfoMap));
    }

    /**
     * The business interface implementations for querying all headline types
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException ServletException
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        List<NewsType> newsTypeList = typeService.findAll();
        WebUtil.writeJson(resp, Result.ok(newsTypeList));
    }
}
