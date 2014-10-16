package org.pingaj.app.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.pingaj.app.dao.ArticleDAO;
import org.pingaj.app.entity.Article;
import org.pingaj.app.exception.NotFoundException;
import org.pingaj.app.util.Collections3;
import org.pingaj.app.util.persistent.Page;
import org.pingaj.app.vo.request.PaginationRequest;
import org.pingaj.app.vo.response.NewsDetail;
import org.pingaj.app.vo.response.NewsTitle;
import org.pingaj.app.vo.response.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午9:31
 * Summary:
 */
@Service
public class NewsService extends BaseService {

    @Autowired
    private ArticleDAO articleDAO;


    public Pagination getByType(String type, PaginationRequest pagination) {
        String path = "";
        if (StringUtils.equals(type, "activity")) {
            path = config.getActivityNewsPath();
        } else if (StringUtils.equals(type, "report")) {
            path = config.getReportNewsPath();
        }
        if (StringUtils.isNotEmpty(path)) {
            Page page = articleDAO.getByPath(path, pagination);
            if (Collections3.isNotEmpty(page.getItems())) {
                List<NewsTitle> titles = Lists.newArrayList();
                for (Object o : page.getItems()) {
                    NewsTitle newsTitle = dozer.map(o, NewsTitle.class);
                    titles.add(newsTitle);
                }
                return new Pagination(titles, pagination.getPage(), pagination.getSize(), page.getTotal());
            }

        }
        return new Pagination();
    }

    public NewsDetail getDetail(Integer id) {
        Article article = articleDAO.get(id);
        if (article == null) throw new NotFoundException("news:" + id);
        NewsDetail detail = dozer.map(article, NewsDetail.class);
        detail.setContent(StringUtils.replaceEach(detail.getContent(), new String[]{"src=\"upfiles"}, new String[]{"src=\"" + config.getHost() + "upfiles"}));
        return detail;
    }
}
