package dao.impl;

import java.sql.*;
import vo.User;
import dao.IUserDAO;
import javafx.util.Pair;
/**
 *
 * DAO实现类，实现方法，但不负责数据库的具体连接
 *
 */
public class UserDAOImpl implements IUserDAO{
    private Connection conn = null;         //定义数据库的连接对象
    public UserDAOImpl(Connection conn){    // 构造方法，设置数据库连接
        this.conn = conn;
    }
    /**
     * 具体操作方法：查询
     */
    public Pair<Boolean, Integer> findLogin(User user) throws Exception{
        boolean flag = false;
        int u_id=0;
        
        try{
        	Statement statement = conn.createStatement();  
        	String sqlQuery="SELECT u_name,u_id FROM user WHERE u_name = '"+user.getName()+"' AND u_password=ENCODE('"+user.getPassword()+"','key')";
        	ResultSet resultSet=statement.executeQuery(sqlQuery);
        	if(resultSet.next()){
        		flag=true;
        		u_id=resultSet.getInt("u_id");
        	}
        }catch(Exception e){
            throw e;
        }
        Pair<Boolean, Integer> pair=new Pair<Boolean, Integer>(flag, u_id);
        return pair;
    }
    
	@Override
	public int signUp(User user) throws Exception {
        try{
        	//先检查注册用户名是否已存在
        	Statement statement = conn.createStatement();  
        	String sqlQuery="SELECT u_name FROM user WHERE u_name = '"+user.getName()+"'";
        	ResultSet resultSet=statement.executeQuery(sqlQuery);
        	if(resultSet.next())
        		return 0;//注册用户名已存在，返回代码0
        	
        	//不存在进行插入操作
            String sqlExec = "insert into user (u_name,u_email,u_mobile,u_password,u_img) "
            		+ "values('"  + user.getName() + "','" + user.getEmail() + "','" 
            		+user.getMobile()+"',ENCODE('"+user.getPassword()+"','key'),'default_img')";
            if(statement.executeUpdate(sqlExec)>0)
            	return 1;
            else
            	return 2;
        }catch(Exception e){
            throw e;
        }
	}
}