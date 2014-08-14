package org.pingaj.app.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.pingaj.app.dao.ArticleDAO;
import org.pingaj.app.util.Collections3;
import org.pingaj.app.util.persistent.Page;
import org.pingaj.app.vo.request.PaginationRequest;
import org.pingaj.app.vo.response.Pagination;
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

    public Pagination getByType(String type, PaginationRequest pagination){
        String path = "";
        if(StringUtils.equals("instrument", type)){
            path = config.getInstrumentWorkPath();
        }else if(StringUtils.equals("children", type)){
            path = config.getChildrenWorkPath();
        }else if(StringUtils.equals("classic", type)){
            path = config.getClassicWorkPath();
        }else if(StringUtils.equals("latest", type)){
            path = config.getLatestWorkPath();
        }
        Page page = articleDAO.getByPath(path, pagination);
        if(Collections3.isNotEmpty(page.getItems())){
            List rs = Lists.newArrayList();
            for(Object o: page.getItems()){

                //dozer.map(o, );

            }
        }
        return new Pagination();
    }

}
