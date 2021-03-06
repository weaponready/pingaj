package org.pingaj.app.dao;

import com.google.common.collect.Lists;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;
import org.pingaj.app.util.Reflections;
import org.pingaj.app.util.persistent.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-13 下午2:56
 * Summary:
 */
public class BaseDAO<T> {

    private Class<T> entityClass;

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BaseDAO() {
        Type genType = getClass().getGenericSuperclass();
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            entityClass = (Class) params[0];
        }
    }


    protected DetachedCriteria criteriaReady() {
        return DetachedCriteria.forClass(entityClass);
    }

    public void save(T entity) {
        hibernateTemplate.save(entity);
    }

    public T get(Serializable id) {
        return getHibernateTemplate().get(entityClass, id);
    }

    public List<T> loadAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }

    public List find(DetachedCriteria criteria) {
        return getHibernateTemplate().findByCriteria(criteria);
    }

    public T findOne(DetachedCriteria criteria) {
        List rt = find(criteria);
        if (rt != null && rt.size() > 0) {
            return (T) rt.get(0);
        }
        return null;
    }

    public Page find(DetachedCriteria criteria, int size, int page) {
        criteria.setProjection(Projections.rowCount());
        List<CriteriaImpl.OrderEntry> orderEntries = removeOrders(criteria);
        int total = ((Long) this.hibernateTemplate.findByCriteria(criteria).get(0)).intValue();
        criteria.setProjection(null);
        int startIndex = getStartIndex(total, size, page);
        addOrders(criteria, orderEntries);
        List items = this.hibernateTemplate.findByCriteria(criteria, startIndex, size);
        return new Page(total, items);
    }

    private List<CriteriaImpl.OrderEntry> removeOrders(DetachedCriteria criteria) {
        CriteriaImpl criteriaImpl = (CriteriaImpl) Reflections.getFieldValue(criteria, "impl");
        List<CriteriaImpl.OrderEntry> orderEntries = (List<CriteriaImpl.OrderEntry>) Reflections.getFieldValue(criteriaImpl, "orderEntries");
        Reflections.setFieldValue(criteriaImpl, "orderEntries", Lists.newArrayList());
        return orderEntries;
    }

    private void addOrders(DetachedCriteria criteria, List<CriteriaImpl.OrderEntry> orderEntries) {
        CriteriaImpl criteriaImpl = (CriteriaImpl) Reflections.getFieldValue(criteria, "impl");
        Reflections.setFieldValue(criteriaImpl, "orderEntries", orderEntries);
    }

    private int getStartIndex(int total, int size, int page) {
        if (total <= 0) return 0;
        int maxIndex = total % size == 0 ? total / size : total / size + 1;
        if (page >= maxIndex) {
            return (maxIndex - 1) * size;
        }
        return (page - 1) * size;
    }


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
