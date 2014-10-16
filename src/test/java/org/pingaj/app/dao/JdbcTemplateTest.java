package org.pingaj.app.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.pingaj.app.config.Config;
import org.pingaj.app.entity.Article;
import org.pingaj.app.entity.Guest;
import org.pingaj.app.util.persistent.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-13 下午3:31
 * Summary:
 */
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class JdbcTemplateTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private GuestDAO guestDAO;
    @Autowired
    private Config config;

    @Test
    public void testQuery() {
        String sql = "select * from Ok3w_Article";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.size());

    }

    @Test
    public void testHibernate() {
        List<Article> articles = articleDAO.loadAll();
        if (articles != null && articles.size() > 0) {
            System.out.println(articles.size());
        }

    }

    @Test
    public void testCriteria(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
        criteria.add(Restrictions.like("titleUrl",".mp3", MatchMode.END));
        List list = articleDAO.find(criteria);
        Page page = articleDAO.find(criteria, 10, 1);
        System.out.println(list.size());
    }

    @Test
    @Rollback(false)
    public void testSave(){
        Guest guest = new Guest();
        guest.setContent("asdfasdf");
        guest.setMail("315095859@qq.com");
        guest.setQq("315095859");
        guest.setIp("10.10.10.10");
        guest.setHomepage("http://www.github.com/weaponready");
        guest.setTitle("中文测试");
        guest.setAddTime(new Date());
        guestDAO.save(guest);
    }

    @Test
    public void testCount(){
        System.out.println(guestDAO.loadAll().size());
        System.out.println(guestDAO.loadAll().size());
        System.out.println(guestDAO.loadAll().size());
        System.out.println(guestDAO.loadAll().size());
        System.out.println(guestDAO.loadAll().size());
        System.out.println(guestDAO.loadAll().size());
        System.out.println(guestDAO.loadAll().size());
    }

    @Test
    public void testNavigation(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
        criteria.add(Restrictions.eq("sortPath", "0,33,78,"));
        List list = articleDAO.find(criteria);


    }

    @Test
    public void testPagination(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
        criteria.addOrder(Order.desc("addTime"));
        criteria.add(Restrictions.eq("sortPath", "0,8,"));
        criteria.add(Restrictions.ne("isDelete" ,1));
        List list = articleDAO.getByParent("0,8,");

        //Article article = articleDAO.get(Integer.parseInt("3449"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(Object a: list){
            Article article = (Article) a;
            //System.out.println(sdf.format(article.getAddTime())+" "+ article.getTitle());
            System.out.println(article.toString());
        }

    }

}
