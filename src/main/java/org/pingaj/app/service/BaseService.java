package org.pingaj.app.service;

import org.dozer.Mapper;
import org.pingaj.app.config.Config;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午9:40
 * Summary:
 */
public class BaseService {
    @Autowired
    protected Config config;
    @Autowired
    protected Mapper dozer;
}
