package org.pingaj.app.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.pingaj.app.dao.ArticleDAO;
import org.pingaj.app.util.Collections3;
import org.pingaj.app.vo.response.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jamy on 14-8-17.
 */
@Service
public class AlbumService extends BaseService {

    @Autowired
    private ArticleDAO articleDAO;

    public List<Photo> fetchPictures(String type) {
        String path = "";
        if (StringUtils.equals("glory", type)) {
            path = config.getGloriesPath();
        } else if (StringUtils.equals("exchange", type)) {
            path = config.getExchangeAlbumPath();
        } else if (StringUtils.equals("story", type)) {
            path = config.getStoryAlbumPath();
        }
        if (StringUtils.isNotEmpty(path)) {
            return fetch(path);
        }
        return null;
    }


    private List<Photo> fetch(String path) {
        List glories = articleDAO.getByParent(path);
        if (Collections3.isNotEmpty(glories)) {
            List<Photo> photos = Lists.newArrayList();
            for (Object glory : glories) {
                Photo photo = dozer.map(glory, Photo.class);
                photo.setUrl(config.getHost() + photo.getUrl());
                photo.setDescription(StringUtils.replaceEach(photo.getDescription(), new String[]{"src=\"upfiles"}, new String[]{"src=\"" + config.getHost() + "upfiles"}));
                photos.add(photo);
            }
            return photos;
        }
        return null;
    }


}
