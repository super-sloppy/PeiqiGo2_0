package com.wk.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 聊天工具类
 * Created by 锴 on 2018/2/1.
 */
public class ChatUtil {
    /**
     *
     * @param msg 用户输入的消息
     * @return 机器人回复内容
     */
    public static String getResult(String msg){
        StringBuffer buffer = new StringBuffer();

        try {
            //设置 编码格式
            String question = URLEncoder.encode(msg,"utf-8");
            // APIKEY
            String APIKEY="bfede67d75904a839541c8b2a48c6dc5";
            //接口url
            String url="http://www.tuling123.com/openapi/api";
            //请求 url接口
            String requestUrl= url+"?key="+APIKEY+"&info="+question;
            // 建立链接
            URL urlObj = new  URL(requestUrl);
            //获取连接对象
            URLConnection connection = urlObj.openConnection();
            //获取结果
            InputStreamReader reader = new InputStreamReader(connection.getInputStream(),"utf-8");
            //建立文件缓冲流
            BufferedReader bufferedReader = new BufferedReader(reader);
            //建立临时文件
            String temp = null;
            while ((temp=bufferedReader.readLine())!=null){
                buffer.append(temp);
            }
            //关闭流
            reader.close();
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] arg){
        String message = "你好";
        //1.调用机器人接口
        String str = getResult(message);

        System.out.println(str);

        //2.建立文件缓冲流
    }
}
