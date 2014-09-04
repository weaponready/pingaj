package org.pingaj.app.dao;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.junit.Test;
import org.springframework.web.util.UriUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Jamy on 14-8-30.
 */
public class CmdTest {

    @Test
    public void ffmpeg() {
        String remoteFlv = "http://www.dadegroup.com/pinganjun/少儿作品/1s童心是小鸟.flv";
        try {
            String cmd = "E:\\work\\ffmpeg\\bin\\ffmpeg -i http://www.dadegroup.com/pinganjun/%E5%B0%91%E5%84%BF%E4%BD%9C%E5%93%81/1s%E7%AB%A5%E5%BF%83%E6%98%AF%E5%B0%8F%E9%B8%9F.flv -ar 22050 E://work/12345677.mp4";
            String url = URLEncoder.encode(remoteFlv, "utf-8");
            List<String> command = Lists.newArrayList();
            command.add("E:\\work\\ffmpeg\\bin\\ffmpeg");
            command.add("-i");
            command.add(URLEncoder.encode(remoteFlv,"utf-8"));
            command.add("-ar");
            command.add("22050");
            command.add("E://work/" + Files.getNameWithoutExtension(remoteFlv) + ".mp4");
            //command.add("ipconfig");
            //command.add(cmd);
           // command.add("ipconfig");
            ProcessBuilder builder = new ProcessBuilder();
            Process process = builder.command(command).start();
            //Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream(),"gbk"));
            String line = null;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
            if(br!=null){
                br.close();
            }

            process.destroy();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test_url_encode() throws MalformedURLException, UnsupportedEncodingException {
        String raw = "http://www.dadegroup.com/pinganjun/少儿作品/1s童心是小鸟.flv";
        System.out.println(new String(raw.getBytes(),"utf-8"));
        System.out.println(URLEncoder.encode(raw,"utf-8"));
        URL url = new URL(raw);
        String s1 = UriUtils.encodePath(raw, "utf-8");
        String s = UriUtils.encodePath(url.getPath(), "utf-8");
        StringBuilder sb = new StringBuilder();
        System.out.println(url.getHost());
        sb.append(url.getProtocol()).append("://").append(url.getHost()).append(URLEncoder.encode(url.getPath(), "utf-8"));
        System.out.println(sb.toString());

    }
}
