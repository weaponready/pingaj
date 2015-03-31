package org.pingaj.app.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.pingaj.app.dao.ArticleDAO;
import org.pingaj.app.dao.ItemDAO;
import org.pingaj.app.entity.Article;
import org.pingaj.app.exception.NotFoundException;
import org.pingaj.app.util.Collections3;
import org.pingaj.app.util.persistent.Page;
import org.pingaj.app.vo.request.PaginationRequest;
import org.pingaj.app.vo.response.*;
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
        throw new NotFoundException(pagination.getPosition());
    }

    public SoundDetail getSound(Integer id) {
        Article article = articleDAO.get(id);
        if (article == null) throw new NotFoundException("article:" + id);
        SoundDetail title = dozer.map(article, SoundDetail.class);
        title.setContent(StringUtils.replaceEach(title.getContent(), new String[]{"src=\"upfiles"}, new String[]{"src=\"" + config.getHost() + "upfiles"}));
        return title;
    }


    public List<SunshineDetail> getSunshine(Integer id) {
        List<Article> articles = articleDAO.getByClassId(id);
        List<SunshineDetail> details  = Lists.newArrayList();

        if (Collections3.isNotEmpty(articles)) {
            for (Article article : articles) {

                SunshineDetail detail = dozer.map(article, SunshineDetail.class);
                if (detail == null) throw new NotFoundException("sunshine:" + id);
                if(StringUtils.isNotEmpty(article.getTitleUrl())){
                    detail.setUrl(article.getTitleUrl());
                }else if(StringUtils.isNotEmpty(article.getPicFile())){
                    detail.setUrl(config.getHost() + detail.getUrl());
                }
                detail.setContent(StringUtils.replaceEach(detail.getContent(), new String[]{"src=\"upfiles"}, new String[]{"src=\"" + config.getHost() + "upfiles"}));
                details.add(detail);
            }
        }
        return details;
    }


    public Pagination getSunshineList(PaginationRequest pagination) {
        Page page = itemDAO.getByParent(config.getSunshine(), pagination);
        if (Collections3.isNotEmpty(page.getItems())) {
            List<Sunshine> titles = Lists.newArrayList();
            for (Object o : page.getItems()) {
                Sunshine parentTitle = dozer.map(o, Sunshine.class);
                List children = itemDAO.getByParent(parentTitle.getPosition());

                if (Collections3.isNotEmpty(children)) {
                    List<Sunshine> subTitles = Lists.newArrayList();
                    for (Object i : children) {
                        Sunshine child = dozer.map(i, Sunshine.class);
                        subTitles.add(child);
                    }
                    parentTitle.setChildren(subTitles);
                }
                titles.add(parentTitle);
            }
            return new Pagination(titles, pagination.getPage(), pagination.getSize(), page.getTotal());
        }
        throw new NotFoundException(pagination.getPosition());
    }
}
