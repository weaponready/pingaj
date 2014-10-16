package org.pingaj.app.web;

import org.pingaj.app.service.NewsService;
import org.pingaj.app.vo.request.PaginationRequest;
import org.pingaj.app.vo.response.NewsDetail;
import org.pingaj.app.vo.response.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午12:58
 * Summary:
 */
@Controller
@RequestMapping(value = "news")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    @ResponseBody
    @RequestMapping("title/{type}")
    public Pagination titles(@PathVariable(value = "type") String type, PaginationRequest pagination, HttpServletRequest request){
        Pagination response  =  newsService.getByType(type, pagination);
        return response;
    }

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        NewsDetail detail = newsService.getDetail(id);
        model.addAttribute("news", detail);
        return "news";
    }
}
