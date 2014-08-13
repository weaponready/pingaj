package org.pingaj.app.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;
import java.util.Map;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-13 下午3:31
 * Summary:
 */
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class JdbcTemplateTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testQuery(){
        String sql = "select * from Ok3w_Article";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.size());

    }

}
