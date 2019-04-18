package dbc;

import java.sql.*;
/**
 *
 * �������ݿ�
 *
 */
public class DatabaseConnection {
    // �������ݿ���������
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    // ���ݿ����ӵ�ַ
    private static final String DBURL = "jdbc:mysql://127.0.0.1/musiclibrary?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static final String DBUSER = "root";            // ���ݿ������û���
    private static final String DBPASSWORD = "1225";  // ���ݿ���������

    private Connection conn = null;      //�������ݿ����Ӷ���
    
    public DatabaseConnection() throws Exception{     //���캯��
        try{
            Class.forName(DBDRIVER);   // ������������
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);  // ȡ�����ݿ�����
        }catch(Exception e){
            throw e;
        }
    }
    
    public Connection getConnection() { //ȡ�����ݿ�����
        return this.conn;
    }
    
    public void close() throws Exception { // �ر����ݿ����
        if(this.conn != null){          // ����NullPointerException
            try{
                this.conn.close();       // �ر����ݿ�
            }catch(Exception e){
                throw e;               // �׳��쳣
            }
        }
    }
}