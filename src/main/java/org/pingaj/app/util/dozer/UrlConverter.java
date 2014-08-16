package org.pingaj.app.util.dozer;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Jamy on 14-8-16.
 */
public class UrlConverter extends DozerConverter<String, String> {

    public UrlConverter() {
        super(String.class, String.class);
    }

    @Override
    public String convertTo(String source, String destination) {
        if(StringUtils.isEmpty(source)) return source;
        try {
            return URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return source;
    }

    @Override
    public String convertFrom(String source, String destination) {
        return source;
    }
}
