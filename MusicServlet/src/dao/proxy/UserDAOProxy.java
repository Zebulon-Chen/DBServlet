package dao.proxy;

import dao.IUserDAO;
import dao.impl.UserDAOImpl;
import dbc.DatabaseConnection;
import javafx.util.Pair;
import vo.User;

public class UserDAOProxy implements IUserDAO {
    private DatabaseConnection dbc = null;
    private IUserDAO dao = null;
    
    //��������ʵ�����ݿ�����ӣ�ͬʱ��Ϊfactory��ʵ�ʵ��õ���
    public UserDAOProxy() {       //���췽����ʵ�������ӣ�ͬʱʵ����dao����
        try {
            this.dbc = new DatabaseConnection();    // �������ݿ�
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new UserDAOImpl(this.dbc.getConnection());  //ʵ������ʵ������
    }
    
    @Override
    public Pair<Boolean, Integer> findLogin(User user) throws Exception{  // ʵ�ֽӿ��еķ�����
        Pair<Boolean, Integer> pair=new Pair<Boolean, Integer>(false, 0);
        try{
        	pair = this.dao.findLogin(user);  // ������ʵ����
        }catch(Exception e){
            throw e;                           //�����׳��쳣
        }finally{
            this.dbc.close();
        }
        return pair; //���ر��
    }
	@Override
	public int signUp(User user) throws Exception {
		int res;
		try{
            res=this.dao.signUp(user);  // ������ʵ����
        }catch(Exception e){
            throw e;                           //�����׳��쳣
        }finally{
            this.dbc.close();
        }
		return res;
	}
}
