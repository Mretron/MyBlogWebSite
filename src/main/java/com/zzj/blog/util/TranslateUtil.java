package com.zzj.blog.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TranslateUtil {

    public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0";

    private static String preUrl = "http://www.baidu.com/s?wd=";

    public static String translate(String word){

        //拼接URL
        String newUrl = preUrl+word;
        //获取源代码
        String code = getContent(newUrl,"utf-8");
        //System.out.println(code);
        //页面一定是一个document对象
        //创建Document对象
        Document document =Jsoup.parse(code);
      //相应的内容标签
        Elements elements =  document.select("span[class = op_dict_text2]");

        //定义翻译结果
        StringBuffer content = new StringBuffer();
        for(int i=0,len =elements.size();i<len;i++){
            content.append(elements.get(i).html());
        }
        return  content.toString();


    }

    /**
     * 获取相应的源代码
     * @param newUrl
     * @return
     */
    public static String getContent(String newUrl,String charsetName) {

        try {
            Connection con = Jsoup.connect(newUrl);
            con.header(USER_AGENT, USER_AGENT_VALUE); //配置浏览器
            Connection.Response rs = con.execute(); //获取响应
            rs.charset(charsetName);
            return rs.body();
        }catch (IOException e){
            e.printStackTrace();
        }
            return "";
        }
}
