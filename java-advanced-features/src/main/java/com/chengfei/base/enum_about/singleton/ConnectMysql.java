package com.chengfei.base.enum_about.singleton;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public enum ConnectMysql {
    INSTANCE;
    private static BasicDataSource dataSource = null;
    private static String url;
    private static String userName;
    private static String password;

    public void setDataSource(String url, String userName, String password) throws Exception {
        this.url = url;
        this.userName = userName;
        this.password = password;
        init();
    }

    private void init() throws Exception {
        if (dataSource == null || dataSource.isClosed()) {
            Properties properties = new Properties();
            properties.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
            properties.setProperty("url", url);
            properties.setProperty("username", userName);
            properties.setProperty("password", password);
            properties.setProperty("maxActive", "6");
            properties.setProperty("maxIdle", "4");
            properties.setProperty("maxWait", "60000");
            properties.setProperty("removeAbandoned", "false");
            properties.setProperty("removeAbandonedTimeout", "120");
            properties.setProperty("testOnBorrow", "true");
            properties.setProperty("logAbandoned", "true");
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }
    }

    public Connection getConnection() throws Exception {
        if (dataSource == null || dataSource.isClosed()) {
            init();
        }
        Connection conn = dataSource.getConnection();
        conn.setAutoCommit(false);
        return conn;
    }

    public void closeResources(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closePool() {
        try {
            if (dataSource != null) {
                dataSource.close();
                dataSource = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
