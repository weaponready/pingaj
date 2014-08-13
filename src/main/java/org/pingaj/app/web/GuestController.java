package org.pingaj.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-13 下午2:45
 * Summary:
 */
@Controller
@RequestMapping("guest")
public class GuestController extends BaseController {


    @ResponseBody
    @RequestMapping("test")
    public String test(String a) {
        return "{\"a\":" + a + "}";
    }

}
