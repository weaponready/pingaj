package org.pingaj.app.web;

import com.google.common.io.Files;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.pingaj.app.config.Config;
import org.pingaj.app.util.Ffmpeg;
import org.pingaj.app.util.Servlets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Jamy on 14-8-29.
 */
@Controller
@RequestMapping("file")
public class DownloadController {
    private static final Logger LOG = LoggerFactory.getLogger(DownloadController.class);

    @Autowired
    private Config config;


    @RequestMapping("play")
    public String play(@RequestParam(value = "url", required = false) String url, Model model){
        if(StringUtils.isNotEmpty(url)){
            try {
                url = UriUtils.encodePath(url, "utf-8");
            } catch (UnsupportedEncodingException e) {
                LOG.error(e.getMessage());
            }
        }
        model.addAttribute("url", url);
        return "play";
    }


    @RequestMapping("/d")
    public void download(@RequestParam("f") String url, HttpServletResponse response, @RequestHeader(value = "Range", required = false) String range) {
        url = StringUtils.replace(url, ".mp4", ".flv");
        LOG.debug("url:{}", url);
        String filename = Files.getNameWithoutExtension(url) + ".mp4";
        LOG.debug("file:{}", filename);
        File file = new File(config.getMp4Dir() + filename);
        if (file.exists() && file.canRead()) {
            copy(file, response, range);
        } else {
            Ffmpeg.flv2Mp4(config.getFfmpegPath(), url, config.getMp4Dir());
            copy(file, response, range);
        }
    }

    private void copy(File file, HttpServletResponse response, String range) {
        if (file.exists() && file.canRead()) {
            response.setHeader(HttpHeaders.ACCEPT_RANGES, "bytes");
            long position = 0;
            long tail = file.length() - 1;
            long length = file.length();

            if (StringUtils.isNotEmpty(range)) {
                response.setStatus(HttpStatus.PARTIAL_CONTENT.value());
                range = StringUtils.replace(range, "bytes=", "");
                String[] positions = StringUtils.split(range, "-");
                position = Long.parseLong(positions[0]);
                if (positions.length > 1) {
                    long position2 = Long.parseLong(positions[1]);
                    tail = position2 >= length ? tail : position2;
                }

            }
            long total = tail - position + 1;
            StringBuilder contentRange = new StringBuilder();
            contentRange.append("bytes ").append(position).append("-").append(tail).append("/").append(length);
            LOG.debug("Content-range:{}", contentRange.toString());
            response.setHeader(HttpHeaders.CONTENT_RANGE, contentRange.toString());
            response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.OCTET_STREAM.toString());
            Servlets.setFileDownloadHeader(response, file.getName());
            response.setHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(total));
            try {
                byte[] buffer = new byte[2048];
                IOUtils.copyLarge(new FileInputStream(file), response.getOutputStream(), position, total, buffer);
            } catch (IOException e) {
                LOG.error(e.getMessage());
                e.printStackTrace();
            }
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
    }

}
