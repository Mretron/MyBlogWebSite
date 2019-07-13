package com.zzj.blog.util;

import com.zzj.blog.pojo.IPAddress;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


public class LogIP {

    private static String preUrl = "http://www.ip138.com/ips1388.asp?ip=";

    private static String endUrl = "&action=2";

    public static IPAddress logIPtoDatabase(String IP){

        String newUrl = preUrl + IP + endUrl;
        //获取源代码
        String code = TranslateUtil.getContent(newUrl,"gb2312");
        //创建Document对象
        Document document = Jsoup.parse(code);
        //获取相应的内容标签
        Elements elements = document.select("li");
        String address = elements.get(0).html().substring(5);

        return new IPAddress(IP,address,1,new Date());

    }
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }

    public static int viewsCount(List<IPAddress> ipAddresses){
        int sum = 0;
        for(IPAddress ipAddress : ipAddresses){
            sum += ipAddress.getViews();
        }
        return sum;
    }

}
