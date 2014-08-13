package org.pingaj.app.service;

import org.dozer.Mapper;
import org.pingaj.app.dao.GuestDAO;
import org.pingaj.app.entity.Guest;
import org.pingaj.app.vo.request.GuestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Jamy on 14-8-14.
 */
@Service
@Transactional
public class GuestService {

    @Autowired
    private GuestDAO guestDAO;
    @Autowired
    private Mapper dozer;

    public void leaveMessage(GuestRequest message){
        Guest guest = dozer.map(message, Guest.class);
        guest.setAddTime(new Date());
        guest.setReUser(guest.getUserName());
        guest.setIsPass(0);
        guest.setTableId(0);
        guest.setTypeId(100);
        guestDAO.save(guest);
    }
}
