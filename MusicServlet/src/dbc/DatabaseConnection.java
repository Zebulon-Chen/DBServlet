package dbc;

import java.sql.*;
/**
 *
 * 连接数据库
 *
 */
public class DatabaseConnection {
    // 定义数据库驱动程序
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    // 数据库连接地址
    private static final String DBURL = "jdbc:mysql://127.0.0.1/musiclibrary?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static final String DBUSER = "root";            // 数据库连接用户名
    private static final String DBPASSWORD = "1225";  // 数据库连接密码

    private Connection conn = null;      //声明数据库连接对象
    
    public DatabaseConnection() throws Exception{     //构造函数
        try{
            Class.forName(DBDRIVER);   // 加载驱动程序
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);  // 取得数据库连接
        }catch(Exception e){
            throw e;
        }
    }
    
    public Connection getConnection() { //取得数据库连接
        return this.conn;
    }
    
    public void close() throws Exception { // 关闭数据库操作
        if(this.conn != null){          // 避免NullPointerException
            try{
                this.conn.close();       // 关闭数据库
            }catch(Exception e){
                throw e;               // 抛出异常
            }
        }
    }
}