package org.pingaj.app.web;

import org.pingaj.app.config.Config;
import org.pingaj.app.service.NewsService;
import org.pingaj.app.vo.response.NewsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jamy on 14-8-17.
 */
@Controller
@RequestMapping("profile")
public class ProfileController extends BaseController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private Config config;

    @ResponseBody
    @RequestMapping
    public NewsDetail aboutMe(){
        return newsService.getDetail(Integer.parseInt(config.getProfileId()));
    }

    @RequestMapping("/page")
    public String aboutPinganjun(Model model){
        NewsDetail detail = newsService.getDetail(Integer.parseInt(config.getProfileId()));
        model.addAttribute("profile", detail);
        return "about";
    }
}
