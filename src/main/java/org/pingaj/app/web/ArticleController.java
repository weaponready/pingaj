package org.pingaj.app.web;

import org.pingaj.app.service.WorksService;
import org.pingaj.app.vo.request.PaginationRequest;
import org.pingaj.app.vo.response.Pagination;
import org.pingaj.app.vo.response.WorkDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午12:59
 * Summary:
 */
@Controller
@RequestMapping("work")
public class ArticleController extends BaseController {

    @Autowired
    private WorksService worksService;

    @ResponseBody
    @RequestMapping(value = "title/{type}")
    public Pagination title(@PathVariable("type") String type, PaginationRequest page, HttpServletRequest request){
        Pagination pagination = worksService.getByType(type,page);
        return pagination;
    }

    @RequestMapping(value = "detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        WorkDetail detail = worksService.getDetail(id);
        model.addAttribute("work", detail);
        return "work";
    }

}
