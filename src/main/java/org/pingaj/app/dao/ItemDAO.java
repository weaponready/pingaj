package org.pingaj.app.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.pingaj.app.entity.Item;
import org.pingaj.app.util.persistent.Page;
import org.pingaj.app.vo.request.PaginationRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jamy on 14-8-14.
 */
@Repository
public class ItemDAO extends BaseDAO<Item> {

    public Page search(String path, PaginationRequest pageRequest) {
        DetachedCriteria criteria = criteriaReady();
        criteria.add(Restrictions.like("sortPath", path, MatchMode.START));
        criteria.add(Restrictions.ne("sortPath", path));
        return find(criteria,pageRequest.getSize(), pageRequest.getPage());
    }

    public List getByParent(String path){
        DetachedCriteria criteria = criteriaReady();
        criteria.add(Restrictions.like("sortPath", path, MatchMode.START));
        criteria.add(Restrictions.ne("sortPath", path));
        return find(criteria);
    }
}
