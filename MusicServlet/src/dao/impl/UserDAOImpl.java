package dao.impl;

import java.sql.*;
import vo.User;
import dao.IUserDAO;
import javafx.util.Pair;
/**
 *
 * DAOʵ���࣬ʵ�ַ����������������ݿ�ľ�������
 *
 */
public class UserDAOImpl implements IUserDAO{
    private Connection conn = null;         //�������ݿ�����Ӷ���
    public UserDAOImpl(Connection conn){    // ���췽�����������ݿ�����
        this.conn = conn;
    }
    /**
     * ���������������ѯ
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
        	//�ȼ��ע���û����Ƿ��Ѵ���
        	Statement statement = conn.createStatement();  
        	String sqlQuery="SELECT u_name FROM user WHERE u_name = '"+user.getName()+"'";
        	ResultSet resultSet=statement.executeQuery(sqlQuery);
        	if(resultSet.next())
        		return 0;//ע���û����Ѵ��ڣ����ش���0
        	
        	//�����ڽ��в������
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