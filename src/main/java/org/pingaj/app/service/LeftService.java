package org.pingaj.app.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.pingaj.app.dao.ArticleDAO;
import org.pingaj.app.dao.ItemDAO;
import org.pingaj.app.entity.Article;
import org.pingaj.app.util.Collections3;
import org.pingaj.app.util.persistent.Page;
import org.pingaj.app.vo.response.*;
import org.pingaj.app.vo.request.PaginationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jamy on 14-8-17.
 */
@Service
public class LeftService extends BaseService {

    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private ItemDAO itemDAO;


    public Pagination getSoundTitle(PaginationRequest pagination) {
        Page page = itemDAO.getByParent(config.getSoundOfDadePath(), pagination);
        if (Collections3.isNotEmpty(page.getItems())) {
            List<SoundTitle> titles = Lists.newArrayList();
            for (Object o : page.getItems()) {
                SoundTitle parentTitle = dozer.map(o, SoundTitle.class);
                List children = articleDAO.getByParent(parentTitle.getPosition());

                if (Collections3.isNotEmpty(children)) {
                    List<SoundTitle> subTitles = Lists.newArrayList();
                    for (Object i : children) {
                        SoundTitle child = dozer.map(i, SoundTitle.class);
                        subTitles.add(child);
                    }
                    parentTitle.setChildren(subTitles);
                }
                parentTitle.setUrl(config.getHost() + parentTitle.getUrl());
                titles.add(parentTitle);
            }
            return new Pagination(titles, pagination.getPage(), pagination.getSize(), page.getTotal());
        }
        return null;
    }

    public SoundDetail getSound(Integer id) {
        Article article = articleDAO.get(id);
        SoundDetail title = dozer.map(article, SoundDetail.class);
        return title;
    }

    public List<Sunshine> getSunshineByType(String type) {
        String path = "";
        if (StringUtils.equals(type, "publish")) {
            path = config.getPublishOfSunshine();
        } else if (StringUtils.equals(type, "actor")) {
            path = config.getActorOfSunshine();
        } else if (StringUtils.equals(type, "band")) {
            path = config.getBandOfSunshine();
        } else if (StringUtils.equals(type, "chapter")) {
            path = config.getChapterOfSunshine();
        } else if (StringUtils.equals(type, "live")) {
            path = config.getLiveOfSunshine();
        }else if(StringUtils.equals(type,"report")){
            path = config.getReportOfSunshine();
        }
        List articles = articleDAO.getByPath(path);
        if (Collections3.isNotEmpty(articles)) {
            List<Sunshine> sunshines = Lists.newArrayList();
            for (Object o : articles) {
                Sunshine sunshine = dozer.map(o, Sunshine.class);
                sunshine.setUrl(config.getHost() + sunshine.getUrl());
                sunshines.add(sunshine);
            }
            return sunshines;
        }
        return null;
    }

    public SunshineDetail getSunshine(Integer id) {
        SunshineDetail detail = dozer.map(articleDAO.get(id), SunshineDetail.class);
        detail.setUrl(config.getHost() + detail.getUrl());
        detail.setContent(StringUtils.replaceEach(detail.getContent(), new String[]{"src=\"upfiles"}, new String[]{"src=\"" + config.getHost() + "upfiles"}));
        return detail;
    }
}
