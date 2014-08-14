package org.pingaj.app.util.dozer;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Creator: JimmyLin
 * DateTime: 14-4-18 下午12:02
 * Summary: timemillis <=> formatted string
 */
public class SimpleDateConverter extends DozerConverter<Date, String> {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleDateConverter.class);

    private SimpleDateFormat dateFormater;

    public SimpleDateConverter(String pattern) {
        super(Date.class, String.class);
        dateFormater = new SimpleDateFormat(pattern);
    }

    @Override
    public String convertTo(Date source, String destination) {
        if (source == null) return "";
        return dateFormater.format(source);
    }

    @Override
    public Date convertFrom(String source, Date destination) {
        if (StringUtils.isEmpty(source)) return null;
        try {
            return dateFormater.parse(source);
        } catch (ParseException e) {
            LOG.error(e.getMessage());
        }
        return null;
    }
}
