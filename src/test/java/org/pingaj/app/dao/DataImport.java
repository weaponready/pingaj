package org.pingaj.app.dao;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.junit.Test;
import org.pingaj.app.entity.Article;
import org.pingaj.app.entity.Guest;
import org.pingaj.app.entity.Item;
import org.pingaj.app.util.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.io.File;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Creator: JimmyLin
 * DateTime: 14-8-18 上午9:27
 * Summary:
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DataImport extends AbstractTransactionalJUnit4SpringContextTests {
    private static String path_article = "E://work/Ok3w_Article.xml";
    private static Charset charset = Charset.forName("utf-8");
    //"ID"|"ChannelID"|"ClassID"|"SortPath"|"Title"|"TitleColor"|"TitleURL"|"Keywords"|"Description"|"Content"|"Author"|"ComeFrom"|"AddTime"|"Inputer"|"IsPic"|"PicFile"|"IsPass"|"IsTop"|"IsDelete"|"IsCommend"|"IsMove"|"IsPlay"|"IsIndexImg"|"IsUserAdd"|"GiveJifen"|"vUserGroupID"|"vUserMore"|"vUserJifen"|"pMoodStr"|"Hits"
    private static final String seporator = "|";

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private GuestDAO guestDAO;

    @Test
    @Rollback(false)
    public void importArticle() {

        File articleData = new File(path_article);
        Document doc = XmlUtils.getDoc(articleData);
        List<Element> children = doc.getRootElement().getChildren();
        List<List<Element>> partition = Lists.partition(children, 10);
        for (List<Element> part : partition) {
            for (Element e : part) {

                Article article = new Article();
                article.setId(parseInt(e.getChild("ID").getText()));
                article.setChannelId(parseInt(e.getChild("ChannelID").getText()));
                article.setClassId(parseInt(e.getChild("ClassID").getText()));
                article.setSortPath(e.getChild("SortPath").getText());
                article.setTitle(e.getChildText("Title"));
                article.setTitleColor(e.getChildText("TitleColor"));
                article.setTitleUrl(e.getChildText("TitleURL"));
                article.setKeywords(e.getChildText("Keywords"));
                article.setDescription(e.getChildText("Description"));
                article.setContent(e.getChildText("Content"));
                article.setAuthor(e.getChildText("Author"));
                article.setComeFrom(e.getChildText("ComeFrom"));
                try {
                    article.setAddTime(sdf.parse(StringUtils.replace(e.getChildText("AddTime"), "T", " ")));
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                article.setInputer(e.getChildText("Inputer"));
                article.setIsPic(parseInt(e.getChildText("IsPic")));
                article.setPicFile(e.getChildText("PicFile"));
                article.setIsPass(parseInt(e.getChildText("IsPass")));
                article.setIsTop(parseInt(e.getChildText("IsTop")));
                article.setIsDelete(parseInt(e.getChildText("IsDelete")));
                article.setIsCommend(parseInt(e.getChildText("isCommnd")));
                article.setIsMove(parseInt(e.getChildText("IsMove")));
                article.setIsPlay(parseInt(e.getChildText("IsPlay")));
                article.setIsIndexImg(parseInt(e.getChildText("IsIndexImg")));
                article.setIsUserAdd(parseInt(e.getChildText("IsUserAdd")));
                article.setGiveJifen(parseInt(e.getChildText("GiveJifen")));
                article.setvUserGroupId(parseInt(e.getChildText("vUserGroupId")));
                article.setvUserMore(parseInt(e.getChildText("vUserMore")));
                article.setvUserJifen(parseInt(e.getChildText("vUserJifen")));
                article.setpMoodStr(e.getChildText("pMoodStr"));
                article.setHits(parseInt(e.getChildText("Hits")));
                articleDAO.save(article);
            }
        }
    }

    @Test
    @Rollback(false)
    public void importClass() {
        File articleData = new File("E://work/Ok3w_Class.xml");
        Document doc = XmlUtils.getDoc(articleData);
        List<Element> children = doc.getRootElement().getChildren();
        List<List<Element>> partition = Lists.partition(children, 10);
        for (List<Element> part : partition) {
            for (Element e : part) {
                Item item = new Item();
                item.setId(parseInt(e.getChildText("ID")));
                item.setSortName(e.getChildText("SortName"));
                item.setChannelId(parseInt(e.getChildText("ChannelID")));
                item.setParentId(parseInt(e.getChildText("ParentID")));
                item.setSortPath(e.getChildText("SortPath"));
                item.setOrderId(parseInt(e.getChildText("OrderID")));
                item.setIsPic(parseInt(e.getChildText("IsPic")));
                item.setPageSize(parseInt(e.getChildText("PageSize")));
                item.setIsNav(parseInt(e.getChildText("IsNav")));
                item.setGotoUrl(e.getChildText("gotoURL"));
                item.setPicUrl(e.getChildText("picURL"));
                itemDAO.save(item);
            }
        }
    }


    @Test
    @Rollback(false)
    public void importMessage() {
        File articleData = new File("E://work/Ok3w_Guest.xml");
        Document doc = XmlUtils.getDoc(articleData);
        List<Element> children = doc.getRootElement().getChildren();
        List<List<Element>> partition = Lists.partition(children, 10);
        for (List<Element> part : partition) {
            for (Element e : part) {
                Guest guest = new Guest();
                guest.setId(parseInt(e.getChildText("ID")));
                guest.setpId(parseInt(e.getChildText("pID")));
                guest.setTitle(e.getChildText("Title"));
                guest.setUserName(e.getChildText("UserName"));
                guest.setMail(e.getChildText("Mail"));
                guest.setHomepage(e.getChildText("Homepage"));
                guest.setContent(e.getChildText("Content"));
                guest.setQq(e.getChildText("QQ"));
                guest.setTypeId(parseInt(e.getChildText("TypeID")));
                guest.setTableId(parseInt(e.getChildText("TableID")));
                guest.setAddTime(parseDate(e.getChildText("AddTime")));
                guest.setIp(e.getChildText("Ip"));
                guest.setIsPass(parseInt(e.getChildText("IsPass")));
                guest.setIsTop(parseInt(e.getChildText("IsTop")));
                guest.setReTime(parseDate(e.getChildText("ReTime")));
                guest.setReUser(e.getChildText("ReUser"));
                guestDAO.save(guest);
            }
        }
    }

    private Integer parseInt(String text) {
        if (StringUtils.isNumeric(text)) {
            return Integer.parseInt(text);
        }
        return null;
    }

    private Date parseDate(String text) {
        if (StringUtils.isNotEmpty(text)) {
            try {
                sdf.parse(StringUtils.replace(text, "T", " "));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
