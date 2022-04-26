package com.chengfei.base.enum_about.enum_singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @ClassName: ReadWriteMysql
 * @Author chengfei
 * @DateTime 2022/4/23 15:22
 * @TODO: 利用枚举类来实现单例
 **/
public class ReadWriteMysql {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://10.191.80.157:3306/advertising?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        ConnectMysql instance = ConnectMysql.INSTANCE;
        instance.setDataSource(url,"root","123456");
        Connection connection = instance.getConnection();
        Statement stmt = connection.createStatement();
        String sqlStr = "SELECT app_id, os_type, match_period, channel_id, app_package_name FROM ad_channel_match a " +
                "LEFT JOIN ad_channel b ON (a.channel_id = b.id)  ";
        ResultSet rs = stmt.executeQuery(sqlStr);

        while (rs.next()){
            String appId = rs.getString("app_id");
            int osType = rs.getInt("os_type");
            int matchPeriod = rs.getInt("match_period");
            int channelId = rs.getInt("channel_id");
            String appPackageName = rs.getString("app_package_name");
            System.out.println(String.format("appId:%s,osType:%s,matchPeriod:%s,channelId:%s,appPackageName:%s"
                    ,appId,osType,matchPeriod,channelId,appPackageName));
        }

    }
}
