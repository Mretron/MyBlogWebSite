package com.zzj.blog.util;

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

    private static String preUrl = "http://www.baidu.com/s?wd=";

    public static String translate(String word){

        //获取源代码
        String code = getContent(word);
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
     * @param word
     * @return
     */
    public static String getContent(String word){
        //拼接处网址
        String newUrl = preUrl + word;
        //将网址字符串 当成网址来处理
        StringBuffer content = new StringBuffer();
        try {
            //编译时异常
            URL url = new URL(newUrl);
            //建立连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //获取输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
            //获取信息

            //定义每次读取的信息
            String temp = null;
            while((temp = reader.readLine())!=null){
                content.append(temp + "\n");
            }



        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return content.toString();
    }
}
