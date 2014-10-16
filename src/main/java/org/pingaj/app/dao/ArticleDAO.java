package org.pingaj.app.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.pingaj.app.entity.Article;
import org.pingaj.app.util.persistent.Page;
import org.pingaj.app.vo.request.PaginationRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jamy on 14-8-13.
 */
@Repository
public class ArticleDAO  extends BaseDAO<Article>{

    public Page getByPath(String newsPath, PaginationRequest pagination) {
        DetachedCriteria criteria = criteriaReady();
        criteria.add(Restrictions.eq("sortPath", newsPath));
        criteria.add(Restrictions.ne("isDelete", 1));
        criteria.addOrder(Order.desc("addTime"));
        return find(criteria,pagination.getSize(), pagination.getPage());
    }

    public List getByParent(String path) {
        DetachedCriteria criteria = criteriaReady();
        criteria.add(Restrictions.ne("isDelete", 1));
        criteria.add(Restrictions.like("sortPath", path, MatchMode.START));
        criteria.addOrder(Order.desc("addTime"));
        return find(criteria);
    }


    public List getByPath(String path) {
        DetachedCriteria criteria = criteriaReady();
        criteria.add(Restrictions.eq("sortPath", path));
        criteria.add(Restrictions.ne("isDelete", 1));
        criteria.addOrder(Order.desc("addTime"));
        return find(criteria);
    }

    public List getByClassId(Integer id) {
        DetachedCriteria criteria = criteriaReady();
        criteria.add(Restrictions.eq("classId", id));
        criteria.add(Restrictions.ne("isDelete", 1));
        return find(criteria);
    }
}
