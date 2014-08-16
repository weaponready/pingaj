package org.pingaj.app.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.pingaj.app.dao.ArticleDAO;
import org.pingaj.app.dao.ItemDAO;
import org.pingaj.app.entity.Article;
import org.pingaj.app.util.Collections3;
import org.pingaj.app.util.persistent.Page;
import org.pingaj.app.vo.request.PaginationRequest;
import org.pingaj.app.vo.response.Pagination;
import org.pingaj.app.vo.response.WorkDetail;
import org.pingaj.app.vo.response.WorkTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-15 上午4:55
 * Summary:
 */
@Service
public class WorksService extends BaseService {

    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private ItemDAO itemDAO;

    public Pagination getByType(String type, PaginationRequest pagination) {
        String path = "";
        if (StringUtils.equals("instrument", type)) {
            path = config.getInstrumentWorkPath();
        } else if (StringUtils.equals("children", type)) {
            path = config.getChildrenWorkPath();
        } else if (StringUtils.equals("classic", type)) {
            path = config.getClassicWorkPath();
        } else if (StringUtils.equals("latest", type)) {
            path = config.getLatestWorkPath();
        }
        Page page = itemDAO.search(path, pagination);
        if (Collections3.isNotEmpty(page.getItems())) {
            List rs = Lists.newArrayList();
            for (Object o : page.getItems()) {
                WorkTitle workTitle = dozer.map(o, WorkTitle.class);
                List children = articleDAO.getByParent(workTitle.getPosition());
                if (Collections3.isNotEmpty(children)) {
                    List titles = Lists.newArrayList();
                    for (Object child : children) {
                        titles.add(dozer.map(child, WorkTitle.class));
                    }
                    workTitle.setChildren(titles);
                }
                rs.add(workTitle);
            }
            return new Pagination(rs, pagination.getPage(), pagination.getSize(), page.getTotal());
        }
        return new Pagination();
    }

    public WorkDetail getDetail(Integer id) {
        Article article = articleDAO.get(id);
        if (article != null) {
            WorkDetail detail = dozer.map(article, WorkDetail.class);
            detail.setContent(StringUtils.replaceEach(detail.getContent(), new String[]{"src=\"upfiles"}, new String[]{"src=\""+config.getHost()+"upfiles"}));
            return detail;
        }
        return null;
    }
}
