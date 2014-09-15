package org.pingaj.app.dao;

import org.pingaj.app.entity.Guest;
import org.springframework.stereotype.Repository;

/**
 * Created by Jamy on 14-8-14.
 */
@Repository
public class GuestDAO extends BaseDAO<Guest> {

    public void persistent(Guest guest){
        String sql = " insert" +
                " into Ok3w_Guest" +
                " (Ad_Ask, AddTime, Content, Homepage, Ip, IsPass, IsTop, Mail, pID, QQ, ReTime, ReUser, TableID, Title, TypeID, UserName)" +
                " values" +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] params = new Object[]{guest.getAdAsk(),guest.getAddTime(),guest.getContent(),guest.getHomepage(),guest.getIp(),guest.getIsPass(),guest.getIsTop(),
        guest.getMail(),guest.getpId(),guest.getQq(),guest.getReTime(),guest.getReUser(),guest.getTableId(),guest.getTitle(),guest.getTypeId(),guest.getUserName()};
        getJdbcTemplate().update(sql, params);
    }

}
