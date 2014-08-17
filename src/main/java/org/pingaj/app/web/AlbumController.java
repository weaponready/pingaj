package org.pingaj.app.web;

import org.pingaj.app.service.AlbumService;
import org.pingaj.app.vo.response.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午1:00
 * Summary:
 */
@Controller
@RequestMapping("album")
public class AlbumController extends BaseController {

    @Autowired
    private AlbumService albumService;

    @ResponseBody
    @RequestMapping(value = "/{type}")
    public List<Photo> fetch(@PathVariable("type") String type){
        return albumService.fetchPictures(type);
    }


}
