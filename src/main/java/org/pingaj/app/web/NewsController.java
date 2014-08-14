package org.pingaj.app.web;

import org.pingaj.app.vo.response.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午12:58
 * Summary:
 */
@Controller
@RequestMapping(value = "news")
public class NewsController extends BaseController {

    public Pagination titles(){
        return null;
    }
}
