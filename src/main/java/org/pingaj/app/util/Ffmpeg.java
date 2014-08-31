package org.pingaj.app.util;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Jamy on 14-8-30.
 */
public class Ffmpeg {
    private static final Logger LOG = LoggerFactory.getLogger(Ffmpeg.class);

    public static void flv2Mp4(String ffmpegPath, String remoteUrl, String mp4Dir){
        try {
            List<String> command = Lists.newArrayList();
            command.add(ffmpegPath);
            command.add("-i");
            command.add(UriUtils.encodePath(remoteUrl, "utf-8"));
            command.add("-ar");
            command.add("22050");
            command.add(mp4Dir + Files.getNameWithoutExtension(remoteUrl) + ".mp4");
            ProcessBuilder builder = new ProcessBuilder();
            Process process = builder.command(command).start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream(),"utf-8"));
            String line;
            while((line = br.readLine())!=null){
                LOG.debug(line);
            }
            if(br!=null){
                br.close();
            }
            process.destroy();
        } catch (UnsupportedEncodingException e) {
            LOG.error(e.getMessage());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}
