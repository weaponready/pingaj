package org.pingaj.app.web;

import org.pingaj.app.service.GuestService;
import org.pingaj.app.util.net.IpUtils;
import org.pingaj.app.vo.request.GuestRequest;
import org.pingaj.app.vo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-13 下午2:45
 * Summary:
 */
@Controller
@RequestMapping("guest")
public class GuestController extends BaseController {

    @Autowired
    private GuestService guestService;

    @ResponseBody
    @RequestMapping("test")
    public String test(String a) {
        return "{\"a\":" + a + "}";
    }

    @ResponseBody
    @RequestMapping(value = "message", method = RequestMethod.POST)
    public Response leaveMessage(HttpServletRequest request, GuestRequest message){
        message.setIp(IpUtils.getIpAddr(request));
        guestService.leaveMessage(message);
        return new Response().success();
    }

}
