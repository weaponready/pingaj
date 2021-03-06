package org.pingaj.app.web;

import org.pingaj.app.service.LeftService;
import org.pingaj.app.vo.request.PaginationRequest;
import org.pingaj.app.vo.response.Pagination;
import org.pingaj.app.vo.response.SunshineDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Jamy on 14-8-17.
 */
@Controller
@RequestMapping("further")
public class MoreController extends BaseController {

    @Autowired
    private LeftService leftService;

    @ResponseBody
    @RequestMapping(value = "sound")
    public Pagination soundOfDade(PaginationRequest page, HttpServletRequest request) {
        Pagination pagination = leftService.getSoundTitle(page);
        return pagination;
    }

    @RequestMapping(value = "/sound/{id}")
    public String getSoundDetail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sound", leftService.getSound(id));
        return "sound";
    }

    @ResponseBody
    @RequestMapping(value = "/thesun")
    public Pagination getSunshineTitle(PaginationRequest page) {
        Pagination pagination = leftService.getSunshineList(page);
        return pagination;
    }

    @RequestMapping("/sunshine/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model) {
        List<SunshineDetail> detailList = leftService.getSunshine(id);
        model.addAttribute("list", new Pagination(detailList, 1, detailList.size(), detailList.size()));
        return "sunshine";
    }

}
