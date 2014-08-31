package org.pingaj.app.web;

import com.google.common.io.Files;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import org.pingaj.app.config.Config;
import org.pingaj.app.util.Ffmpeg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Jamy on 14-8-29.
 */
@Controller
@RequestMapping("file")
public class DownloadController {
    private static final Logger LOG = LoggerFactory.getLogger(DownloadController.class);

    @Autowired
    private Config config;

    @RequestMapping("/d")
    public void download(@RequestParam("f") String url, HttpServletResponse response) {
        LOG.debug("url:{}", url);
        String filename = Files.getNameWithoutExtension(url) + ".mp4";
        LOG.debug("file:{}", filename);
        File file = new File(config.getMp4Dir() + filename);
        if (file.exists() && file.canRead()) {
            copy(file, response);
        } else {
            Ffmpeg.flv2Mp4(config.getFfmpegPath(), url, config.getMp4Dir());
            copy(file, response);
        }
    }

    private void copy(File file, HttpServletResponse response) {
        if (file.exists() && file.canRead()) {
            try {
                response.setContentType(MediaType.MP4_VIDEO.type());
                String filename = URLEncoder.encode(file.getName(), "utf-8");
                response.setHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()));
                response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                FileCopyUtils.copy(bufferedInputStream, response.getOutputStream());
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }
}
